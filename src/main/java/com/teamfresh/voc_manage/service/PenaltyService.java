package com.teamfresh.voc_manage.service;

import java.time.LocalDateTime;
import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.enum_data.ConfirmStatus;
import com.teamfresh.voc_manage.model.error.ErrorResult;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class PenaltyService {
    
    private final CompensationRepository compensationRepository;
    private final PenaltyRepository penaltyRepository;

    public Object createPenalty(PenaltyRequest.Create request) {
        Optional<Compensation> compensation =  compensationRepository.findById(request.getCompensationId());
        if(!compensation.isPresent()){
            return new ErrorResult("2001", "Can't find data by argument: compensationId");
        }
        
        Penalty penalty = new Penalty();
        BeanUtils.copyProperties(request, penalty);

        if(penalty.getFine() == null) {
            return new ErrorResult("1001", "Missing required argument: fine");
        }

        penalty.setCompensation(compensation.get());
        penalty.setRegDate(LocalDateTime.now());
        penalty.setConfirm(ConfirmStatus.CHECKING);

        return penaltyRepository.save(penalty);
    }

    public Object confirmPenalty(Long id, PenaltyRequest.Confirm request) {
        
        Optional<Penalty> optionalPenalty =  penaltyRepository.findById(id);
        if (!optionalPenalty.isPresent()) {
            return new ErrorResult("2001", "Can't find data by argument: penaltyId");
        }
        
        Penalty penalty = optionalPenalty.get();
        penalty.setConfirm(request.getConfirmStatus());
        penalty.setComment(request.getComment());
        penalty.setConfirmDate(LocalDateTime.now());

        if(penalty.getConfirm() == null) {
            return new ErrorResult("1001", "Missing required argument: confirmStatus");
        } else if(penalty.getComment() == null) {
            return new ErrorResult("1001", "Missing required argument: comment");
        }

        return penaltyRepository.save(penalty);
    }
}
