package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.CompensationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compensation")
@RequiredArgsConstructor
public class CompensationController {
    private final CompensationService compensationService;

    @PostMapping("")
    public ResponseEntity<Compensation> createCompensation(@RequestBody CompensationRequest.Create request) {
        return ResponseEntity.ok(compensationService.createCompensation(request));
    }
}
