package com.example.configclient;


import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RefreshScope
public class GetConfigController {
    @Value("${foo}")
    private String foo;

    @Value("${server.port}")
    private String port;

    @Value("${testSymmetric}")
    private String testSymmetric;

    @GetMapping("/config")
    public String getConfig() {
        return "port: " + port + " version: " + foo;
    }

    @GetMapping("/config/symmetric")
    public String symmetric() {
        return testSymmetric;
    }
}
