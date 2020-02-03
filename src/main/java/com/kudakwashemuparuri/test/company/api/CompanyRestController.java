package com.kudakwashemuparuri.test.company.api;

import com.kudakwashemuparuri.test.company.dto.CompanyDTO;
import com.kudakwashemuparuri.test.company.service.CompanyService;
import com.kudakwashemuparuri.test.company.service.request.CreateCompanyRequest;
import com.kudakwashemuparuri.test.company.service.request.UpdateCompanyRequest;
import org.springframework.web.bind.annotation.*;

import java.util.Collection;

@RestController
@RequestMapping(value = "/api/v1/companies")
public class CompanyRestController {

    private final CompanyService companyService;

    public CompanyRestController(CompanyService companyService) {
        this.companyService = companyService;
    }

    @PostMapping
    public CompanyDTO createCompany(@RequestBody CreateCompanyRequest createCompanyRequest){

        return companyService.register(createCompanyRequest);
    }

    @PutMapping("/{id}")
    public CompanyDTO updateCompany(@PathVariable Long id, @RequestBody UpdateCompanyRequest updateCompanyRequest){

        return companyService.editCompany(updateCompanyRequest);
    }

    @GetMapping("/{id}")
    public CompanyDTO getOneCompany(@PathVariable Long id  ){
        return companyService.findById(id);
    }

    @GetMapping
    public Collection<CompanyDTO> getAllCompanies(){
        return companyService.getAllCompanies();
    }

    @DeleteMapping("/{id}")
    public void deleteCompany(@PathVariable Long id){
        companyService.deleteCompany(id);
    }
}
