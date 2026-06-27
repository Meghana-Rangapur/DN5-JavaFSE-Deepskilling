package com.library;

import com.library.entity.Book;
import com.library.repository.BookRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class LibraryManagementApplication {

    public static void main(String[] args) {
        // Launches the embedded Tomcat web server instantly
        SpringApplication.run(LibraryManagementApplication.class, args);
    }

    // Pre-populate our database with some dummy book data at startup
    @Bean
    public CommandLineRunner demoData(BookRepository repository) {
        return args -> {
            repository.save(new Book("The Alchemist", "Paulo Coelho"));
            repository.save(new Book("To Kill a Mockingbird", "Harper Lee"));
            System.out.println(">>> Demo data successfully inserted into H2 Database!");
        };
    }
}