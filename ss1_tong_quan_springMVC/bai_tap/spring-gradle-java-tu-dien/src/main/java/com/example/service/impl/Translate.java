package com.example.service.impl;

import com.example.repository.ITranslateRepository;
import com.example.repository.impl.TranslateRepository;
import com.example.service.ITranslate;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;
@Service
public class Translate implements ITranslate {
    ITranslateRepository iTranslateRepository = new TranslateRepository();
    @Override
    public String translate(String key) {
        return iTranslateRepository.translate(key);
    }
}
