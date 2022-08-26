package com.hackaton.book.controller;

import com.hackaton.book.model.Book;
import com.hackaton.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping("/books")
    public Page<Book> getAllBook(
            @RequestParam(name = "page")Long page,
            @RequestParam(name = "page_size")Long pageSize)
    {
        return bookService.getAllBooks(page, pageSize);
    }
}
