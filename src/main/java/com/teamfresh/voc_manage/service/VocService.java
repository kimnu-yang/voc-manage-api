package com.teamfresh.voc_manage.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import jakarta.persistence.EntityNotFoundException;
import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocService {
    
    private final VocRepository vocRepository;
    private final DeliveryRepository deliveryRepository;

    public Voc vocDetail(Long id) {
        Optional<Voc> voc = vocRepository.findById(id);
        if (voc.isPresent()) {
            return voc.get();
        }

        throw new EntityNotFoundException("Cant find any VOC under given ID");
    }

    public List<Voc> vocList() {
        return vocRepository.findAll();
    }

    public Voc createVoc(VocRequest.Create request) {
        Optional<Delivery> delivery = deliveryRepository.findById(request.getDeliveryId());

        Voc voc = new Voc();
        BeanUtils.copyProperties(request, voc);
        voc.setDelivery(delivery.get());
        voc.setRegDate(LocalDateTime.now());

        return vocRepository.save(voc);
    }
}
