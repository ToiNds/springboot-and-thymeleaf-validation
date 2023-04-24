package com.toindph26899.springbootandthymeleaf.service;

import com.toindph26899.springbootandthymeleaf.request.ProductRequest;
import com.toindph26899.springbootandthymeleaf.response.ProductResponse;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAll();

    void save(ProductRequest productRequest);

    void delete(Long id);

}
