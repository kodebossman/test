package com.kudakwashemuparuri.test.employee.service.request;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import java.util.Date;

public class CreateEmployeeRequest {

    @NotBlank(message ="First name is required")
    private String firstName;

    @NotBlank(message = "Last name is required")
    private String lastName;

    @NotBlank(message = "Identity number should be provided")
    private String identityNumber;

    @Past(message = "Date of birth should be in past")
    @NotNull(message = "Date of birth should be provided")
    @JsonFormat(pattern = "MM/dd/yyyy")
    private Date dateOfBirth;

    @NotBlank(message = "Physical address is required")
    private String addressPhysical;

    @NotBlank(message = "Postal address is required")
    private String addressPostal;

    @NotBlank(message = "Telephone number is required")
    private  String telephoneNumber;

    private Long companyId;

    public Long getCompanyId() {
        return companyId;
    }

    public void setCompanyId(Long companyId) {
        this.companyId = companyId;
    }


    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getIdentityNumber() {
        return identityNumber;
    }

    public void setIdentityNumber(String identityNumber) {
        this.identityNumber = identityNumber;
    }

    public Date getDateOfBirth() {
        return dateOfBirth;
    }

    public void setDateOfBirth(Date dateOfBirth) {
        this.dateOfBirth = dateOfBirth;
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
}
