package com.teamfresh.voc_manage.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    
    private final ClientRepository clientRepository;
    private final DeliveryRepository deliveryRepository;
    private final WorkerRepository workerRepository;

    public Delivery createDelivery(DeliveryRequest.Create request) {
        Optional<Client> client = clientRepository.findById(request.getClientId());
        Optional<Worker> worker = workerRepository.findById(request.getWorkerId());

        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(request, delivery);
        delivery.setClient(client.get());
        delivery.setWorker(worker.get());
        delivery.setRegDate(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
