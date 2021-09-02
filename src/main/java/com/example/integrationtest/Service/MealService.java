package com.example.integrationtest.Service;

import com.example.integrationtest.model.Meals;
import com.example.integrationtest.webClient.WebClientImpl;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MealService {

    String URI = "https://www.themealdb.com/api/json/v1/1/random.php";

    public Meals getMeal() throws Exception {
        WebClientImpl webClientImpl = new WebClientImpl();
        return webClientImpl.callMealApi(URI);
    }

}
