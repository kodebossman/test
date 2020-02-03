package com.kudakwashemuparuri.test.employee.api;

import com.kudakwashemuparuri.test.employee.dto.EmployeeDTO;
import com.kudakwashemuparuri.test.employee.service.EmployeeService;
import com.kudakwashemuparuri.test.employee.service.request.CreateEmployeeRequest;
import com.kudakwashemuparuri.test.employee.service.request.UpdateEmployeeRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1/employees")
public class EmployeeRestController {

    private final EmployeeService employeeService;

    public EmployeeRestController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    @PostMapping
    public EmployeeDTO createEmployee(@RequestBody CreateEmployeeRequest createEmployeeRequest){

        return employeeService.register(createEmployeeRequest);
    }


    @PutMapping("/{id}")
    public EmployeeDTO updateEmployee(@PathVariable Long id, @RequestBody UpdateEmployeeRequest updateEmployeeRequest){
        updateEmployeeRequest.setId(id);
        return employeeService.editEmployee(updateEmployeeRequest);
    }

    @GetMapping("/{id}")
    public EmployeeDTO getOneEmployee(@PathVariable Long id  ){
        return employeeService.findById(id);
    }

    @DeleteMapping("/{id}")
    public void deleteEmployee(@PathVariable Long id){
        employeeService.deleteEmployee(id);
    }

    @GetMapping
    public Collection<EmployeeDTO> getEmployees(){
        return employeeService.getAllEmployees();
    }

    @GetMapping("/company/{id}")
    public Collection<EmployeeDTO> getEmployees(@PathVariable Long id){
        return employeeService.getAllEmployeesByCompany(id);
    }
}
