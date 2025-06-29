package com.example.springBoot2.controllers;

import com.example.springBoot2.models.Book;
import com.example.springBoot2.repositories.BookRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/books")
public class BookController {
    private final BookRepository bookRepository;

    public BookController(BookRepository bookRepository) {
        this.bookRepository = bookRepository;
    }

    // Lists all stored books from DB
    @GetMapping
    public List<Book> getAllItems(){
        return bookRepository.findAll();
    }

    // List ID from DB.
    @GetMapping("/{id}")
    public Book getItem(@PathVariable int id) {
        return bookRepository.findById(id).orElse(null);
    }

    // Add's item to database
    @PostMapping
    public Book addItem(@RequestBody Book book) {
        return bookRepository.save(book);
    }

    // Update Item in database
    @PutMapping("/{id}")
    public Book updateItem(@PathVariable int id, @RequestBody Book book){
        book.setId(id);
        return bookRepository.save(book);
    }

    // Deletes an item
    @DeleteMapping("/{id}")
    public void deleteItem (@PathVariable int id) {
        bookRepository.deleteById(id);
    }
}