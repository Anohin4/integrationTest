package com.example.integrationtest.webClient;

import com.example.integrationtest.model.Drinks;
import lombok.Data;

import java.util.List;

@Data
public class DrinkResponse {
    List<Drinks> drinks;
}
