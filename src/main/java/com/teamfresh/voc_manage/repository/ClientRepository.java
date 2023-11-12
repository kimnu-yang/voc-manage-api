package com.teamfresh.voc_manage.repository;

import java.util.List;
import java.util.Optional;

import com.teamfresh.voc_manage.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client save(Client client);

    Optional<Client> findById(Long clientId);

    List<Client> findAll();
}
