package org.uengine.eureka.server;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

/**
 * Created by uengine on 2017. 10. 5..
 */

@SpringBootApplication
@EnableEurekaServer
public class RegistryServiceApplication {

    public static void main(String[] args) {
        new SpringApplicationBuilder(RegistryServiceApplication.class).web(true).run(args);
    }

}
