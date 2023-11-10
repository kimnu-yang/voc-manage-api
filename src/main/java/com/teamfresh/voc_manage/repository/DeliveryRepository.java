package com.teamfresh.voc_manage.repository;

import java.util.Optional;

import com.teamfresh.voc_manage.model.Delivery;

public interface DeliveryRepository extends JpaRepository<Delivery, Long> {

    Delivery save(Delivery delivery);

    Optional<Delivery> findById(Long voc_id);
}
