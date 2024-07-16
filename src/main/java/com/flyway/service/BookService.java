package com.flyway.service;

import com.flyway.model.Book;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public interface BookService {
    ResponseEntity<?> getById(Integer id);

    ResponseEntity<List<?>> getAll();

    ResponseEntity<?> create(Book book);

    ResponseEntity<?> delete(Integer id);
}
