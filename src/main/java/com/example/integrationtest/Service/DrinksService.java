package com.example.integrationtest.Service;

import com.example.integrationtest.model.Drinks;
import com.example.integrationtest.model.Meals;
import com.example.integrationtest.webClient.WebClientImpl;
import org.springframework.stereotype.Service;

@Service
public class DrinksService {
    String URI = "https://www.thecocktaildb.com/api/json/v1/1/random.php";

    public Drinks getDrink() throws Exception {
        WebClientImpl webClientImpl = new WebClientImpl();
        return webClientImpl.callDrinksApi(URI);
    }
}
