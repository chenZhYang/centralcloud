package com.dabby.eurekaserverbackups;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class EurekaServerBackupsApplication {

    public static void main(String[] args) {
        SpringApplication.run(EurekaServerBackupsApplication.class, args);
    }

}
