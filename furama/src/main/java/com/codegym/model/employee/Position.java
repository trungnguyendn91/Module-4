package com.codegym.model.employee;

import javax.persistence.*;
import java.util.Collection;

@Entity
@Table (name = "vi_tri")
public class Position {
    @Id
    @GeneratedValue (strategy = GenerationType.IDENTITY)
    @Column (name = "ma_vi_tri")
    private int idPosition;
    @Column (name = "ten_vi_tri")
    private String namePosition;

    @OneToMany (mappedBy = "position")
    Collection<Employee> employeesList;

    public Position() {
    }

    public Position(int idPosition, String namePosition, Collection<Employee> employeesList) {
        this.idPosition = idPosition;
        this.namePosition = namePosition;
        this.employeesList = employeesList;
    }

    public int getIdPosition() {
        return idPosition;
    }

    public void setIdPosition(int idPosition) {
        this.idPosition = idPosition;
    }

    public String getNamePosition() {
        return namePosition;
    }

    public void setNamePosition(String namePosition) {
        this.namePosition = namePosition;
    }

    public Collection<Employee> getEmployeesList() {
        return employeesList;
    }

    public void setEmployeesList(Collection<Employee> employeesList) {
        this.employeesList = employeesList;
    }
}
