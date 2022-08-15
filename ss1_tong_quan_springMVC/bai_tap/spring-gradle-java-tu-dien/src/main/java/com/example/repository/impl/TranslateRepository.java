package com.example.repository.impl;

import com.example.repository.ITranslateRepository;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
public class TranslateRepository implements ITranslateRepository {
    private static Map<String, String> dictionary = new HashMap<>();
    static {
        dictionary.put("Hello","Xin chào");
        dictionary.put("Dog","Con chó");
        dictionary.put("Cat","Con mèo");
        dictionary.put("House","Căn nhà");
        dictionary.put("River","Dòng sông");
        dictionary.put("Tree","Cây");
        dictionary.put("Blue","Màu xanh");
    }
    @Override
    public String translate(String key) {
        String result = null;
        for (Map.Entry<String, String> entry : dictionary.entrySet()) {
            if (key.equalsIgnoreCase(entry.getKey())) {
                result = entry.getValue();
            }
        }
        return result;
    }
}
