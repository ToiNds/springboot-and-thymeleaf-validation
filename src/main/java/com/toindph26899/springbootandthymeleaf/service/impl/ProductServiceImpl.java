package com.toindph26899.springbootandthymeleaf.service.impl;

import com.toindph26899.springbootandthymeleaf.entities.Product;
import com.toindph26899.springbootandthymeleaf.repository.ProductRepository;
import com.toindph26899.springbootandthymeleaf.request.ProductRequest;
import com.toindph26899.springbootandthymeleaf.response.ProductResponse;
import com.toindph26899.springbootandthymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public List<ProductResponse> findAll() {
//
//        List<Product> findAll = productRepository.findAll();
//        List<ProductResponse> findAllCustom = new ArrayList<>();
//
//        for(Product p: findAll) {
//            findAllCustom.add(
//                    new ProductResponse(p.getId(), p.getProductCode(), p.getProductName(),
//                            p.getCategoryId().getCategoryName(), p.getCompanyId().getCompanyName(),
//                            p.getStatusId().getStatusName(), p.getSellPrice())
//            );
//        }
//
//        return findAllCustom;

        return productRepository.findAllCustom();
    }

    @Override
    public void save(ProductRequest productRequest) {

    }

    @Override
    public void delete(Long id) {

    }
}
