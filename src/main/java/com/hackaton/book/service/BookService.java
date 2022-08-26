package com.hackaton.book.service;

import com.hackaton.book.model.Book;
import com.hackaton.book.repository.BookRepository;
import lombok.AllArgsConstructor;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Service
@AllArgsConstructor
public class BookService {
    private BookRepository bookRepository;

    public List<Book> getAllBooks(){
       return bookRepository.findAll();
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

    public void updateBook(Long id ,Book newBook){
        Optional<Book> thisBook = bookRepository.findByIdBook(id);
        thisBook.get().setTitle(newBook.getTitle());
        thisBook.get().setCategory(newBook.getCategory());
        thisBook.get().setAuthor(newBook.getAuthor());
        thisBook.get().setSynopsis(newBook.getSynopsis());
        thisBook.get().setPages(newBook.getPages());
    }

    public void deleteBookById(Long id){
        bookRepository.deleteById(id);
    }

    public int bookCount(){
        List<Book> allBooks = bookRepository.findAll();
        int bookCount = allBooks.size();
        return bookCount;
    }

    public List<Book> bookByCategory(Long id){
        List<Book> allBooks = bookRepository.findAll();
        List<Book> allBookByCategory = new ArrayList<>();

        for(Book book : allBooks){
            if(book.getCategory().getIdCategory() == id){
                allBookByCategory.add(book);
            }
        }
        return allBookByCategory;
    }
}
