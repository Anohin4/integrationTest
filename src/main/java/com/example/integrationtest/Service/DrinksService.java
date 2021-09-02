package com.example.integrationtest.Service;

import com.example.integrationtest.model.Drinks;
import com.example.integrationtest.webClient.WebClientImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class DrinksService {
    String URI = "https://www.thecocktaildb.com/api/json/v1/1/random.php";
    @Autowired
    WebClientImpl webClient;

    public Drinks getDrink() throws Exception {
        return webClient.callDrinksApi(URI);
    }

    public List<Drinks> getAllDrinks() throws Exception {
        String URI = "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=a";
        return webClient.receiveAllDrinks(URI);
    }
}
