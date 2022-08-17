package com.example.repository.impl;

import com.example.model.MedicalDeclaration;
import com.example.repository.IMedicalDeclarationRepository;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

@Service
public class MedicalDeclarationServiceRepository implements IMedicalDeclarationRepository {
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

        for (int i = 1940; i <= LocalDate.now().getYear(); i++) {
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
}






