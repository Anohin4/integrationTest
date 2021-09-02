package com.example.integrationtest;

import com.example.integrationtest.Service.ResultTableService;
import com.example.integrationtest.repository.ResultTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;

@SpringBootApplication
public class IntegrationTestApplication {

    @Autowired
    ResultTableService resultTableService;

    public static void main(String[] args) {
        SpringApplication.run(IntegrationTestApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void doSomethingAfterStartup() throws Exception{
        resultTableService.saveAllDrinks();
    }

}
