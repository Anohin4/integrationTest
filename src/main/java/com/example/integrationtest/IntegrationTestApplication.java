package com.example.integrationtest;

import com.example.integrationtest.service.ResultTableService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.event.EventListener;
import org.springframework.scheduling.annotation.Async;

@SpringBootApplication
public class IntegrationTestApplication {

    @Autowired
    ResultTableService resultTableService;

    public static void main(String[] args) {
        SpringApplication.run(IntegrationTestApplication.class, args);
    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveAllDrinks() throws Exception{
        resultTableService.saveAllDrinks();
    }

    @EventListener(ApplicationReadyEvent.class)
    public void saveAllMeals() throws Exception{
        resultTableService.saveAllMeals();
    }
}
