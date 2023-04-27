package com.toindph26899.springbootandthymeleaf.service.impl;

import com.toindph26899.springbootandthymeleaf.entities.Category;
import com.toindph26899.springbootandthymeleaf.entities.Company;
import com.toindph26899.springbootandthymeleaf.entities.Product;
import com.toindph26899.springbootandthymeleaf.entities.Status;
import com.toindph26899.springbootandthymeleaf.repository.CategoryRepository;
import com.toindph26899.springbootandthymeleaf.repository.CompanyRepository;
import com.toindph26899.springbootandthymeleaf.repository.ProductRepository;
import com.toindph26899.springbootandthymeleaf.repository.StatusRepository;
import com.toindph26899.springbootandthymeleaf.request.ProductRequest;
import com.toindph26899.springbootandthymeleaf.response.ProductResponse;
import com.toindph26899.springbootandthymeleaf.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.validation.BeanPropertyBindingResult;
import org.springframework.validation.BindingResult;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
public class ProductServiceImpl implements ProductService {

    private ProductRepository productRepository;
    private StatusRepository statusRepository;
    private CategoryRepository categoryRepository;
    private CompanyRepository companyRepository;

    @Autowired
    public ProductServiceImpl(ProductRepository productRepository, StatusRepository statusRepository,
                              CategoryRepository categoryRepository, CompanyRepository companyRepository) {
        this.productRepository = productRepository;
        this.statusRepository = statusRepository;
        this.categoryRepository = categoryRepository;
        this.companyRepository = companyRepository;
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
    public ProductRequest findById(Long id) {

        Optional<Product> resultProduct = productRepository.findById(id);
        Product product = null;

        if (resultProduct.isPresent()) {
            product = resultProduct.get();
        } else {
            throw new RuntimeException("Product not fount id - " + id);
        }

        ProductRequest productRequest = ProductRequest.builder()
                .id(product.getId())
                .categoryId(product.getCategoryId().getId())
                .statusId(product.getStatusId().getId())
                .companyId(product.getCompanyId().getId())
                .productCode(product.getProductCode())
                .productName(product.getProductName())
                .color(product.getColor())
                .quantity(product.getQuantity())
                .description(product.getDescription())
                .originPrice(product.getOriginPrice())
                .sellPrice(product.getSellPrice())
                .build();

        if (productRequest == null) {
            return null;
        } else {
            return productRequest;
        }
    }

    @Override
    public void save(ProductRequest productRequest) {

        // validation sellPrice > originPrice


        Optional<Status> resultStatus = statusRepository.findById(1l);
        Optional<Category> resultCategory = categoryRepository.findById(productRequest.getCategoryId());
        Optional<Company> resultCompany = companyRepository.findById(productRequest.getCompanyId());

        Status status = null;
        Category category = null;
        Company company = null;

        if (resultStatus.isPresent() && resultCategory.isPresent() && resultCompany.isPresent()) {
            status = resultStatus.get();
            category = resultCategory.get();
            company = resultCompany.get();
        } else {
            throw new RuntimeException("Error");
        }

        Product product = Product.builder()
                .id(productRequest.getId())
                .productCode(productRequest.getProductCode())
                .productName(productRequest.getProductName())
                .quantity(productRequest.getQuantity())
                .color(productRequest.getColor())
                .sellPrice(productRequest.getSellPrice())
                .originPrice(productRequest.getOriginPrice())
                .description(productRequest.getDescription())
                .statusId(status)
                .categoryId(category)
                .companyId(company)
                .build();

        productRepository.save(product);
    }

    @Override
    public void delete(Long id) {
        productRepository.deleteById(id);
    }

    @Override
    public void isCheckPrice(Double sellPrice, Double originPrice, BindingResult bindingResult) {

        if (sellPrice == null || originPrice == null) {
            return;
        }

        if (sellPrice > originPrice) {
            return;
        } else {
            bindingResult.rejectValue
                    ("sellPrice", "sellPrice", "sell price khong duoc nho hon origin price");
        }
    }
}
