package com.codegym.model.facility;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "dich_vu")
public class Facility {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_dich_vu")
    private int facilityId;
    @Column (name = "ten_dich_vu")
    private String facilityName;
    @Column (name = "dien_tich")
    private int facilityArea;
    @Column (name = "gia_thue")
    private double facilityCost;
    @Column (name = "so_nguoi_toi_da")
    private int facilityMaxPeople;
    @ManyToOne
    @JoinColumn (name = "ma_kieu_thue", referencedColumnName = "ma_kieu_thue")
    private RentType rentalType;
    @ManyToOne
    @JoinColumn (name = "ma_loai_dich_vu", referencedColumnName = "ma_loai_dich_vu")
    private ServiceType serviceType;
    @Column (name = "tieu_chuan_phong")
    private String standardRoom;
    @Column (name = "mo_ta_tien_nghi_khac")
    private String description;
    @Column (name = "dien_tich_ho_boi")
    private double poolArea;
    @Column (name = "so_tang")
    private int numberOfFloor;
    @Column (name = "dich_vu_mien_phi_di_kem")
    private String freeSerVice;

    @OneToMany (mappedBy = "facility")
    private Collection<Contract> contractList;

    public Facility() {
    }

    public Facility(int facilityId, String facilityName, int facilityArea, double facilityCost,
                    int facilityMaxPeople, RentType rentalType, ServiceType serviceType,
                    String standardRoom, String description, double poolArea, int numberOfFloor,
                    String freeSerVice) {
        this.facilityId = facilityId;
        this.facilityName = facilityName;
        this.facilityArea = facilityArea;
        this.facilityCost = facilityCost;
        this.facilityMaxPeople = facilityMaxPeople;
        this.rentalType = rentalType;
        this.serviceType = serviceType;
        this.standardRoom = standardRoom;
        this.description = description;
        this.poolArea = poolArea;
        this.numberOfFloor = numberOfFloor;
        this.freeSerVice = freeSerVice;
    }

    public int getFacilityId() {
        return facilityId;
    }

    public void setFacilityId(int facilityId) {
        this.facilityId = facilityId;
    }

    public String getFacilityName() {
        return facilityName;
    }

    public void setFacilityName(String facilityName) {
        this.facilityName = facilityName;
    }

    public int getFacilityArea() {
        return facilityArea;
    }

    public void setFacilityArea(int facilityArea) {
        this.facilityArea = facilityArea;
    }

    public double getFacilityCost() {
        return facilityCost;
    }

    public void setFacilityCost(double facilityCost) {
        this.facilityCost = facilityCost;
    }

    public int getFacilityMaxPeople() {
        return facilityMaxPeople;
    }

    public void setFacilityMaxPeople(int facilityMaxPeople) {
        this.facilityMaxPeople = facilityMaxPeople;
    }

    public RentType getRentalType() {
        return rentalType;
    }

    public void setRentalType(RentType rentalType) {
        this.rentalType = rentalType;
    }

    public ServiceType getServiceType() {
        return serviceType;
    }

    public void setServiceType(ServiceType serviceType) {
        this.serviceType = serviceType;
    }

    public String getStandardRoom() {
        return standardRoom;
    }

    public void setStandardRoom(String standardRoom) {
        this.standardRoom = standardRoom;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getPoolArea() {
        return poolArea;
    }

    public void setPoolArea(double poolArea) {
        this.poolArea = poolArea;
    }

    public int getNumberOfFloor() {
        return numberOfFloor;
    }

    public void setNumberOfFloor(int numberOfFloor) {
        this.numberOfFloor = numberOfFloor;
    }

    public String getFreeSerVice() {
        return freeSerVice;
    }

    public void setFreeSerVice(String freeSerVice) {
        this.freeSerVice = freeSerVice;
    }
}
