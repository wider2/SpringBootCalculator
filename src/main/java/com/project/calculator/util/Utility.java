package com.project.calculator.util;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.project.calculator.model.CalcResult;
import com.project.calculator.model.ResponseResult;


public class Utility {

    public static boolean isNumericValue(String strNum) {
        if (strNum == null) {
            return false;
        }
        try {
            Double.parseDouble(strNum);
        } catch (NumberFormatException nfe) {
            return false;
        }
        return true;
    }

    public static String convertToJson(CalcResult calcResult) throws JsonProcessingException {
        return serializeIt(calcResult);
    }

    public static String convertToJson(ResponseResult responseResult) throws JsonProcessingException {
        return serializeIt(responseResult);
    }

    public static String serializeIt(Object object) throws JsonProcessingException {
        String jsonResult = null;
        ObjectMapper mapper = new ObjectMapper();

        try {
            jsonResult = mapper.writeValueAsString(object);
            System.out.println(jsonResult);

        } catch (JsonGenerationException | JsonMappingException e) {
            e.printStackTrace();
        }

        return jsonResult;
    }
}
