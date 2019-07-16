package com.example.simpledatabase;

import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.core.env.Environment;

import javax.annotation.PostConstruct;
import java.util.TimeZone;

@Slf4j
@SpringBootApplication
public class Application {
    @Autowired
    Environment environment;

    @PostConstruct
    public void initIt() throws Exception {

        System.out.println("Env " + environment.getProperty("timeZone.cmsTimeZone"));
    }

    public static void main(String[] args) {
        TimeZone.setDefault(TimeZone.getTimeZone("Asia/Bangkok"));
        SpringApplication.run(Application.class, args);
    }
}
