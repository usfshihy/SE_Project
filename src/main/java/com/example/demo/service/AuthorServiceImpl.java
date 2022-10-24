package com.example.demo.service;


import  com.example.demo.domain.Author;
import  com.example.demo.repository.AuthorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

import static  com.example.demo.service.HandlerException.EMPTY_RESULT_BY_ID_ERROR_STRING;
import static  com.example.demo.service.HandlerException.handlerException;

@Service
public class AuthorServiceImpl implements AuthorService {

    @Autowired
    private AuthorRepository authorRepository;

    @Override
    public Author add(String firsname, String lastname) throws Exception {
        Author author = new Author(firsname, lastname);
        try {
            authorRepository.save(author);
        }
        catch(DataIntegrityViolationException exception) {
            handlerException(exception, author.toString());
        }
        return author;
    }

    @Override
    public long getCount() {
        return authorRepository.count();
    }

    @Override
    public List<Author> getAll(int page, int amountByOnePage) {
        return authorRepository.findAll(PageRequest.of(page,amountByOnePage)).getContent();
    }

    @Override
    public Author findById(long id) {
        Author byId = authorRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Author.class.getSimpleName(), id)));
        return byId;
    }

    @Override
    public List<Author> find(String frstname, String lastname) throws Exception {
        List<Author> authors = new ArrayList<>();
        try {
            authorRepository.findByFirstnameOrLastname(frstname, lastname).forEach(authors::add);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Author.class.getSimpleName());
        }
        return authors;
    }



    @Override
    public Author update(long id, String firstname, String lastname) throws Exception {
        Author author = authorRepository.findById(id).orElseThrow(()->
                new IllegalArgumentException(String.format(EMPTY_RESULT_BY_ID_ERROR_STRING, Author.class.getSimpleName(), id)));
        if(firstname!= null)
            author.setFirstname(firstname);
        if(lastname!=null)
            author.setLastname(lastname);
        try {
            authorRepository.save(author);
        }
        catch (DataIntegrityViolationException exception) {
            handlerException(exception, Author.class.getSimpleName());
        }
        return author;
    }

    @Override
    public void deleteAll() {
        authorRepository.deleteAll();
    }
}
