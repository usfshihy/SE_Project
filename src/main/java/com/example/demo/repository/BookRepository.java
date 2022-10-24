package com.example.demo.repository;
import com.example.demo.domain.Book;
import org.springframework.data.repository.PagingAndSortingRepository;

public interface BookRepository extends PagingAndSortingRepository<Book, Long> {

    Iterable<Book> findByTitleOrCode(String title, String code);

}
