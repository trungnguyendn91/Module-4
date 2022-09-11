package com.codegym.model.contract;

import com.codegym.model.customer.Customer;
import com.codegym.model.employee.Employee;
import com.codegym.model.facility.Facility;
import org.springframework.format.annotation.DateTimeFormat;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

@Entity
@Table (name = "hop_dong")
public class Contract {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_hop_dong")
    private Integer idContract;

    @Column (name = "ngay_lam_hop_dong")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateSignContract;
    @Column (name = "ngay_ket_thuc")
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private LocalDate dateEnd;
    @Column (name = "tien_dat_coc")
    private Double deposit;
    @Transient
    private double totalMoney;


    @OneToMany (mappedBy = "contract")
    Collection<DetailContract> detailContractList;

    @ManyToOne
    @JoinColumn (name = "ma_nhan_vien", referencedColumnName = "ma_nhan_vien")
    private Employee employee;

    @ManyToOne
    @JoinColumn (name = "ma_khach_hang", referencedColumnName = "ma_khach_hang")
    private Customer customer;

    @ManyToOne
    @JoinColumn (name = "ma_dich_vu", referencedColumnName = "ma_dich_vu")
    private Facility facility;
    public Contract() {
    }

    public Contract(Integer idContract, LocalDate dateSignContract, LocalDate dateEnd,
                    Double deposit, double totalMoney,
                    Collection<DetailContract> detailContractList, Employee employee,
                    Customer customer, Facility facility) {
        this.idContract = idContract;
        this.dateSignContract = dateSignContract;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.totalMoney = totalMoney;
        this.detailContractList = detailContractList;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }




    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Customer getCustomer() {
        return customer;
    }

    public void setCustomer(Customer customer) {
        this.customer = customer;
    }

    public Facility getFacility() {
        return facility;
    }

    public void setFacility(Facility facility) {
        this.facility = facility;
    }

    public Contract(Integer idContract, LocalDate dateSignContract, LocalDate dateEnd,
                    Double deposit, Collection<DetailContract> detailContractList,
                    Employee employee, Customer customer, Facility facility) {
        this.idContract = idContract;
        this.dateSignContract = dateSignContract;
        this.dateEnd = dateEnd;
        this.deposit = deposit;
        this.detailContractList = detailContractList;
        this.employee = employee;
        this.customer = customer;
        this.facility = facility;
    }

    public void setIdContract(Integer idContract) {
        this.idContract = idContract;
    }

    public LocalDate getDateSignContract() {
        return dateSignContract;
    }

    public void setDateSignContract(LocalDate dateSignContract) {
        this.dateSignContract = dateSignContract;
    }

    public LocalDate getDateEnd() {
        return dateEnd;
    }

    public void setDateEnd(LocalDate dateEnd) {
        this.dateEnd = dateEnd;
    }

    public Double getDeposit() {
        return deposit;
    }

    public Integer getIdContract() {
        return idContract;
    }

    public double getTotalMoney() {
        return totalMoney;
    }

    public void setTotalMoney(double totalMoney) {
        this.totalMoney = totalMoney;
    }

    public void setDeposit(Double deposit) {
        this.deposit = deposit;
    }

    public Collection<DetailContract> getDetailContractList() {
        return detailContractList;
    }

    public void setDetailContractList(Collection<DetailContract> detailContractList) {
        this.detailContractList = detailContractList;
    }
}
