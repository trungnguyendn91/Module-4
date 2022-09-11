package com.codegym.repository;

import com.codegym.model.contract.DetailContract;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IDetailContractRepository extends JpaRepository<DetailContract, Integer> {
}
