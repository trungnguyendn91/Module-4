package com.codegym.model.employee;

import com.codegym.model.contract.Contract;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.Collection;

@Entity
@Table (name = "nhan_vien")
public class Employee {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_nhan_vien")
    private Integer idEmployee;
    @Column (name = "ho_ten")
    private String nameEmployee;
    @Column (name = "ngay_sinh")
    private LocalDate birthdayEmployee;
    @Column (name = "so_cmnd")
    private int idCardEmployee;
    @Column (name = "luong")
    private double salary;
    @Column (name = "so_dien_thoai")
    private int phoneEmployee;
    @Column (name = "email")
    private String emailEmployee;
    @Column (name = "dia_chi")
    private String addressEmployee;

    @Column (name = "status")
    private Boolean status = true;

    @ManyToOne
    @JoinColumn (name = "ma_vi_tri",  referencedColumnName = "ma_vi_tri")
    private  Position position;


    @ManyToOne
    @JoinColumn (name = "ma_trinh_do", referencedColumnName = "ma_trinh_do")
    private Education education;


    @ManyToOne
    @JoinColumn (name = "ma_bo_phan", referencedColumnName = "ma_bo_phan")
    private Department department;

    @OneToMany (mappedBy = "employee")
    private Collection<Contract> contractList;
    public Employee() {
    }

    public Employee(Integer idEmployee, String nameEmployee, LocalDate birthdayEmployee,
                    int idCardEmployee, double salary, int phoneEmployee, String emailEmployee, String addressEmployee, Position position, Education education, Department department) {
        this.idEmployee = idEmployee;
        this.nameEmployee = nameEmployee;
        this.birthdayEmployee = birthdayEmployee;
        this.idCardEmployee = idCardEmployee;
        this.salary = salary;
        this.phoneEmployee = phoneEmployee;
        this.emailEmployee = emailEmployee;
        this.addressEmployee = addressEmployee;
        this.position = position;
        this.education = education;
        this.department = department;
    }
}
