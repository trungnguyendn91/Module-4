package com.example.repository.impl;

import com.example.model.Person;
import com.example.repository.IPersonRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.TreeMap;

@Service
public class PersonServiceRepository implements IPersonRepository {
    private static List<String> nationalityList = new ArrayList<>();
    private static List<String> genderList = new ArrayList<>();
    private static List<String> informationVehicleList = new ArrayList<>();
    private static List<String> yearList = new ArrayList<>();
    private static List<String> dayList = new ArrayList<>();
    private static List<String> monthList = new ArrayList<>();

    static {
        nationalityList.add("France");
        nationalityList.add("Viet Nam");
        nationalityList.add("Japan");
        nationalityList.add("UK");
        nationalityList.add("USA");
        nationalityList.add("Australia");
        nationalityList.add("China");
        nationalityList.add("Germany");
        genderList.add("Man");
        genderList.add("Woman");
        informationVehicleList.add("Máy bay");
        informationVehicleList.add("Tàu thuyền");
        informationVehicleList.add("Ô tô");
        informationVehicleList.add("Khác (Ghi rõ)");

        for (int i = 1; i <= 30; i++) {
            dayList.add(String.valueOf(i));

        }

        for (int i = 1; i <= 12; i++) {
            monthList.add(String.valueOf(i));
        }

        for (int i = LocalDate.now().getYear(); i >=1940 ; i--) {
            yearList.add(String.valueOf(i));
        }

    }

    @Override
    public List<String> year() {
        return yearList;
    }

    @Override
    public List<String> month() {
        return monthList;
    }

    @Override
    public List<String> day() {
        return dayList;
    }

    @Override
    public List<String> nationality() {
        return nationalityList;
    }

    @Override
    public List<String> gender() {
        return genderList;
    }

    @Override
    public List<String> informationVehicle() {
        return informationVehicleList;
    }

    static List<Person> personList;
    static {
        personList = new ArrayList<>();
        personList.add(new Person(111,"Trương Tam Phong", "1992", "2021","2021", "Man",
                "Viet Nam","2212312421321","Máy Bay", "CH777888",
                "G21","22","24","11","12","Đã đi từ Nha Trang về Vũng Tàu"));
        personList.add( new Person(222,"Lý Tầm Hoan", "1967", "2021","2022", "Man",
                "Viet Nam","223141245345","Máy Bay", "CH454888",
                "G22","22","24","12","1","Đã đi từ Đào Hoa Đảo về Biện Kinh"));

    }
    @Override
    public Person findById(Integer id) {
        for (Person p : personList) {
            if (p.getId() == id)
                return p;
        }
        return null;
    }


    @Override
    public List<Person> findAll() {
        return personList;
    }

    @Override
    public void save(Person personObj) {
        int id =(int) Math.floor(Math.random()*1000);
        personList.add(new Person(id,personObj.getName(),personObj.getYear(),personObj.getStartYear(),personObj.getEndYear()
        ,personObj.getGender(),personObj.getNationality(),personObj.getIdCard(),personObj.getInformationVehicle()
        ,personObj.getVehicleNumber(),personObj.getSeatNumber(),personObj.getStartDay(),personObj.getEndDay(),personObj.getStartMonth()
        ,personObj.getEndMonth(),personObj.getInfo()));
    }

    @Override
    public void update(Person personObj) {
        for (Person p : personList) {
            if (p.getId() == personObj.getId()) {
                p.setName(personObj.getName());
                p.setYear(personObj.getYear());
                p.setStartYear(personObj.getStartYear());
                p.setEndYear(personObj.getEndYear());
                p.setGender(personObj.getGender());
                p.setNationality(personObj.getNationality());
                p.setIdCard(personObj.getIdCard());
                p.setInformationVehicle(personObj.getIdCard());
                p.setVehicleNumber(personObj.getVehicleNumber());
                p.setSeatNumber(personObj.getSeatNumber());
                p.setStartDay(personObj.getStartDay());
                p.setEndDay(personObj.getEndDay());
                p.setStartDay(personObj.getStartMonth());
                p.setEndMonth(personObj.getEndMonth());
                p.setInfo(personObj.getInfo());
            }
        }
    }
}






