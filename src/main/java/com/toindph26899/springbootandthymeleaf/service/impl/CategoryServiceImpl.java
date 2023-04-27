package com.toindph26899.springbootandthymeleaf.service.impl;

import com.toindph26899.springbootandthymeleaf.repository.CategoryRepository;
import com.toindph26899.springbootandthymeleaf.response.CategoryResponse;
import com.toindph26899.springbootandthymeleaf.service.CategoryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategoryServiceImpl implements CategoryService {

    private CategoryRepository categoryRepository;

    @Autowired
    public CategoryServiceImpl(CategoryRepository categoryRepository) {
        this.categoryRepository = categoryRepository;
    }

    @Override
    public List<CategoryResponse> findAll() {
        return categoryRepository.findAllCustom();
    }
}
