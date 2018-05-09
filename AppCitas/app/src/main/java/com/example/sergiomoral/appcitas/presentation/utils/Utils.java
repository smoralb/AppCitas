package com.example.sergiomoral.appcitas.presentation.utils;

/**
 * Created by sergiomoral on 2/5/18.
 */

public class Utils {

    private static final String STREET = "CL";
    private static final String AVENUE = "AV";


    public Utils() {
    }

    public static String addressFormat(String streetType, String localidad, String road, String city, String num, String zipCode) {
        switch (streetType) {
            case STREET:
                return "C/".concat(road).concat(",").concat(num).concat("\n").concat(localidad)
                        .concat(",").concat(city).concat(",").concat(zipCode);
            case AVENUE:
                return "AV/".concat(road).concat(",").concat(num).concat("\n").concat(localidad)
                        .concat(",").concat(city).concat(",").concat(zipCode);
            default:
                return "--";
        }
    }
}
