package com.codegym.repository;

import com.codegym.model.facility.ServiceType;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IServiceTypeRepository extends JpaRepository<ServiceType, Integer> {
}
