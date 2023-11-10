package com.teamfresh.voc_manage.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportService {
    
    private final TransportRepository transportRepository;

    public Transport createTransport(TransportRequest.Create request) {
        Transport transport = new Transport();
        BeanUtils.copyProperties(request, transport);

        return transportRepository.save(transport);
    }
}