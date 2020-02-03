package com.kudakwashemuparuri.test.employee.repository;

import com.kudakwashemuparuri.test.company.model.Company;
import com.kudakwashemuparuri.test.employee.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface EmployeeRepository extends JpaRepository<Employee,Long>{

    List<Employee> findByCompany(Company company);
}
