package com.codegym.service;

import com.codegym.model.Form;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

public interface IFormService {
    Page<Form> findAll (Pageable pageable);
    void  save(Form formObj);

}
