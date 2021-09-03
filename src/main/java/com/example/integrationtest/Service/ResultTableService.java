package com.example.integrationtest.service;

import com.example.integrationtest.model.Drinks;
import com.example.integrationtest.model.Meals;
import com.example.integrationtest.model.ResultTable;
import com.example.integrationtest.repository.ResultTableRepository;
import com.example.integrationtest.webClient.DrinkResponse;
import com.example.integrationtest.webClient.MealResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ResultTableService {
    @Autowired
    MealService mealService;

    @Autowired
    DrinksService drinksService;

    @Autowired
    ResultTableRepository resultTableRepository;

    public void saveMealToResultTable() throws Exception{
        resultTableRepository.save(new ResultTable(mealService.addRandomMeal()));
    }

    public void saveDrinkToResultTable() throws Exception{
        resultTableRepository.save(new ResultTable(drinksService.addRandomDrink()));
    }

    public List<ResultTable> findByType(String type) {
        return resultTableRepository.findAllByTypeIgnoreCase(type);
    }

    public void saveAllDrinks() throws Exception{
        String URI = "https://www.thecocktaildb.com/api/json/v1/1/search.php?f=";
        char letter = 'a';
        while (letter <= 'z'){
            Optional<DrinkResponse> drinkResponse= drinksService.getAllDrinksByLetter(URI + letter);
            //if there is no drinks starting with that letter, just go on
            if (drinkResponse.isEmpty()) {
                letter++;
                continue;
            }
            //If response not null, taking List of drinks and add to DB
            List<Drinks> drinks = drinkResponse.get().getDrinks();
            for(Drinks drink : drinks) {
                resultTableRepository.save(new ResultTable(drink));
            }
            letter++;
        }
    }

    public void saveAllMeals() throws Exception{
        String URI = "https://www.themealdb.com/api/json/v1/1/search.php?f=";
        char letter = 'a';
        while (letter <= 'z'){
            Optional<MealResponse> mealResponse = mealService.getAllMealsByLetter(URI + letter);
            //if there is no drinks starting with that letter, just go on
            if (mealResponse.isEmpty()) {
                letter++;
                continue;
            }
            //If response not null, taking List of drinks and add to DB
            List<Meals> meals = mealResponse.get().getMeals();
            for(Meals meal : meals) {
                resultTableRepository.save(new ResultTable(meal));
            }
            letter++;
        }
    }

    public List<ResultTable> giveAllByPage(int page) {
        int min = (page - 1) * 10;
        int max = min + 10;
        return resultTableRepository.findAllByIdBetween(min, max);
    }
}
