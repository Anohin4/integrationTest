package com.example.integrationtest.service;

import com.example.integrationtest.model.Meals;
import com.example.integrationtest.webClient.MealResponse;
import com.example.integrationtest.webClient.WebClientImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class MealService {
    final
    WebClientImpl webClient;

    final
    ObjectMapper objectMapper;

    public MealService(ObjectMapper objectMapper, WebClientImpl webClient) {
        this.objectMapper = objectMapper;
        this.webClient = webClient;
    }

    public Meals addRandomMeal() throws Exception {
        String URI = "https://www.themealdb.com/api/json/v1/1/random.php";
        MealResponse mealResponse = webClient.callMealApi(URI);
        return mealResponse.getMeals().get(0);
    }

    public Optional<MealResponse> getAllMealsByLetter(String URI) throws Exception {
        MealResponse mealResponse = webClient.callMealApi(URI);
        //if there is no cocktails with that letter, return empty value, to avoid NPE
        if(mealResponse.getMeals() == null) {
            return Optional.empty();
        }
        //if everything is ok, return mealResponse object
        return Optional.of(mealResponse);
    }
}
