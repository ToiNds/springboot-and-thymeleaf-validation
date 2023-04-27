package com.toindph26899.springbootandthymeleaf.repository;

import com.toindph26899.springbootandthymeleaf.entities.Status;
import com.toindph26899.springbootandthymeleaf.response.StatusResponse;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StatusRepository extends JpaRepository<Status, Long> {

    @Query("select new com.toindph26899.springbootandthymeleaf.response.StatusResponse" +
            "(s.id, s.statusName) from Status s")
    List<StatusResponse> findAllCustom();
}
