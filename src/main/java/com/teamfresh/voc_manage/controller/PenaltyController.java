package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.PenaltyService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/penalty")
@RequiredArgsConstructor
public class PenaltyController {
    private final PenaltyService penaltyService;

    /*
     * 패널티 정보 생성
     * POST /api/confirm
     * : 배상정보와 연결된 패널티 정보를 데이터베이스에 추가
     */
    @PostMapping("")
    public ResponseEntity<Object> createPenalty(@RequestBody PenaltyRequest.Create request) {
        return ResponseEntity.ok(penaltyService.createPenalty(request));
    }

    /*
     * 패널티 정보 
     * PATCH /api/confirm/패널티ID
     * : 패널티 확인 값과 코멘트를 갱신
     */
    @PatchMapping("/confirm/{penaltyId}")
    public ResponseEntity<?> confirmPenalty(@RequestBody PenaltyRequest.Confirm request, @PathVariable Long penaltyId) {
        return ResponseEntity.ok(penaltyService.confirmPenalty(penaltyId, request));
    }
}
