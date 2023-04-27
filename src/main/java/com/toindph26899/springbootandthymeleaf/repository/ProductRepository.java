package com.toindph26899.springbootandthymeleaf.repository;

import com.toindph26899.springbootandthymeleaf.entities.Product;
import com.toindph26899.springbootandthymeleaf.response.ProductResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductRepository extends JpaRepository<Product, Long> {

    // custom query
    @Query("\n" +
            "select new com.toindph26899.springbootandthymeleaf.response.ProductResponse(p.id, p.productCode, " +
            "p.productName, ca.categoryName, co.companyName, s.statusName, p.sellPrice) " +
            "from Product p \n" +
            "join Status s on p.statusId = s.id\n" +
            "join Company co on p .companyId = co.id\n" +
            "join Category ca on p .categoryId = ca.id")
    List<ProductResponse> findAllCustom();

}
