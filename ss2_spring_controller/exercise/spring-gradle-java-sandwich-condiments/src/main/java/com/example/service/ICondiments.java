package com.example.service;

import java.util.List;

public interface ICondiments {
    List<String> findAllCondiments();
    List<String> saveCondiments(String[] condiments);
}
