package com.codegym.model.employee;
import javax.persistence.*;
import java.util.Collection;
import java.util.List;

@Entity
@Table (name = "bo_phan")
public class Department {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_bo_phan")
    private Integer idDepartment;
    @Column (name = "ten_bo_phan")
    private String nameDepartment;
    @OneToMany (mappedBy = "department")
    private Collection<Employee> employeeList;

    public Department() {
    }

    public Department(Integer idDepartment, String nameDepartment, Collection<Employee> employeeList) {
        this.idDepartment = idDepartment;
        this.nameDepartment = nameDepartment;
        this.employeeList = employeeList;
    }

    public Integer getIdDepartment() {
        return idDepartment;
    }

    public void setIdDepartment(Integer idDepartment) {
        this.idDepartment = idDepartment;
    }

    public String getNameDepartment() {
        return nameDepartment;
    }

    public void setNameDepartment(String nameDepartment) {
        this.nameDepartment = nameDepartment;
    }

    public Collection<Employee> getEmployeeList() {
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }
}
