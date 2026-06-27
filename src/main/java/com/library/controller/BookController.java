package com.library.controller;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // Tells Spring this class exposes REST API endpoints returning JSON
@RequestMapping("/api/books") // Base URL prefix for all requests
public class BookController {

    private final BookRepository bookRepository;

    @Autowired
    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Endpoint 1: Get all books (HTTP GET -> http://localhost:8080/api/books)
    @GetMapping
    public List<Book> getAllBooks() {
        return bookRepository.findAll();
    }

    // Endpoint 2: Add a new book (HTTP POST -> http://localhost:8080/api/books)
    @PostMapping
    public Book createBook(@RequestBody Book book) {
        return bookRepository.save(book);
    }
}