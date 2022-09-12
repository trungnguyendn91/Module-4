package com.codegym.dto.facility;

import com.codegym.model.contract.Contract;
import com.codegym.model.facility.RentType;
import com.codegym.model.facility.ServiceType;
import com.codegym.util.Validation;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.validation.constraints.NotBlank;
import java.util.Collection;

public class FacilityDto implements Validator {

    private int facilityId;


    private String facilityName;

    private int facilityArea;

    private double facilityCost;

    private int facilityMaxPeople;

    private RentType rentalType;

    private ServiceType serviceType;

    private String standardRoom;

    private String description;

    private double poolArea;

    private int numberOfFloor;

    private String freeSerVice;

    public FacilityDto() {
    }

    public FacilityDto(int facilityId, String facilityName, int facilityArea,
                       double facilityCost, int facilityMaxPeople, RentType rentalType,
                       ServiceType serviceType, String standardRoom, String description,
                       double poolArea, int numberOfFloor, String freeSerVice) {
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

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FacilityDto facilityDto = (FacilityDto) target;

        String maxPeople = String.valueOf(facilityDto.getFacilityMaxPeople());
        Validation.checkInteger("facilityMaxPeople", maxPeople, errors);

        String area = String.valueOf((facilityDto.getFacilityArea()));
        Validation.checkInteger("facilityArea", area, errors);

        Double cost = facilityDto.getFacilityCost();
        Validation.checkDouble("facilityCost", cost, errors);

        String nameService = facilityDto.getFacilityName();
        Validation.checkFacilityName("facilityName", nameService, errors);

        if (facilityDto.getServiceType() != null) {
            Integer serviceTypeId = facilityDto.getServiceType().getServiceTypeId();
            if (serviceTypeId < 2) {
                Double areaPool = facilityDto.getPoolArea();
                Validation.checkDouble("poolArea", areaPool, errors);
            }
            if (serviceTypeId < 3) {
                String numberOfFloors = String.valueOf((facilityDto.getNumberOfFloor()));
                Validation.checkInteger("numberOfFloor", numberOfFloors, errors);
            }
        }
    }
}
