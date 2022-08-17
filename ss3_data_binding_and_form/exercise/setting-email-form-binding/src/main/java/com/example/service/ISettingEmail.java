package com.example.service;

import com.example.model.Setting;

import java.util.List;

public interface ISettingEmail {
    public List<String> language();
    public List<Integer> pageSize();
    List<Setting> findAllSetting();
}
