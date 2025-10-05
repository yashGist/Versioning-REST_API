package com.pms.versioningrest_api;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication(scanBasePackages = {"com.controller", "com.pms.versioningrest_api"})
public class VersioningRestApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(VersioningRestApiApplication.class, args);
    }

}
