package com.teamfresh.voc_manage.repository;

import java.util.Optional;

import com.teamfresh.voc_manage.model.Book;
import com.teamfresh.voc_manage.model.Lend;
import com.teamfresh.voc_manage.model.LendStatus;

public interface LendRepository extends JpaRepository<Lend, Long> {
    Optional<Lend> findByBookAndStatus(Book book, LendStatus status);

    void save(Lend lend);
}
