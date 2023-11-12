package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.CompensationService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/compensation")
@RequiredArgsConstructor
public class CompensationController {
    private final CompensationService compensationService;

    /*
     * 배상정보 리스트 조회
     * GET /api/voc
     * :데이터베이스에서 배상 정보를 조회
     */
    @GetMapping("")
    public ResponseEntity<?> compensationList() {
        return ResponseEntity.ok(compensationService.compensationList());
    }

    /*
     * 배상 정보 생성
     * POST /api/voc
     * : VOC와 연결된 배상 정보를 데이터베이스에 추가
     */
    @PostMapping("")
    public ResponseEntity<?> createCompensation(@RequestBody CompensationRequest.Create request) {
        return ResponseEntity.ok(compensationService.createCompensation(request));
    }
}
