package com.example.repository;


import com.example.model.Person;

import java.util.List;

public interface IPersonRepository {
     List<String> year();
     List<String> month();
     List<String> day();
     List<String> nationality();
     List<String> gender();
     List<String> informationVehicle();
     Person findById(Integer id);
     List<Person> findAll();
     void save(Person personObj);
     void update(Person personObj);
}
