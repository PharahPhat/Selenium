package com.sandata.db;

import java.util.ArrayList;
import java.util.List;

public class AccountDbService {
    private AccountDbService(){}
    public static <T> List<T> getListForASpecificName(String fName, String lName, List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(fName) && object.toString().contains(lName)) {
                objects.add(object);
            }
        }
        return objects;
    }

    public static <T> List<T> getListForASpecificClientPhone( String clientPhone, List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(clientPhone)) {
                objects.add(object);
            }
        }
        return objects;
    }

    public static <T> List<T> getListForASpecificClientProg(String payerId, String providerId,
                                                            String clientId, String payerProgram,
                                                            List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(payerId) && object.toString().contains(providerId)
                    && object.toString().contains(clientId) && object.toString().contains(payerProgram)) {
                objects.add(object);
            }
        }
        return objects;
    }

    public static <T> List<T> getListForASpecificClientAddr(String address1, List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(address1)) {
                objects.add(object);
            }
        }
        return objects;
    }

    public static <T> List<T> getListForASpecificUniqueKey( String keyValue, List<T> lstObject) {
        List<T> objects = new ArrayList<>();
        for (T object : lstObject) {
            if (object.toString().contains(keyValue)) {
                objects.add(object);
            }
        }
        return objects;
    }
}
