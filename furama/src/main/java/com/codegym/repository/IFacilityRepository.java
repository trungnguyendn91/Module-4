package com.codegym.repository;

import com.codegym.model.facility.Facility;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;



public interface IFacilityRepository extends JpaRepository<Facility,Integer> {
    @Query(value = "select * from dich_vu where ten_dich_vu like concat('%',:keyword,'%') and `status` = 1", nativeQuery = true,
            countQuery = "select count(*) from (select * from dich_vu where ten_dich_vu like concat('%',:keyword,'%') and `status` = 1) khach_hang")
    Page<Facility> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);

    @Query(value = "select * from dich_vu where `status` = 1", nativeQuery = true)
    Page<Facility> findAll(Pageable pageable);
}
