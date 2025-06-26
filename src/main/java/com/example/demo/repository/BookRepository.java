package com.example.demo.repository;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface BookRepository extends JpaRepository<Book, Long> {

    @Query("SELECT new com.example.demo.dto.BookDTO(b.title, a.name, p.publisherName) " +
        "FROM Book b " +
        "JOIN b.author a " +
        "JOIN b.publisher p " +
        "WHERE a.name = :authorName")
    List<BookDTO> findBooksByAuthorName(@Param("authorName") String authorName);


    @Query("SELECT new com.example.demo.dto.BookDTO(b.title, a.name, p.publisherName) " +
       "FROM Book b " +
       "JOIN b.author a " +
       "JOIN b.publisher p " +
       "WHERE p.publisherName = :publisherName")
    List<BookDTO> findBooksByPublisherName(@Param("publisherName") String publisherName);
    
}
