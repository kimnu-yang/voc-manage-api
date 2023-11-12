package com.teamfresh.voc_manage.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.error.ErrorResult;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.model.response.VocResponse;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class VocService {
    
    private final VocRepository vocRepository;
    private final DeliveryRepository deliveryRepository;

    public Object createVoc(VocRequest.Create request) {
        Optional<Delivery> delivery = deliveryRepository.findById(request.getDeliveryId());
        if(!delivery.isPresent()){
            return new ErrorResult("2001", "Can't find data by argument: deliveryId");
        }

        Voc voc = new Voc();
        BeanUtils.copyProperties(request, voc);

        if(voc.getArisenFrom() == null) {
            return new ErrorResult("1001", "Missing required argument: arisenFrom");
        } else if(voc.getReason() == null) {
            return new ErrorResult("1001", "Missing required argument: reason");
        }

        voc.setDelivery(delivery.get());
        voc.setRegDate(LocalDateTime.now());

        return vocRepository.save(voc);
    }

    public List<VocResponse> vocList() {
        return vocRepository.findForVocList();
    }

    public Object vocDetail(Long id) {
        Optional<Voc> voc = vocRepository.findById(id);
        if (voc.isPresent()) {
            return voc.get();
        }

        return new ErrorResult("2001", "Can't find data by argument: vocId");
    }
}
