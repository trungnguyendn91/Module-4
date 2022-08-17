package com.example.service.impl;


import com.example.repository.IMedicalDeclarationRepository;
import com.example.service.IMedicalDeclaration;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class MedicalDeclarationService implements IMedicalDeclaration {
    @Autowired
    private IMedicalDeclarationRepository iMedicalDeclarationRepository;

    @Override
    public List<String> year() {
        return iMedicalDeclarationRepository.year();
    }

    @Override
    public List<String> month() {
        return iMedicalDeclarationRepository.month();
    }

    @Override
    public List<String> day() {
        return iMedicalDeclarationRepository.day();
    }

    @Override
    public List<String> nationality() {
        return iMedicalDeclarationRepository.nationality();
    }

    @Override
    public List<String> gender() {
        return iMedicalDeclarationRepository.gender();
    }

    @Override
    public List<String> informationVehicle() {
        return iMedicalDeclarationRepository.informationVehicle();
    }
}
