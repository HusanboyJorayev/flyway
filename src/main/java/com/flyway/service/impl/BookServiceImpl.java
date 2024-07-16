package com.flyway.service.impl;

import com.flyway.model.Book;
import com.flyway.repository.BookRepository;
import com.flyway.service.BookService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class BookServiceImpl implements BookService {
    private final BookRepository bookRepository;

    @Override
    public ResponseEntity<?> getById(Integer id) {
        Book book = this.bookRepository.findById(id)
                .orElse(new Book());
        return ResponseEntity.ok(book);
    }

    @Override
    public ResponseEntity<List<?>> getAll() {
        List<Book> books = this.bookRepository.findAll();
        return ResponseEntity.ok(books);
    }

    @Override
    public ResponseEntity<?> create(Book book) {
        this.bookRepository.save(book);
        return ResponseEntity.ok("BOOK CREATED");
    }

    @Override
    public ResponseEntity<?> delete(Integer id) {
        if (this.bookRepository.findById(id).isPresent()) {
            this.bookRepository.deleteById(id);
            return ResponseEntity.ok("BOOK DELETED");
        }
        return ResponseEntity.ok("BOOK IS NOT FOUND");
    }
}
