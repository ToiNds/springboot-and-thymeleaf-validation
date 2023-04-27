package com.toindph26899.springbootandthymeleaf.repository;

import com.toindph26899.springbootandthymeleaf.entities.Category;
import com.toindph26899.springbootandthymeleaf.response.CategoryResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CategoryRepository extends JpaRepository<Category, Long> {

    @Query("select new com.toindph26899.springbootandthymeleaf.response.CategoryResponse(c.id, c.categoryCode, c.categoryName) " +
            "from Category c")
    List<CategoryResponse> findAllCustom();
}
