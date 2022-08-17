package com.example.repository.impl;

import com.example.model.Setting;
import com.example.repository.ISettingEmailRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;
@Service
public class SettingEmailServiceRepository implements ISettingEmailRepository {
    private static List<String> languageList = new ArrayList<>();
    private static List<Integer> pageSizeList = new ArrayList<>();
    private static List<Setting> settingList = new ArrayList<>();

    static {
        languageList.add("English");
        languageList.add("Vietnamese");
        languageList.add("Japanese");
        languageList.add("Chinese");
        pageSizeList.add(5);
        pageSizeList.add(10);
        pageSizeList.add(15);
        pageSizeList.add(25);
        pageSizeList.add(50);
        pageSizeList.add(100);
    }

    @Override
    public List<String> language() {
        return languageList;
    }

    @Override
    public List<Integer> pageSize() {
        return pageSizeList;
    }

    @Override
    public List<Setting> findAllSetting() {
        return settingList;
    }

}
