package com.kudakwashemuparuri.test.employee.model;

import com.kudakwashemuparuri.test.company.model.Company;
import com.kudakwashemuparuri.test.person.Person;

import javax.persistence.*;

@Entity
@Table(name = "employee")
public class Employee extends Person {

    @Column
    private String employeeNumber;

    @ManyToOne
    private Company company;

    public String getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(String employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    // Method Spec
    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }
}
