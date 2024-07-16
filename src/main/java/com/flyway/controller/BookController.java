package com.flyway.controller;

import com.flyway.model.Book;
import com.flyway.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/api/book/")
public class BookController {
    private final BookService bookService;

    @GetMapping("/get")
    public ResponseEntity<?> getById(@RequestParam("id") Integer id) {
        return this.bookService.getById(id);
    }

    @GetMapping("/getAll")
    public ResponseEntity<List<?>> getAll() {
        return this.bookService.getAll();
    }

    @PostMapping("/create")
    public ResponseEntity<?> create(@RequestBody Book book) {
        return this.bookService.create(book);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<?> delete(@RequestParam("id") Integer id) {
        return this.bookService.delete(id);
    }
}
