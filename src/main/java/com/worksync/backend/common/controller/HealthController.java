package com.worksync.backend.common.controller;

import com.worksync.backend.constant.ApiConstant;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HealthController {

    @GetMapping(ApiConstant.API_V1 + "/")
    public String health() {
        return "WorkSync Backend is Running !";
    }

    @GetMapping(ApiConstant.API_V1 + "/health")
    public String check() {
        return "Ok";
    }
}
