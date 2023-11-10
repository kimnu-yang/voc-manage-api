package com.teamfresh.voc_manage.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.enum_data.ConfirmStatus;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PenaltyService {
    
    private final CompensationRepository compensationRepository;
    private final PenaltyRepository penaltyRepository;

    public Penalty createPenalty(PenaltyRequest.Create request) {
        Optional<Compensation> compensation =  compensationRepository.findById(request.getCompensationId());
        
        Penalty penalty = new Penalty();
        BeanUtils.copyProperties(request, penalty);
        penalty.setCompensation(compensation.get());
        penalty.setRegDate(LocalDateTime.now());
        penalty.setConfirm(ConfirmStatus.CHECKING);

        return penaltyRepository.save(penalty);
    }
}
