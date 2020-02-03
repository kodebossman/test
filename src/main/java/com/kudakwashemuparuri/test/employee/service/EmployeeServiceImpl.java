package com.kudakwashemuparuri.test.employee.service;

import com.kudakwashemuparuri.test.commons.ObjectMap;
import com.kudakwashemuparuri.test.commons.Validations;
import com.kudakwashemuparuri.test.company.model.Company;
import com.kudakwashemuparuri.test.company.repository.CompanyRepository;
import com.kudakwashemuparuri.test.employee.dto.EmployeeDTO;
import com.kudakwashemuparuri.test.employee.model.Employee;
import com.kudakwashemuparuri.test.employee.repository.EmployeeRepository;
import com.kudakwashemuparuri.test.employee.service.request.CreateEmployeeRequest;
import com.kudakwashemuparuri.test.employee.service.request.UpdateEmployeeRequest;
import com.kudakwashemuparuri.test.exception.RecordNotFoundException;
import org.springframework.transaction.annotation.Transactional;

import java.util.Collection;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

public class EmployeeServiceImpl implements EmployeeService {


    private final EmployeeRepository employeeRepository;

    private final CompanyRepository companyRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository,
                               CompanyRepository companyRepository) {
        this.employeeRepository = employeeRepository;
        this.companyRepository = companyRepository;
    }

    @Override
    @Transactional
    public EmployeeDTO register(CreateEmployeeRequest createEmployeeRequest) {

        Validations.validate(createEmployeeRequest);
        Long companyId = createEmployeeRequest.getCompanyId();

        Employee employee = ObjectMap.mapToEntity(createEmployeeRequest, Employee.class);

        String employeeNumber = generateEmployeeNumber();

        employee.setEmployeeNumber(employeeNumber);

        return saveEmployee(companyId, employee);
    }

    private String generateEmployeeNumber() {
        return  "EMP".concat(UUID.randomUUID().toString().replace("-", "").substring(5,9));
    }

    @Override
    public EmployeeDTO editEmployee(UpdateEmployeeRequest updateEmployeeRequest) {

        Validations.validate(updateEmployeeRequest);

        Long id = updateEmployeeRequest.getId();

        Long companyId = updateEmployeeRequest.getCompanyId();

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employee with id  " + id + " not found"));

        return saveEmployee(companyId, employee);
    }

    private EmployeeDTO saveEmployee(Long companyId, Employee employee) {

        if (nonNull(companyId)) {

            Company company = companyRepository.findById(companyId)
                    .orElseThrow(() -> new RecordNotFoundException("Company details with id " + companyId + " not found "));

            employee.setCompany(company);


            employee = employeeRepository.save(employee);

        } else {

            employee = employeeRepository.save(employee);

        }

        return ObjectMap.mapToDTO(employee, EmployeeDTO.class);
    }

    @Override
    public List<EmployeeDTO> getAllEmployees() {
        List<Employee> companies = employeeRepository.findAll();

        return companies.stream()
                .map(company -> ObjectMap.mapToDTO(company, EmployeeDTO.class))
                .collect(Collectors.toList());
    }

    @Override
    public EmployeeDTO findById(Long id) {

        Employee employee = employeeRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Employee with id  " + id + " not found"));

        return ObjectMap.mapToDTO(employee, EmployeeDTO.class);
    }

    @Override
    public void deleteEmployee(Long id) {
        employeeRepository.deleteById(id);
    }

    @Override
    public Collection<EmployeeDTO> getAllEmployeesByCompany(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(()->new RecordNotFoundException("Company with id " + id + " not found"));

        List<Employee> employees= employeeRepository.findByCompany(company);

        return employees.stream()
                .map(company1 -> ObjectMap.mapToDTO(company1, EmployeeDTO.class))
                .collect(Collectors.toList());
    }
}
