package com.toindph26899.springbootandthymeleaf.service.impl;

import com.toindph26899.springbootandthymeleaf.repository.CompanyRepository;
import com.toindph26899.springbootandthymeleaf.response.CompanyResponse;
import com.toindph26899.springbootandthymeleaf.service.CompanyService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CompanyServiceImpl implements CompanyService {

    private CompanyRepository companyRepository;

    @Autowired
    public CompanyServiceImpl (CompanyRepository companyRepository) {
        this.companyRepository = companyRepository;
    }

    @Override
    public List<CompanyResponse> findAll() {
        return companyRepository.findAllCustom();
    }
}
