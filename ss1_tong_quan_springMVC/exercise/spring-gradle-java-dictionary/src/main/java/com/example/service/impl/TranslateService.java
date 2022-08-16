package com.example.service.impl;

import com.example.repository.ITranslateRepository;
import com.example.service.ITranslate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
@Service
public class TranslateService implements ITranslate {
    @Autowired
    private ITranslateRepository iTranslateRepository;
    @Override
    public String translate(String key) {
        return iTranslateRepository.translate(key);
    }
}
