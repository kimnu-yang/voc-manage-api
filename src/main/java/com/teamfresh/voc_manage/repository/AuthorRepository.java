package com.teamfresh.voc_manage.repository;

import java.util.Optional;

import com.teamfresh.voc_manage.model.Author;

public interface AuthorRepository extends JpaRepository<Author, Long> {

    Optional<Author> findById(Long authorId);

    Author save(Author author);
}
