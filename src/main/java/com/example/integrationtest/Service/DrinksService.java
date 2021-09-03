package com.example.integrationtest.service;

import com.example.integrationtest.model.Drinks;
import com.example.integrationtest.webClient.DrinkResponse;
import com.example.integrationtest.webClient.WebClientImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DrinksService {

    final
    WebClientImpl webClient;

    final
    ObjectMapper objectMapper;

    public DrinksService(ObjectMapper objectMapper, WebClientImpl webClient) {
        this.objectMapper = objectMapper;
        this.webClient = webClient;
    }

    public Drinks addRandomDrink() throws Exception {
        String URI = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
        DrinkResponse drinkResponse = webClient.callDrinksApi(URI);
        return drinkResponse.getDrinks().get(0);
    }

    public Optional<DrinkResponse> getAllDrinksByLetter(String URI) throws Exception {
        DrinkResponse drinkResponse = webClient.receiveAllDrinks(URI);
        //if there is no cocktails with that letter, return empty value, to avoid NPE
        if(drinkResponse.getDrinks() == null) {
            return Optional.empty();
        }
        //if everything is ok, return drinkResponse object
        return Optional.of(drinkResponse);
    }
}
