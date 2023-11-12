package com.teamfresh.voc_manage.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.error.ErrorResult;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class DeliveryService {
    
    private final ClientRepository clientRepository;
    private final DeliveryRepository deliveryRepository;
    private final WorkerRepository workerRepository;

    public Object createDelivery(DeliveryRequest.Create request) {
        Optional<Client> client = clientRepository.findById(request.getClientId());
        if(!client.isPresent()){
            return new ErrorResult("2001", "Can't find data by argument: clientId");
        }

        Optional<Worker> worker = workerRepository.findById(request.getWorkerId());
        if(!worker.isPresent()){
            return new ErrorResult("2001", "Can't find data by argument: workerId");
        }

        Delivery delivery = new Delivery();
        BeanUtils.copyProperties(request, delivery);

        if(delivery.getDetail() == null) {
            return new ErrorResult("1001", "Missing required argument: detail");
        }

        delivery.setClient(client.get());
        delivery.setWorker(worker.get());
        delivery.setRegDate(LocalDateTime.now());

        return deliveryRepository.save(delivery);
    }
}
