package com.kudakwashemuparuri.test.company.service.request;

import javax.validation.constraints.NotBlank;

public class CreateCompanyRequest {

    @NotBlank(message = "Name is required")
    private String name;

    @NotBlank(message = "Vat number is required")
    private String vatNumber;

    @NotBlank(message = "Physical address is required")
    private String addressPhysical;


    @NotBlank(message = "Postal address is required")
    private String addressPostal;

    @NotBlank(message = "Telephone number is required")
    private  String telephoneNumber;

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


}
