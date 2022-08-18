package com.example.service;
import com.example.model.Person;

import java.util.List;

public interface IPerson {
    public List<String> year();
    public List<String> month();
    public List<String> day();
    public List<String> nationality();
    public List<String> gender();
    public List<String> informationVehicle();
    Person findById(Integer id);
    List<Person> findAll();
    void update(Person personObj);

    void save(Person personObj);
}
