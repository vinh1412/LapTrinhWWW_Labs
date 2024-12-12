/*
 * @ {#} CompanyService.java   1.0     08/11/2024
 *
 * Copyright (c) 2024 IUH. All rights reserved.
 */

package vn.edu.iuh.fit.backend.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import vn.edu.iuh.fit.backend.models.Address;
import vn.edu.iuh.fit.backend.models.Company;
import vn.edu.iuh.fit.backend.repositories.AddressRepository;
import vn.edu.iuh.fit.backend.repositories.CompanyRepository;

import java.util.List;

/*
 * @description:
 * @author: Tran Hien Vinh
 * @date:   08/11/2024
 * @version:    1.0
 */
@Service
public class CompanyService {
    @Autowired
    private CompanyRepository companyRepository;
    @Autowired
    private AddressRepository addressRepository;
    public List<Company> findAll() {
        return companyRepository.findAll();
    }
    public Company findById(Long id) {
        return companyRepository.findById(id).orElse(null);
    }
    public Company findByEmail(String email) {
        return companyRepository.findByEmail(email).orElse(null);
    }
    public Company save(Company company) {
        Address address = company.getAddress();
        addressRepository.save(address);

        return companyRepository.save(company);
    }
    public boolean existsByEmail(String email) {
        return companyRepository.existsByEmail(email);
    }
    public boolean existsByPhone(String phone) {
        return companyRepository.existsByPhone(phone);
    }
}
