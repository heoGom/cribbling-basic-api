package com.example.scribblingapi.core.util;

import java.util.HashMap;
import java.util.Map;

public class Resp {
    public static Map<String, String> reason(String reason){
        Map<String, String> response = new HashMap<>();
        response.put("reason", reason);
        return response;
    }
}
