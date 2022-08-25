package com.codegym.service.impl;

import com.codegym.model.Form;
import com.codegym.repository.IFormRepository;
import com.codegym.service.IFormService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

@Service
public class FormService implements IFormService {
    @Autowired
    private IFormRepository formRepository;
    @Override
    public Page<Form> findAll(Pageable pageable) {
        return this.formRepository.findAll(pageable);
    }

    @Override
    public void save(Form formObj) {
        this.formRepository.save(formObj);
    }
}
