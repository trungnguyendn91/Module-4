package com.example.repository;

import com.example.model.MedicalDeclaration;


import java.util.List;

public interface IMedicalDeclarationRepository {
    public List<String> year();
    public List<String> month();
    public List<String> day();
    public List<String> nationality();
    public List<String> gender();
    public List<String> informationVehicle();
}
