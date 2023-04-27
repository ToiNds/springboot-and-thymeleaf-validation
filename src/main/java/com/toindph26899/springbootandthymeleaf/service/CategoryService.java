package com.toindph26899.springbootandthymeleaf.service;

import com.toindph26899.springbootandthymeleaf.response.CategoryResponse;

import java.util.List;

public interface CategoryService {

    List<CategoryResponse> findAll();

}
