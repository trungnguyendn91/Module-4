package com.example.model;

import java.time.Year;

public class Person {
    private int id;
    private String name;
    private String year;
    private String startYear;
    private String endYear;
    private String gender;
    private String nationality;
    private String idCard;
    private String informationVehicle;
    private String vehicleNumber;
    private String seatNumber;
    private String startDay;
    private String endDay;
    private String startMonth;
    private String endMonth;
    private String info;

    public Person() {
    }



    public Person(int id, String name, String year, String startYear, String endYear, String gender,
                  String nationality, String idCard, String informationVehicle,
                  String vehicleNumber, String seatNumber, String startDay, String endDay,
                  String startMonth, String endMonth, String info) {
        this.id = id;
        this.name = name;
        this.year = year;
        this.startYear = startYear;
        this.endYear = endYear;
        this.gender = gender;
        this.nationality = nationality;
        this.idCard = idCard;
        this.informationVehicle = informationVehicle;
        this.vehicleNumber = vehicleNumber;
        this.seatNumber = seatNumber;
        this.startDay = startDay;
        this.startMonth = startMonth;
        this.endMonth = endMonth;
        this.info = info;
        this.endDay = endDay;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getStartYear() {
        return startYear;
    }

    public void setStartYear(String startYear) {
        this.startYear = startYear;
    }

    public String getEndYear() {
        return endYear;
    }

    public void setEndYear(String endYear) {
        this.endYear = endYear;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getNationality() {
        return nationality;
    }

    public void setNationality(String nationality) {
        this.nationality = nationality;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getInformationVehicle() {
        return informationVehicle;
    }

    public void setInformationVehicle(String informationVehicle) {
        this.informationVehicle = informationVehicle;
    }

    public String getVehicleNumber() {
        return vehicleNumber;
    }

    public void setVehicleNumber(String vehicleNumber) {
        this.vehicleNumber = vehicleNumber;
    }

    public String getSeatNumber() {
        return seatNumber;
    }

    public void setSeatNumber(String seatNumber) {
        this.seatNumber = seatNumber;
    }

    public String getStartDay() {
        return startDay;
    }

    public void setStartDay(String startDay) {
        this.startDay = startDay;
    }

    public String getStartMonth() {
        return startMonth;
    }

    public void setStartMonth(String startMonth) {
        this.startMonth = startMonth;
    }

    public String getInfo() {
        return info;
    }

    public void setInfo(String info) {
        this.info = info;
    }
    public String getEndDay() {
        return endDay;
    }

    public void setEndDay(String endDay) {
        this.endDay = endDay;
    }

    public String getEndMonth() {
        return endMonth;
    }

    public void setEndMonth(String endMonth) {
        this.endMonth = endMonth;
    }
}