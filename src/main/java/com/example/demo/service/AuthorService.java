package com.example.demo.service;

import  com.example.demo.domain.Author;

import java.util.List;

public interface AuthorService {

    Author add(String firsname, String lastname) throws Exception;
    long getCount();
    List<Author> getAll(int page, int amountByOnePage);
    Author findById(long id) throws Exception;
    List<Author> find(String firstname, String lastname) throws Exception;
    Author update(long id, String firstname, String lastname) throws Exception;
   void deleteAll();
}