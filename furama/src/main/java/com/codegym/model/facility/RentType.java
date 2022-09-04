package com.codegym.model.facility;

import jdk.nashorn.internal.objects.annotations.Getter;
import jdk.nashorn.internal.objects.annotations.Setter;
import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@Entity
@Table (name = "kieu_thue")
public class RentType {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_kieu_thue")
    private int rentTypeId;
    @Column (name = "ten_kieu_thue")
    private String rentTypeName;
    @OneToMany(mappedBy = "rentalType")
    private List<Facility> facilityList;

    public RentType() {
    }

    public RentType(int rentTypeId, String rentTypeName, List<Facility> facilityList) {
        this.rentTypeId = rentTypeId;
        this.rentTypeName = rentTypeName;
        this.facilityList = facilityList;
    }

    public int getRentTypeId() {
        return rentTypeId;
    }

    public void setRentTypeId(int rentTypeId) {
        this.rentTypeId = rentTypeId;
    }

    public String getRentTypeName() {
        return rentTypeName;
    }

    public void setRentTypeName(String rentTypeName) {
        this.rentTypeName = rentTypeName;
    }

    public List<Facility> getFacilityList() {
        return facilityList;
    }

    public void setFacilityList(List<Facility> facilityList) {
        this.facilityList = facilityList;
    }
}
