package com.teamfresh.voc_manage.service;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.error.ErrorResult;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.model.response.CompensationResponse;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class CompensationService {
    
    private final VocRepository vocRepository;
    private final CompensationRepository compensationRepository;

    public Object createCompensation(CompensationRequest.Create request) {
        Optional<Voc> voc = vocRepository.findById(request.getVocId());
        if(!voc.isPresent()){
            return new ErrorResult("2001", "Can't find data by argument: vocId");
        }
        
        Compensation compensation = new Compensation();
        BeanUtils.copyProperties(request, compensation);

        if(compensation.getDetail() == null) {
            return new ErrorResult("1001", "Missing required argument: detail");
        } else if(compensation.getAmount() ==null) {
            return new ErrorResult("1001", "Missing required argument: amount");
        }
        
        compensation.setVoc(voc.get());
        compensation.setRegDate(LocalDateTime.now());

        return compensationRepository.save(compensation);
    }

    public List<CompensationResponse> compensationList() {
        return compensationRepository.findForCompensationList();
    }
}
