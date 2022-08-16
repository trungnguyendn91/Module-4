package com.example.repository;

import java.util.List;

public interface ICondimentsRepository {
    List<String> findAllCondiments();
    List<String> saveCondiments(String[] condiments);
}
