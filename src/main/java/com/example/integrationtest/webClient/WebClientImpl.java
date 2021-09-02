package com.example.integrationtest.webClient;

import com.example.integrationtest.model.Meals;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;

@Service
public class WebClientImpl {
    @Autowired
    ObjectMapper objectMapper;

    public Meals callApi(String URI) throws Exception{
        WebClient webClient = WebClient.create();
        String response = webClient.get()
                .uri(URI)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        MealResponse response1 = objectMapper.readValue(response, MealResponse.class);

        return response1.getMeals().get(0);

    }

}
