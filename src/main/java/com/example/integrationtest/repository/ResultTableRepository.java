package com.example.integrationtest.repository;

import com.example.integrationtest.model.ResultTable;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Component;

import java.awt.print.Pageable;
import java.util.List;

@Component
public interface ResultTableRepository extends PagingAndSortingRepository<ResultTable, Integer> {

    public List<ResultTable> findAllByTypeIgnoreCase(String type);
//    public List<ResultTable> findAllById(Pageable pageable);

}
