package com.codegym.dto;


import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;

import javax.validation.constraints.*;
import java.time.LocalDate;
import java.time.Period;

public class FormDTO implements Validator {

    @NotBlank (message = "Vui lòng nhập họ!")
    @Size (min = 5, max = 45)
    private String firstName;

    @NotBlank (message = "Vui lòng nhập tên!")
    @Size (min = 5, max = 45)
    private String lastName;

    @NotNull(message = "nhập ngày sinh")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dayOfBirth;

    @NotBlank (message = "Vui lòng nhập email!")
    @Email
    private String email;

    @NotBlank (message = "Vui lòng nhập số CMND/CCCD!")
    @Pattern(regexp="(^$|[0-9]{10,12})", message = "Nhập 10 hoặc 12 số!!")
    private String idCard;

    @NotBlank(message = "Vui lòng nhập số điện thoại")
    @Pattern(regexp = "^(\\+84|0)\\d{9}$", message = "nhập sai định dạng" )
    private String phoneNumber;

    public FormDTO() {
    }

    public FormDTO(String firstName, String lastName, LocalDate dayOfBirth, String email, String idCard, String phoneNumber) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.dayOfBirth = dayOfBirth;
        this.email = email;
        this.idCard = idCard;
        this.phoneNumber = phoneNumber;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public LocalDate getDayOfBirth() {
        return dayOfBirth;
    }

    public void setDayOfBirth(LocalDate dayOfBirth) {
        this.dayOfBirth = dayOfBirth;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getIdCard() {
        return idCard;
    }

    public void setIdCard(String idCard) {
        this.idCard = idCard;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        FormDTO formDTO = (FormDTO) target;
        if (formDTO.dayOfBirth!=null){
            try{
                LocalDate now = LocalDate.now();
                if ((Period.between(formDTO.dayOfBirth,now).getYears())<18 ||
                        (Period.between(formDTO.dayOfBirth, now).getYears()>100)){
                    errors.rejectValue("dayOfBirth", "create.dateOfBirth",
                            "Sai định dạng!!!(custom)");
                }
            }catch (Exception e){
                errors.rejectValue("dayOfBirth", "create.birthday",
                        "Fill in the cell");
            }

        }
    }


}
