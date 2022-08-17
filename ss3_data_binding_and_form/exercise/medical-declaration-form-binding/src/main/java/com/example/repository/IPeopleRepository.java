package com.example.repository;

import com.example.model.People;

import java.util.List;

public interface IPeopleRepository {
    People findById (Integer id);
    List<People> findAll();
    void save(People peopleObj);
}
