package com.sandata.batch;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import java.text.SimpleDateFormat;

@Retention(RetentionPolicy.RUNTIME)
@Target(ElementType.FIELD)
public @interface OracleColumn {
    String DEFAULT_DATE_FORMAT = "yyyy-MM-dd hh:mm:ss.SS";
    SimpleDateFormat DEFAULT = new SimpleDateFormat(DEFAULT_DATE_FORMAT);

    String value() default "";

    String dateFormat() default DEFAULT_DATE_FORMAT;
}
