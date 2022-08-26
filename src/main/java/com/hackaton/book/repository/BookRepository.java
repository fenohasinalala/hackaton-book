package com.hackaton.book.repository;

import com.hackaton.book.model.Book;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findByIdBook(Long id);

    List<Book> findByTitleContainingIgnoreCase(String title);
}
