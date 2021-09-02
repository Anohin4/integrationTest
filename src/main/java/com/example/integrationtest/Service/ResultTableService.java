package com.example.integrationtest.Service;

import com.example.integrationtest.model.Meals;
import com.example.integrationtest.model.ResultTable;
import com.example.integrationtest.repository.ResultTableRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResultTableService {
    @Autowired
    MealService mealService;

    @Autowired
    DrinksService drinksService;

    @Autowired
    ResultTableRepository resultTableRepository;

    public void saveMealToResultTable() throws Exception{
        resultTableRepository.save(new ResultTable(mealService.getMeal()));
    }

    public void saveDrinkToResultTable() throws Exception{
        resultTableRepository.save(new ResultTable(drinksService.getDrink()));
    }

    public List<ResultTable> findByType(String type) {
        return resultTableRepository.findAllByTypeIgnoreCase(type);
    }
}
