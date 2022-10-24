package com.example.demo.service;
import  com.example.demo.domain.Book;

import java.util.List;
public interface BookService {
   Book add(String title, String code) throws Exception;
    long getCount();
    List<Book> getAll(int page, int amountByOnePage);
    Book findById(long id) throws Exception;
    List<Book> find(String title, String code) throws Exception;
    Book update(long id, String title, String code) throws Exception;
    void deleteAll();
}