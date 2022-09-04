package com.codegym.model.facility;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "loai_dich_vu")
public class ServiceType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_loai_dich_vu")
    private int serviceTypeId;
    @Column (name = "ten_loai_dich_vu")
    private String serviceTypeName;
    @OneToMany(mappedBy = "serviceType")
    private List<Facility> facilityList;

    public ServiceType() {
    }

    public ServiceType(int serviceTypeId, String serviceTypeName, List<Facility> facilityList) {
        this.serviceTypeId = serviceTypeId;
        this.serviceTypeName = serviceTypeName;
        this.facilityList = facilityList;
    }

    public int getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(int serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    public String getServiceTypeName() {
        return serviceTypeName;
    }

    public void setServiceTypeName(String serviceTypeName) {
        this.serviceTypeName = serviceTypeName;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
