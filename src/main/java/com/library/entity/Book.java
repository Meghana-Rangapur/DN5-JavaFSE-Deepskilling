package com.library.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

@Entity // Tells JPA to turn this class into a database table
public class Book {

    @Id // Marks this field as the Primary Key
    @GeneratedValue(strategy = GenerationType.IDENTITY) // Auto-increments IDs (1, 2, 3...)
    private Long id;
    private String title;
    private String author;

    // Constructors
    public Book() {}
    public Book(String title, String author) {
        this.title = title;
        this.author = author;
    }

    // Getters and Setters
    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getTitle() { return title; }
    public void setTitle(String title) { this.title = title; }
    public String getAuthor() { return author; }
    public void setAuthor(String author) { this.author = author; }
}