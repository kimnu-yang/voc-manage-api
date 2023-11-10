package com.teamfresh.voc_manage.repository;

import java.util.Optional;

import com.teamfresh.voc_manage.model.Transport;

public interface TransportRepository extends JpaRepository<Transport, Long> {

    Transport save(Transport transport);

    Optional<Transport> findById(Long transport_id);
}
