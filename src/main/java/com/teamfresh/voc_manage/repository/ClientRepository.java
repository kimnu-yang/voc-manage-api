package com.teamfresh.voc_manage.repository;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.Query;

import com.teamfresh.voc_manage.model.Client;

public interface ClientRepository extends JpaRepository<Client, Long> {

    Client save(Client client);

    Optional<Client> findById(Long clientId);

    List<Client> findAll();
}
