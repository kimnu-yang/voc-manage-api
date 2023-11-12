package com.teamfresh.voc_manage.service;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.error.ErrorResult;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class TransportService {
    
    private final TransportRepository transportRepository;

    public Object createTransport(TransportRequest.Create request) {
        Transport transport = new Transport();
        BeanUtils.copyProperties(request, transport);

        if(transport.getName() == null) {
            return new ErrorResult("1001", "Missing required argument: name");
        } else if (transport.getManager() == null) {
            return new ErrorResult("1001", "Missing required argument: manager");
        } else if (transport.getContact() == null) {
            return new ErrorResult("1001", "Missing required argument: contact");
        }

        return transportRepository.save(transport);
    }
}