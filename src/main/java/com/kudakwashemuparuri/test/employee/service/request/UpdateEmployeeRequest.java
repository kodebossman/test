package com.kudakwashemuparuri.test.employee.service.request;

import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;


public class UpdateEmployeeRequest extends CreateEmployeeRequest {

    @NotNull(message = "Company id is required")
    @Min(value = 0, message = "Id should be greater than zero")
    private Long id;

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}
