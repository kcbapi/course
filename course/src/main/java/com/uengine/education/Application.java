package com.uengine.education;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.SpringCloudApplication;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;

@SpringCloudApplication
@EnableFeignClients
@EnableEurekaClient
@Configuration
@ComponentScan(basePackageClasses = Application.class)
@EnableJpaRepositories(basePackageClasses = {Application.class})
public class Application {

	public static ApplicationContext getApplicationContext() {
		return applicationContext;
	}

	static ApplicationContext applicationContext;

	public static void main(String[] args) {
		applicationContext = SpringApplication.run(Application.class, args);
	}

}
