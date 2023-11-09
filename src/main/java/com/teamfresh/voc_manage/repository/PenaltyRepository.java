package com.teamfresh.voc_manage.repository;

import com.teamfresh.voc_manage.model.Penalty;

public interface PenaltyRepository extends JpaRepository<Penalty, Long> {

    Penalty save(Penalty penalty);
}
