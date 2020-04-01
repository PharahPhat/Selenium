package com.sandata.batch;

import com.sandata.core.report.ExtentTestManager;
import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.lang3.StringUtils;
import org.apache.log4j.Logger;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.math.BigDecimal;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.*;

public class OracleColumnMapper<T> {
    private static Logger LOGGER = Logger.getLogger(OracleColumnMapper.class);
    public final Class<T> clazz;
    public final List<Field> fields;

    public OracleColumnMapper(Class<T> clazz) {
        this.clazz = clazz;
        this.fields = this.getAllFields(clazz);
    }

    public static void setFieldValue(Object obj, Field field, String rawValue) throws IllegalAccessException, InvocationTargetException {
        Class<?> fieldType = field.getType();
        if (Objects.equals(fieldType, String.class)) {
            field.set(obj, rawValue);
        } else if (Objects.equals(fieldType, Date.class)) {
            if (StringUtils.isEmpty(rawValue)) {
                field.set(obj, null);
            }
        } else if (Objects.equals(fieldType, BigDecimal.class)) {
            if (StringUtils.isEmpty(rawValue)) {
                field.set(obj, null);
            } else {
                try {
                    field.set(obj, BigDecimal.valueOf(Double.parseDouble(rawValue)));
                } catch (NumberFormatException var7) {
                    LOGGER.error("Invalid BigDecimal value");
                    field.set(obj, null);
                }
            }
        } else if (!StringUtils.isEmpty(rawValue)) {
            BeanUtils.setProperty(obj, field.getName(), rawValue);
        }
    }

    public List<Field> getAllFields(Class clazz) {
        List<Field> myFields = new ArrayList();
        Class currentClass = clazz;

        do {
            myFields.addAll(Arrays.asList(currentClass.getDeclaredFields()));
            currentClass = currentClass.getSuperclass();
        } while (currentClass != null);

        return myFields;
    }

    public List<T> map(ResultSet resultSet) throws SQLException, IllegalAccessException, InstantiationException, InvocationTargetException {
        ArrayList result = new ArrayList();

        while (resultSet.next()) {
            Object rs = null;

            try {
                rs = this.clazz.getDeclaredConstructor().newInstance();
            } catch (NoSuchMethodException var9) {
                LOGGER.error(var9.getMessage());
            }

            Iterator var4 = this.fields.iterator();

            while (var4.hasNext()) {
                Field f = (Field) var4.next();
                OracleColumn mapping = (OracleColumn) f.getAnnotation(OracleColumn.class);
                if (!Objects.isNull(mapping)) {
                    LOGGER.info("mapping" + mapping.value());
                    String mappingValue = mapping.value().isEmpty() ? StringUtils.capitalize(f.getName()) : mapping.value();
                    Object rsValue = resultSet.getObject(mappingValue);
                    f.setAccessible(true);
                    f.set(rs, rsValue);
                }
            }

            result.add(rs);
        }

        return result;
    }

    public List<T> DataTableMapper(ResultSet resultSet) {
        ArrayList result = new ArrayList();

        try {
            while (resultSet.next()) {
                T rs = null;
                rs = this.clazz.getDeclaredConstructor().newInstance();
                Iterator var4 = this.fields.iterator();

                while (var4.hasNext()) {
                    Field f = (Field) var4.next();
                    OracleColumn mapping = (OracleColumn) f.getAnnotation(OracleColumn.class);
                    if (!Objects.isNull(mapping)) {
                        String mappingValue = mapping.value().isEmpty() ? StringUtils.capitalize(f.getName()) : mapping.value();
                        Object rsValue = resultSet.getObject(mappingValue);
                        f.setAccessible(true);
                        f.set(rs, rsValue);
                    }
                }
                result.add(rs);
            }
        } catch (NoSuchMethodException var9) {
            LOGGER.error(var9.getMessage());
        } catch (Exception var10) {
            LOGGER.error(var10.getMessage());
            ExtentTestManager.logTestStep(var10.getMessage());
        }

        return result;
    }
}