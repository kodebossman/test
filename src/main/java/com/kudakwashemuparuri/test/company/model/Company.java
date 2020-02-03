package com.kudakwashemuparuri.test.company.model;

import com.kudakwashemuparuri.test.employee.model.Employee;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

@Entity
@Table(name = "Company")
public class Company {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String name;

    @Column
    private String vatNumber;

    @Column
    private String addressPhysical;

    @Column
    private String addressPostal;

    @Column
    private String telephoneNumber;

//    @OneToMany(mappedBy = "company",
//            cascade = CascadeType.ALL,
//            orphanRemoval = true
//    )
//    private List<Employee> employeeList = new ArrayList<>();

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getVatNumber() {
        return vatNumber;
    }

    public void setVatNumber(String vatNumber) {
        this.vatNumber = vatNumber;
    }

    public String getAddressPhysical() {
        return addressPhysical;
    }

    public void setAddressPhysical(String addressPhysical) {
        this.addressPhysical = addressPhysical;
    }

    public String getAddressPostal() {
        return addressPostal;
    }

    public void setAddressPostal(String addressPostal) {
        this.addressPostal = addressPostal;
    }

    public String getTelephoneNumber() {
        return telephoneNumber;
    }

    public void setTelephoneNumber(String telephoneNumber) {
        this.telephoneNumber = telephoneNumber;
    }

//    // @Return List of Employee as required in Spec
//    public List<Employee> getEmployeeList() {
//        return employeeList;
//    }
//
//    public void addEmployee(Employee employee) {
//        if (isNull(employeeList)) {
//            this.employeeList = new ArrayList<>();
//        }
//        employeeList.add(employee);
//    }


}
