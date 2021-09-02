package com.example.integrationtest.webClient;

import com.example.integrationtest.model.Meals;
import lombok.Data;

import java.util.List;

@Data
public class MealResponse {
    List<Meals> meals;
}
