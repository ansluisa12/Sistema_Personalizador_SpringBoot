package org.infatlan.personalizador.util;

import java.util.HashMap;
import java.util.Map;

public class ResponseUtil {

    public static Map<String, Object> getResponse(
        String status,
        String message, 
        String fieldError){

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("Status", status);
        response.put("Message", message);
        response.put("fieldError", fieldError);
        return response;

    }

    public static Map<String, Object> getResponse(
        String status,
        String message){

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("Status", status);
        response.put("Message", message);
        return response;

    }

    public static Map<String, Object> getResponse(
        String status,
        String message, 
        Object valueObject){

        Map<String, Object> response = new HashMap<String, Object>();
        response.put("Status", status);
        response.put("Message", message);
        response.put("Object", valueObject);
        return response;

    }

}