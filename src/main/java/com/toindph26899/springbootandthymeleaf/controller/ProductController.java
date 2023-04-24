package com.toindph26899.springbootandthymeleaf.controller;

import com.toindph26899.springbootandthymeleaf.response.ProductResponse;
import com.toindph26899.springbootandthymeleaf.service.ProductService;
import com.toindph26899.springbootandthymeleaf.service.impl.ProductServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/products")
public class ProductController {

    private ProductService productService;

    @Autowired
    public ProductController (ProductService productService) {
        this.productService = productService;
    }

    @GetMapping("/list")
    public List<ProductResponse> findAll() {

        System.out.println(productService.findAll());

        return null;
    }

}
