package com.toindph26899.springbootandthymeleaf.service;

import com.toindph26899.springbootandthymeleaf.request.ProductRequest;
import com.toindph26899.springbootandthymeleaf.response.ProductResponse;
import org.springframework.validation.BindingResult;

import java.util.List;

public interface ProductService {

    List<ProductResponse> findAll();

    ProductRequest findById(Long id);

    void save(ProductRequest productRequest);

    void delete(Long id);

    void isCheckPrice(Double sellPrice, Double originPrice, BindingResult bindingResult);

}
