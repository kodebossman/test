package com.kudakwashemuparuri.test.commons.config;


import com.kudakwashemuparuri.test.company.repository.CompanyRepository;
import com.kudakwashemuparuri.test.company.service.CompanyService;
import com.kudakwashemuparuri.test.company.service.CompanyServiceImpl;
import com.kudakwashemuparuri.test.employee.repository.EmployeeRepository;
import com.kudakwashemuparuri.test.employee.service.EmployeeService;
import com.kudakwashemuparuri.test.employee.service.EmployeeServiceImpl;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class ServiceBeanFactory {

    @Bean
    public CompanyService companyService(CompanyRepository companyRepository){
        return new CompanyServiceImpl(companyRepository);
    }

    @Bean
    public EmployeeService employeeService(EmployeeRepository employeeRepository, CompanyRepository companyRepository){
        return new EmployeeServiceImpl(employeeRepository, companyRepository);
    }
}
