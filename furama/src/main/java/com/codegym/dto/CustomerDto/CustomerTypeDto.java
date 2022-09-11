package com.codegym.dto.CustomerDto;

import javax.persistence.Column;

public class CustomerTypeDto {
    private Integer idGuestType;

    private String guestTypeName;

    public CustomerTypeDto() {
    }

    public CustomerTypeDto(Integer idGuestType, String guestTypeName) {
        this.idGuestType = idGuestType;
        this.guestTypeName = guestTypeName;
    }

    public Integer getIdGuestType() {
        return idGuestType;
    }

    public void setIdGuestType(Integer idGuestType) {
        this.idGuestType = idGuestType;
    }

    public String getGuestTypeName() {
        return guestTypeName;
    }

    public void setGuestTypeName(String guestTypeName) {
        this.guestTypeName = guestTypeName;
    }
}
