package com.hackaton.book.controller;

import com.hackaton.book.model.Book;
import com.hackaton.book.service.BookService;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@AllArgsConstructor
public class BookController {
    private BookService bookService;

    @GetMapping("/books")
    public List<Book> getAllBook(){
        return bookService.getAllBooks();
    }

    @GetMapping("/books/{id}")
    public Optional<Book> getBookById(@PathVariable(name = "id")Long id){
        return bookService.getBookById(id);
    }

    @GetMapping("/books/count")
    public int getBooksCount(){
        return bookService.bookCount();
    }

    @GetMapping("/categories/{id_category}/books")
    public List<Book> bookByIdCategroy(@PathVariable Long idCategory){
        return bookService.bookByCategory(idCategory);
    }

    @PostMapping("/books")
    public void insertBook(@RequestBody Book book){
        bookService.insertBook(book);
    }

    @PutMapping("books/{id}")
    public void updateBook(
            @PathVariable(name = "id")Long id,
            @RequestBody Book newBook
    ){
        bookService.updateBook(id, newBook);
    }

    @DeleteMapping("/books/{id}")
    public void deleteBook(@PathVariable Long id){
        bookService.deleteBookById(id);
    }
}
