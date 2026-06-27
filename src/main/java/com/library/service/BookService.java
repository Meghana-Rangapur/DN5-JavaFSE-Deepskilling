package com.library.service;

import com.library.repository.BookRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class BookService {

    private final BookRepository bookRepository;
    private String injectionType;

    // 1. CONSTRUCTOR INJECTION
    // Spring automatically looks for a BookRepository bean and passes it here when creating the service object.
    @Autowired
    public BookService(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
        this.injectionType = "Constructor Injection";
    }

    // 2. SETTER INJECTION (Optional fallback / Demonstration)
    // If you ever want to change or re-inject the repository later, Spring uses this.
    // Note: We remove @Autowired here to let Constructor Injection take priority by default.
    public void setBookRepository(BookRepository bookRepository) {
        // this.bookRepository = bookRepository;
        this.injectionType = "Setter Injection";
    }

    public void runService() {
        System.out.println("[Service] Executing core business logic...");
        System.out.println("[Info] Dependency was wired using: " + injectionType);
    }
}