package com.kudakwashemuparuri.test.employee.service;

import com.kudakwashemuparuri.test.employee.dto.EmployeeDTO;
import com.kudakwashemuparuri.test.employee.service.request.CreateEmployeeRequest;
import com.kudakwashemuparuri.test.employee.service.request.UpdateEmployeeRequest;

import java.util.Collection;
import java.util.List;

public interface EmployeeService {

    EmployeeDTO register(CreateEmployeeRequest createEmployeeRequest);

    EmployeeDTO editEmployee(UpdateEmployeeRequest updateCompanyRequest);

    List<EmployeeDTO> getAllEmployees();

    EmployeeDTO findById(Long id);

    void deleteEmployee(Long id);

    Collection<EmployeeDTO> getAllEmployeesByCompany(Long id);
}
