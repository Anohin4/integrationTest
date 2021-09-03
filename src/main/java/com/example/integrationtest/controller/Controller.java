package com.example.integrationtest.controller;

import com.example.integrationtest.model.ResultTable;
import com.example.integrationtest.service.ResultTableService;
import org.springframework.data.domain.Page;
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

    @GetMapping(value = "/all")
    public ResponseEntity findAllById(@RequestParam int page, @RequestParam String order) {
        Page<ResultTable> result;
        if(order.equals("asc")) {
            result = resultTableService.findAllById(page);
        } else {
            result = resultTableService.findAllByIdDesc(page);
        }
        return ResponseEntity
                .status(200)
                .body(result);
    }

    @GetMapping(value = "/allByName")
    public ResponseEntity findAllByName(@RequestParam int page, @RequestParam String order) {
        Page<ResultTable> result;
        if(order.equals("asc")) {
            result = resultTableService.findAllByNameAsc(page);
        } else {
            result = resultTableService.findAllByNameDesc(page);
        }
        return ResponseEntity
                .status(200)
                .body(result);
    }
}
