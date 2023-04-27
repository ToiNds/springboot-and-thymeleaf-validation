package com.toindph26899.springbootandthymeleaf.repository;

import com.toindph26899.springbootandthymeleaf.entities.Company;
import com.toindph26899.springbootandthymeleaf.response.CompanyResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CompanyRepository extends JpaRepository<Company, Long> {

    @Query("select new com.toindph26899.springbootandthymeleaf.response.CompanyResponse" +
            "(co.id, co.companyCode, co.companyName) " +
            "from Company co")
    List<CompanyResponse> findAllCustom();
}
