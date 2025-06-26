package com.example.demo.service;

import com.example.demo.dto.BookDTO;

import java.util.List;

public interface LibraryService {
    List<BookDTO> getBooksByAuthorName(String authorName);
    List<BookDTO> getBooksByPublisherName(String publisherName);
}

