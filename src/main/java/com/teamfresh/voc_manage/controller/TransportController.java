package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.TransportService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/transport")
@RequiredArgsConstructor
public class TransportController {
    private final TransportService transportService;

    /*
     * 운송사 생성
     * POST /api/transport
     * :운송사 정보를 데이터베이스에 추가
     */
    @PostMapping("")
    public ResponseEntity<?> createTransport(@RequestBody TransportRequest.Create request) {
        return ResponseEntity.ok(transportService.createTransport(request));
    }
}
