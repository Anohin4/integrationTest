package com.example.integrationtest.controller;

import com.example.integrationtest.Service.ResultTableService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class Controller {

    final ResultTableService resultTableService;

    public Controller(ResultTableService resultTableService) {
        this.resultTableService = resultTableService;
    }

    @GetMapping("/addMeal")
    public ResponseEntity addMeal() throws Exception{
        resultTableService.saveMealToResultTable();
        return ResponseEntity
                .status(200)
                .body("New meal was added to DB.");
    }

    @GetMapping("/addDrink")
    public ResponseEntity addDrink() throws Exception{
        resultTableService.saveDrinkToResultTable();;
        return ResponseEntity
                .status(200)
                .body("New drink was added to DB.");
    }

    @GetMapping("/searchByType")
    public ResponseEntity searchByType(@RequestParam String type) {
        return ResponseEntity
                .status(200)
                .body(resultTableService.findByType(type));
    }
}
