package com.codegym.model.customer;

import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import javax.validation.constraints.Email;
import java.time.LocalDate;

@Entity
@Table (name = "khach_hang")
public class Customer {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ma_khach_hang")
    private int customerId;
    @ManyToOne
    @JoinColumn ( name = "ma_loai_khach_hang",  referencedColumnName = "ma_loai_khach_hang" )
    private CustomerType customerType;
    @Column (name = "ho_ten")
    private String customerName;
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @Column (name = "ngay_sinh")
    private LocalDate customerBirth;
    @Column (name = "gioi_tinh")
    private boolean customerGender;
    @Column (name ="so_cmnd")
    private String customerIdCard;
    @Column (name= "so_dien_thoai")
    private String customerPhone;
    @Column (name = "email")
    @Email
    private String customerEmail;
    @Column (name= "dia_chi")
    private String customerAddress;


    public Customer() {
    }

    public Customer(int customerId, CustomerType customerType, String customerName, LocalDate customerBirth, boolean customerGender,
                    String customerIdCard, String customerPhone, String customerEmail, String customerAddress) {
        this.customerId = customerId;
        this.customerType = customerType;
        this.customerName = customerName;
        this.customerBirth = customerBirth;
        this.customerGender = customerGender;
        this.customerIdCard = customerIdCard;
        this.customerPhone = customerPhone;
        this.customerEmail = customerEmail;
        this.customerAddress = customerAddress;
    }

    public int getCustomerId() {
        return customerId;
    }

    public void setCustomerId(int customerId) {
        this.customerId = customerId;
    }

    public CustomerType getCustomerType() {
        return customerType;
    }

    public void setCustomerType(CustomerType customerType) {
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
}
