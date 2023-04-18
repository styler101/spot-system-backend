package br.com.aircnc.aircnc.utils;

import java.util.Arrays;

public class Formatters {

    public static String parseArrayStringToString(String[] data){
        String finalResult = null;
        for(int i = 0; i < data.length; i++){
          finalResult = String.join(",", data);
        }
        return finalResult;
    }

    public static String[] parseStringToArrayString(String value){
        String[] result = value.split(",");
        return result;
    }
}
