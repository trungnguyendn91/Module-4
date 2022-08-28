package com.codegym.model.customer;



import javax.persistence.*;
import java.util.Collection;
import java.util.List;
@Entity
@Table (name = "loai_khach")
public class CustomerType {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column (name = "ma_loai_khach_hang")
    private Integer idGuestType;
    @Column (name ="ten_loai_khach_hang")
    private String guestTypeName;

    @OneToMany(mappedBy = "customerType")
    private Collection<Customer> customerList;

    public CustomerType() {
    }

    public CustomerType(Integer idGuestType, String guestTypeName, List<Customer> customerList) {
        this.idGuestType = idGuestType;
        this.guestTypeName = guestTypeName;
        this.customerList = customerList;
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

    public Collection<Customer> getCustomerList() {
        return customerList;
    }

    public void setCustomerList(List<Customer> customerList) {
        this.customerList = customerList;
    }
}
