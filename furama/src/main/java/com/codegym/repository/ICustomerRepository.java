package com.codegym.repository;

import com.codegym.model.customer.Customer;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface ICustomerRepository extends JpaRepository <Customer, Integer> {
    @Query(value = "select * from khach_hang where ho_ten like concat('%',:keyword,'%') and `status` = 1", nativeQuery = true,
            countQuery = "select count(*) from (select * from khach_hang where ho_ten like concat('%',:keyword,'%') and `status` = 1) khach_hang")
    Page<Customer> findAllByName(@Param("keyword") String keywordVal, Pageable pageable);
//đởi tên mấy caius bảng ở đây lại giống data base ddi a
    @Query(value = "select * from customer where `status` = 1", nativeQuery = true)
    Page<Customer> findAll(Pageable pageable);
}

