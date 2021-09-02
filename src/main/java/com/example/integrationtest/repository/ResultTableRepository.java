package com.example.integrationtest.repository;

import com.example.integrationtest.model.Meals;
import com.example.integrationtest.model.ResultTable;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface ResultTableRepository extends CrudRepository<ResultTable, Integer> {

    public List<ResultTable> findAllByTypeIgnoreCase(String type);
    public List<ResultTable> findAllByIdBetween(int min, int max);

}
