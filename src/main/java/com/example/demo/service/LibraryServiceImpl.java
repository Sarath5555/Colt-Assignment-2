package com.example.demo.service;

import com.example.demo.dto.BookDTO;
import com.example.demo.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class LibraryServiceImpl implements LibraryService {

    @Autowired
    private BookRepository bookRepository;

    @Override
    public List<BookDTO> getBooksByAuthorName(String authorName) {
        return bookRepository.findBooksByAuthorName(authorName);
    }

    @Override
    public List<BookDTO> getBooksByPublisherName(String publisherName) {
        return bookRepository.findBooksByPublisherName(publisherName);
    }
}
