package com.example.demo.service;

import  com.example.demo.domain.Book;
import  com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static  com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static  com.example.demo.service.HandlerException.handlerException;

@Service
public class BookServiceImpl implements BookService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public Book add(String title, String code) throws Exception {
        Book book = new Book(title, code);
        try {
            bookRepository.save(book);
        }
        catch(DataIntegrityViolationException exception) {
            handlerException(exception, book.toString());
        }
        return book;
    }

    @Override
    public long getCount() {
        return bookRepository.count();
    }

    @Override
    public List<Book> getAll(int page, int amountByOnePage) {
        return bookRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Book findById(long id) {
        Book byId = bookRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING,
                        Book.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Book> find(String title, String code) throws Exception {
        List<Book> books = new ArrayList<>();
        try {
            bookRepository.findByTitleOrCode(title,code).forEach(books::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Book.class.getSimpleName());
        }
        return books;
    }



    @Override
    public Book update(long id, String title, String code) throws Exception {
       Book book = bookRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING,
                        Book.class.getSimpleName(), id)));
        if(title!= null)
            book.setTitle(title);
        if(code!=null)
            book.setCode(code);
        try {
            bookRepository.save(book);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Book.class.getSimpleName());
        }
        return book;
    }





    @Override
    public void deleteAll() {
        bookRepository.deleteAll();
    }
}
