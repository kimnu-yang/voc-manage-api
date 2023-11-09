package com.teamfresh.voc_manage.repository;

import java.util.Optional;

import com.teamfresh.voc_manage.model.Compensation;

public interface CompensationRepository extends JpaRepository<Compensation, Long> {

    Compensation save(Compensation compensation);

    Optional<Compensation> findById(Long compensation_id);
}
