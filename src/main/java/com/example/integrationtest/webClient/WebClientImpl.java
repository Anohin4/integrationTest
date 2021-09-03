package com.example.integrationtest.webClient;

import com.example.integrationtest.model.Drinks;
import com.example.integrationtest.model.Meals;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;
import java.util.Optional;

@Component
public class WebClientImpl {
    final
    ObjectMapper mapper;

    public WebClientImpl(ObjectMapper mapper) {
        this.mapper = mapper;
    }

    public MealResponse callMealApi(String URI) throws Exception{
        WebClient webClient = WebClient.create();
        String response = webClient.get()
                .uri(URI)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //converting json to array with meals
        MealResponse responseMapped = mapper.readValue(response, MealResponse.class);
        return responseMapped;

    }

    public DrinkResponse callDrinksApi(String URI) throws Exception {
        WebClient webClient = WebClient.create();
        String response = webClient.get()
                .uri(URI)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        //converting json to array with meals
        DrinkResponse responseMapped = mapper.readValue(response, DrinkResponse.class);
        return responseMapped;
    }
}
