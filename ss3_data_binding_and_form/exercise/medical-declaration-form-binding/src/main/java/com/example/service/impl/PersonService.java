package com.example.service.impl;


import com.example.model.Person;
import com.example.repository.IPersonRepository;
import com.example.service.IPerson;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class PersonService implements IPerson {
    @Autowired
    private IPersonRepository iPersonRepository;

    @Override
    public List<String> year() {
        return iPersonRepository.year();
    }

    @Override
    public List<String> month() {
        return iPersonRepository.month();
    }

    @Override
    public List<String> day() {
        return iPersonRepository.day();
    }

    @Override
    public List<String> nationality() {
        return iPersonRepository.nationality();
    }

    @Override
    public List<String> gender() {
        return iPersonRepository.gender();
    }

    @Override
    public List<String> informationVehicle() {
        return iPersonRepository.informationVehicle();
    }

    @Override
    public Person findById(Integer id) {
        return iPersonRepository.findById(id);
    }

    @Override
    public List<Person> findAll() {
        return iPersonRepository.findAll();
    }

    @Override
    public void update(Person personObj) {
        iPersonRepository.update(personObj);
    }

    @Override
    public void save(Person personObj) {
        iPersonRepository.save(personObj);
    }
}
