package com.toindph26899.springbootandthymeleaf.service.impl;

import com.toindph26899.springbootandthymeleaf.repository.StatusRepository;
import com.toindph26899.springbootandthymeleaf.response.StatusResponse;
import com.toindph26899.springbootandthymeleaf.service.StatusService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StatusServiceImpl implements StatusService {

    private StatusRepository statusRepository;

    @Autowired
    public StatusServiceImpl (StatusRepository statusRepository) {
        this.statusRepository = statusRepository;
    }


    @Override
    public List<StatusResponse> findAll() {
        return statusRepository.findAllCustom();
    }
}
