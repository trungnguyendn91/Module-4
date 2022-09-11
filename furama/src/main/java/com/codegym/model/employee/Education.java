package com.codegym.model.employee;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "trinh_do")
public class Education {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_trinh_do")
    private Integer idEducation;
    @Column (name = "ten_trinh_do")
    private String nameEducation;
    @OneToMany (mappedBy = "education")
    private Collection<Employee> employeeList;

    public Education() {
    }

    public Education(Integer idEducation, String nameEducation, Collection<Employee> employeeList) {
        this.idEducation = idEducation;
        this.nameEducation = nameEducation;
        this.employeeList = employeeList;
    }

    public Integer getIdEducation() {
        return idEducation;
    }

    public void setIdEducation(Integer idEducation) {
        this.idEducation = idEducation;
    }

    public String getNameEducation() {
        return nameEducation;
    }

    public void setNameEducation(String nameEducation) {
        this.nameEducation = nameEducation;
    }

    public Collection<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(Collection<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
