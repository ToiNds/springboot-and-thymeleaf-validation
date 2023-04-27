package com.toindph26899.springbootandthymeleaf.service;

import com.toindph26899.springbootandthymeleaf.response.CompanyResponse;

import java.util.List;

public interface CompanyService {

    List<CompanyResponse> findAll();

}
