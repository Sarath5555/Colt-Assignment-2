package com.example.demo.controller;

import com.example.demo.dto.BookDTO;
import com.example.demo.service.LibraryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/library")
public class LibraryController {

    @Autowired
    private LibraryService libraryService;

    @GetMapping("/books/by-author")
    public List<BookDTO> getBooksByAuthor(@RequestParam String name) {
        return libraryService.getBooksByAuthorName(name);
    }

    @GetMapping("/books/by-publisher")
    public List<BookDTO> getBooksByPublisher(@RequestParam String name) {
        return libraryService.getBooksByPublisherName(name);
    }
}
