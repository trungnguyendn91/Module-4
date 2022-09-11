package com.codegym.dto.CustomerDto;

import com.codegym.util.DateTime18Util;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.validation.Errors;
import org.springframework.validation.Validator;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Pattern;
import java.time.LocalDate;

public class CustomerDto implements Validator {
    private int customerId;
    private CustomerTypeDto customerType;
    @NotBlank(message = "Vui lòng không để trống!")
    private String customerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")

    private LocalDate customerBirth;

    private boolean customerGender;

    private String customerIdCard;
    @NotBlank(message = "Vui lòng không để trống!")
    @Pattern(regexp = "^((090)|(091)|(\\\\(84\\\\)+90)|(\\\\(84\\\\)+91))[0-9]{7}$",
            message = "Vui lòng nhập đúng!")
    private String customerPhone;
    @NotBlank(message = "Vui lòng không để trống!")
    @Email(message = "Email phải đúng định dạng vd: abc@gmail.com")

    private String customerEmail;

    @NotBlank(message = "Vui lòng không để trống!")
    private String customerAddress;

    private Boolean status = true;

    public CustomerDto() {
    }

    public CustomerDto(int customerId, CustomerTypeDto customerType, String customerName,
                       LocalDate customerBirth, boolean customerGender, String customerIdCard,
                       String customerPhone, String customerEmail, String customerAddress, Boolean status) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirth = customerBirth;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
        this.status = status;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerTypeDto getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerTypeDto customerType) {
        this.customerType = customerType;
    }

    public String getCustomerName() {
        return customerName;
    }

    public void setCustomerName(String customerName) {
        this.customerName = customerName;
    }

    public LocalDate getCustomerBirth() {
        return customerBirth;
    }

    public void setCustomerBirth(LocalDate customerBirth) {
        this.customerBirth = customerBirth;
    }

    public boolean isCustomerGender() {
        return customerGender;
    }

    public void setCustomerGender(boolean customerGender) {
        this.customerGender = customerGender;
    }

    public String getCustomerIdCard() {
        return customerIdCard;
    }

    public void setCustomerIdCard(String customerIdCard) {
        this.customerIdCard = customerIdCard;
    }

    public String getCustomerPhone() {
        return customerPhone;
    }

    public void setCustomerPhone(String customerPhone) {
        this.customerPhone = customerPhone;
    }

    public String getCustomerEmail() {
        return customerEmail;
    }

    public void setCustomerEmail(String customerEmail) {
        this.customerEmail = customerEmail;
    }

    public String getCustomerAddress() {
        return customerAddress;
    }

    public void setCustomerAddress(String customerAddress) {
        this.customerAddress = customerAddress;
    }

    public Boolean getStatus() {
        return status;
    }

    public void setStatus(Boolean status) {
        this.status = status;
    }
    @Override
    public boolean supports(Class<?> clazz) {
        return false;
    }

    @Override
    public void validate(Object target, Errors errors) {
        CustomerDto customerDto = (CustomerDto) target;

        DateTime18Util.checkDate(target, errors);

        String name = customerDto.getCustomerName();
        if (!name.matches("^[A-Z][A-Za-z]*(\\s[A-Z][A-Za-z]*){0,20}$")) {
            errors.rejectValue("customerName", "customerName.create", "Ký tự đầu tiên mỗi từ phải viết hoa");
        }

        String idCard = customerDto.getCustomerIdCard();
        if (!idCard.matches("^[0-9]{9}|[0-9]{12}$")) {
            errors.rejectValue("customerIdCard", "idCard.create", "CMND phải theo định dạng 9 hoặc 12 số");
        }

    }
}
