package com.example.demo.service;

import com.example.demo.domain.Inspector;

import java.util.List;

public interface InspectorService {

    Inspector add(String majord, String minord, String pdsize, String pdtime, String pdrate, String estyield) throws Exception;
    long getCount();
    List<Inspector> getAll(int page, int amountByOnePage);
    Inspector findById(long id) throws Exception;
    List<Inspector> find(String majord, String minord, String pdsize, String pdtime, String pdrate, String estyield) throws Exception;
    Inspector update(long id, String majord, String minord, String pdsize, String pdtime, String pdrate, String estyield) throws Exception;
   void deleteAll();
}