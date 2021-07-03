package com.tutorials;

import java.util.HashMap;
import java.util.Map;

public class MapProgram {
    public static void main(String[] args) {
        Map<String, String> languages = new HashMap<>();

        languages.put("Java", "Language description 1");
        languages.put("Python", "Language description 2");

        System.out.println(languages.containsKey("Java"));
        System.out.println("===========================");

        for (String key : languages.keySet()){
            System.out.println(key + " : " + languages.get(key));
        }

    }









}
