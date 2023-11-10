package com.teamfresh.voc_manage.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.model.response.CompensationResponse;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompensationService {
    
    private final VocRepository vocRepository;
    private final CompensationRepository compensationRepository;

    public Compensation createCompensation(CompensationRequest.Create request) {
        Optional<Voc> voc = vocRepository.findById(request.getVocId());
        
        Compensation compensation = new Compensation();
        BeanUtils.copyProperties(request, compensation);
        compensation.setVoc(voc.get());
        compensation.setRegDate(LocalDateTime.now());

        return compensationRepository.save(compensation);
    }

    public List<CompensationResponse> compensationList() {
        return compensationRepository.findForCompensationList();
    }
}
