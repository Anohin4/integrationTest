package com.example.integrationtest.webClient;

import com.example.integrationtest.model.Drinks;
import com.example.integrationtest.model.Meals;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.reactive.function.client.WebClient;

import java.util.List;

@Component
public class WebClientImpl {
    @Autowired
    ObjectMapper mapper;

    public Meals callMealApi(String URI) throws Exception{
        WebClient webClient = WebClient.create();
        String response = webClient.get()
                .uri(URI)
                .retrieve()
                .bodyToMono(String.class)
                .block();

        //converting json to array with meals
        MealResponse responseMapped = mapper.readValue(response, MealResponse.class);
        return responseMapped.getMeals().get(0);

    }

    public Drinks callDrinksApi(String URI) throws Exception {
        WebClient webClient = WebClient.create();
        String response = webClient.get()
                .uri(URI)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        //converting json to array with meals
        DrinkResponse responseMapped = new DrinkResponse();
        responseMapped = mapper.readValue(response, responseMapped.getClass());
        return responseMapped.getDrinks().get(0);
    }

    public List<Drinks> receiveAllDrinks(String URI) throws Exception{
        WebClient webClient = WebClient.create();
        String response = webClient.get()
                .uri(URI)
                .retrieve()
                .bodyToMono(String.class)
                .block();
        DrinkResponse responseMapped = mapper.readValue(response, DrinkResponse.class);
        return responseMapped.getDrinks();
    }
}
