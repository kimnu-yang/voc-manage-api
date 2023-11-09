package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.PenaltyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/penalty")
@RequiredArgsConstructor
public class PenaltyController {
    private final PenaltyService penaltyService;

    @PostMapping("")
    public ResponseEntity<Penalty> createPenalty(@RequestBody PenaltyRequest.Create request) {
        return ResponseEntity.ok(penaltyService.createPenalty(request));
    }
}
