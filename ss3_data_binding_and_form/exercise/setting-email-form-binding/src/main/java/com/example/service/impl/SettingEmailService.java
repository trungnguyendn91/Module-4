package com.example.service.impl;

import com.example.model.Setting;
import com.example.repository.ISettingEmailRepository;
import com.example.service.ISettingEmail;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class SettingEmailService implements ISettingEmail {
    @Autowired
    private ISettingEmailRepository iSettingEmailRepository;
    @Override
    public List<String> language() {
        return iSettingEmailRepository.language();
    }

    @Override
    public List<Integer> pageSize() {
        return iSettingEmailRepository.pageSize();
    }

    @Override
    public List<Setting> findAllSetting() {
        return iSettingEmailRepository.findAllSetting();
    }
}
