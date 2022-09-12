package com.codegym.repository;

import com.codegym.model.contract.DetailContract;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface IDetailContractRepository extends JpaRepository<DetailContract, Integer> {
    List<DetailContract> findAllByContract_IdContract(Integer id);
}
