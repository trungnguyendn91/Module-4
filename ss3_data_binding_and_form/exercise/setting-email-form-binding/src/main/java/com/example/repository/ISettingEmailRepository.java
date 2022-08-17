package com.example.repository;

import com.example.model.Setting;

import java.util.List;

public interface ISettingEmailRepository {
    public List<String> language();
    public List<Integer> pageSize();
    List<Setting> findAllSetting();
}
