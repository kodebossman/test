package com.kudakwashemuparuri.test.company.service;

import com.kudakwashemuparuri.test.company.dto.CompanyDTO;
import com.kudakwashemuparuri.test.company.service.request.CreateCompanyRequest;
import com.kudakwashemuparuri.test.company.service.request.UpdateCompanyRequest;

import java.util.List;

public interface CompanyService {

    CompanyDTO register(CreateCompanyRequest createCompanyRequest);

    CompanyDTO editCompany(UpdateCompanyRequest updateCompanyRequest);

    List<CompanyDTO> getAllCompanies();

    CompanyDTO findById(Long id);

    void deleteCompany(Long id);
}
