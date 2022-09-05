package com.codegym.service;

import com.codegym.model.Smartphone;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    Page<Smartphone> findAll(Pageable pageable);

    Optional findById(Integer id);

    void save(Smartphone smartphone);
    void remove(Integer id);
}
