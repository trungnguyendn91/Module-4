package com.codegym.repository;


import com.codegym.model.contract.Contract;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
@Repository
@Transactional
public interface IContractRepository extends JpaRepository<Contract, Integer> {
    Page<Contract> findAllByDateEndGreaterThanAndAndCustomer_CustomerNameContaining(LocalDate now, String name, Pageable pageable);
}
