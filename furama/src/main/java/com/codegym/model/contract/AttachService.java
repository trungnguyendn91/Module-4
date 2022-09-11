package com.codegym.model.contract;

import javax.persistence.*;
import java.util.Collection;
import java.util.Optional;

@Entity
@Table (name = "dich_vu_di_kem")
public class AttachService {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_dich_vu_di_kem")
    private Integer idAttachService;
    @Column  (name = "ten_dich_vu_di_kem")
    private String nameAttachService;
    @Column (name = "gia")
    private Double cost;
    @Column(name = "don_vi")
    private String unit;
    @Column (name = "trang_thai")
    private String status;
    @OneToMany( mappedBy = "attachService")
    Collection<DetailContract> detailContractList;

    public AttachService() {
    }

    public AttachService(Integer idAttachService, String nameAttachService, Double cost, String unit,
                         String status, Collection<DetailContract> detailContractList) {
        this.idAttachService = idAttachService;
        this.nameAttachService = nameAttachService;
        this.cost = cost;
        this.unit = unit;
        this.status = status;
        this.detailContractList = detailContractList;
    }

    public Integer getIdAttachService() {
        return idAttachService;
    }

    public void setIdAttachService(Integer idAttachService) {
        this.idAttachService = idAttachService;
    }

    public String getNameAttachService() {
        return nameAttachService;
    }

    public void setNameAttachService(String nameAttachService) {
        this.nameAttachService = nameAttachService;
    }

    public Double getCost() {
        return cost;
    }

    public void setCost(Double cost) {
        this.cost = cost;
    }

    public String getUnit() {
        return unit;
    }

    public void setUnit(String unit) {
        this.unit = unit;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Collection<DetailContract> getDetailContractList() {
        return detailContractList;
    }

    public void setDetailContractList(Collection<DetailContract> detailContractList) {
        this.detailContractList = detailContractList;
    }
}
