package com.kudakwashemuparuri.test.company.service;

import com.kudakwashemuparuri.test.commons.ObjectMap;
import com.kudakwashemuparuri.test.commons.Validations;
import com.kudakwashemuparuri.test.company.dto.CompanyDTO;
import com.kudakwashemuparuri.test.company.model.Company;
import com.kudakwashemuparuri.test.company.repository.CompanyRepository;
import com.kudakwashemuparuri.test.company.service.request.CreateCompanyRequest;
import com.kudakwashemuparuri.test.company.service.request.UpdateCompanyRequest;
import com.kudakwashemuparuri.test.exception.RecordNotFoundException;

import java.util.List;
import java.util.stream.Collectors;

public class CompanyServiceImpl implements CompanyService {


    private final CompanyRepository companyRepository;

    public CompanyServiceImpl(CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public CompanyDTO register(CreateCompanyRequest createCompanyRequest) {
        Validations.validate(createCompanyRequest);

        Company company = ObjectMap.mapToEntity(createCompanyRequest, Company.class);

        company = companyRepository.save(company);

        return ObjectMap.mapToDTO(company, CompanyDTO.class);
    }

    @Override
    public CompanyDTO editCompany(UpdateCompanyRequest updateCompanyRequest) {

        Validations.validate(updateCompanyRequest);

        Long id = updateCompanyRequest.getId();

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Company with id " + id + " not found"));

        ObjectMap.updateEntity(company, updateCompanyRequest);

        company = companyRepository.save(company);

        return ObjectMap.mapToDTO(company, CompanyDTO.class);

    }

    @Override
    public List<CompanyDTO> getAllCompanies() {
        List<Company> companies = companyRepository.findAll();

        return companies.stream()
                .map(CompanyDTO::mapToDTO)
                .collect(Collectors.toList());
    }

    @Override
    public CompanyDTO findById(Long id) {

        Company company = companyRepository.findById(id)
                .orElseThrow(() -> new RecordNotFoundException("Company with id  " + id + " not found"));

        return CompanyDTO.mapToDTO(company);
    }

    @Override
    public void deleteCompany(Long id) {
        companyRepository.deleteById(id);
    }
}
