package com.doudou.onlinebook;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.web.servlet.ServletComponentScan;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;

@EnableScheduling
@Configuration
@ServletComponentScan
@EnableTransactionManagement
@EnableAutoConfiguration
@ComponentScan
@SpringBootApplication
public class OnlinebookApplication {

    public static void main(String[] args) {
        SpringApplication.run(OnlinebookApplication.class, args);
    }

}
