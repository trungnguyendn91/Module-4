package com.codegym.repository;


import com.codegym.model.contract.AttachService;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface IAttachServiceRepository extends JpaRepository<AttachService, Integer> {
    @Query(value = "select * from dich_vu_di_kem dvdk " +
            " join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem " +
            " join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong " +
            " where hd.ma_hop_dong = :id ",
            countQuery = "select count(*) from dich_vu_di_kem dvdk " +
                    " join hop_dong_chi_tiet hdct on dvdk.ma_dich_vu_di_kem = hdct.ma_dich_vu_di_kem " +
                    " join hop_dong hd on hdct.ma_hop_dong = hd.ma_hop_dong " +
                    " where hd.ma_hop_dong = :id ",nativeQuery = true)
    List<AttachService> findAllAttachFacility(@Param("id") int id);
}
