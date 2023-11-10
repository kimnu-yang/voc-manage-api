package com.teamfresh.voc_manage.repository;

import java.util.List;
import java.util.Optional;

import com.teamfresh.voc_manage.model.Voc;

public interface VocRepository extends JpaRepository<Voc, Long> {

    Voc save(Voc voc);
    
    Optional<Voc> findById(Long id);

    List<Voc> findAll();
}