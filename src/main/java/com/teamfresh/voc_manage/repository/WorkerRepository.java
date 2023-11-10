package com.teamfresh.voc_manage.repository;

import java.util.Optional;

import com.teamfresh.voc_manage.model.Worker;

public interface WorkerRepository extends JpaRepository<Worker, Long> {

    Worker save(Worker worker);

    Optional<Worker> findById(Long worker_id);
}
