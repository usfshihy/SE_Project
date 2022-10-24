package com.example.demo.repository;


import com.example.demo.domain.Author;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface AuthorRepository extends PagingAndSortingRepository<Author, Long> {

    Iterable<Author> findByFirstnameOrLastname(String firstname, String lastname);

}