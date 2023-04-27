package com.toindph26899.springbootandthymeleaf.service;

import com.toindph26899.springbootandthymeleaf.response.StatusResponse;

import java.util.List;

public interface StatusService {

    List<StatusResponse> findAll();

}
