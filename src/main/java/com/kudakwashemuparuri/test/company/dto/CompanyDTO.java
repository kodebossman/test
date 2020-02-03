package com.kudakwashemuparuri.test.company.dto;

import com.kudakwashemuparuri.test.company.model.Company;
import com.kudakwashemuparuri.test.employee.model.Employee;

import java.util.ArrayList;
import java.util.List;

import static java.util.Objects.isNull;

public class CompanyDTO {

    private Long id;

    private String name;

    private String vatNumber;

    private String addressPhysical;

    private String addressPostal;

    private  String telephoneNumber;

    private List<Employee> employeeList = new ArrayList<>();

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

    public List<Employee> getEmployeeList() {
        if(isNull(employeeList)){
            this.employeeList = new ArrayList<>();
        }
        return employeeList;
    }

    public void setEmployeeList(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    public static CompanyDTO mapToDTO(Company company){
        CompanyDTO companyDTO = new CompanyDTO();
        companyDTO.setAddressPhysical(company.getAddressPhysical());
        companyDTO.setAddressPostal(company.getAddressPostal());
        companyDTO.setId(company.getId());
        companyDTO.setName(company.getName());
        companyDTO.setTelephoneNumber(company.getTelephoneNumber());
        companyDTO.setVatNumber(company.getVatNumber());
        //companyDTO.getEmployeeList().addAll(company.getEmployeeList());
        return companyDTO;

    }
}
