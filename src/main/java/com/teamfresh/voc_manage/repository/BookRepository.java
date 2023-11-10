package com.teamfresh.voc_manage.repository;

import java.util.List;
import java.util.Optional;

import com.teamfresh.voc_manage.model.Book;

public interface BookRepository extends JpaRepository<Book, Long> {
    Optional<Book> findById(Long id);

    List<Book> findAll();

    Optional<Book> findByIsbn(String isbn);

    Book save(Book bookToCreate);

    void deleteById(Long id);
}
