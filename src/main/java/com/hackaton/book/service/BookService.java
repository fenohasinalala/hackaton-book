package com.hackaton.book.service;

import com.hackaton.book.model.Book;
import com.hackaton.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public Page<Book> getAllBooks(Long page, Long pageSize){
        if(page != null && pageSize != null){
            Pageable pageable = PageRequest.of(Math.toIntExact(page), Math.toIntExact(pageSize));
            return bookRepository.findAll(pageable);
        }else {
            return (Page<Book>) bookRepository.findAll();
        }
    }

    public Optional<Book> getBookById(Long id){
        return bookRepository.findByIdBook(id);
    }

    public List<Book> getBookByTitle (String title){
        return bookRepository.findByTitleContainingIgnoreCase(title);
    }

    public void insertBook(Book book){
        bookRepository.save(book);
    }
}
