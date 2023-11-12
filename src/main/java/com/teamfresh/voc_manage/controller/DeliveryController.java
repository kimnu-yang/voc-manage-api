package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.DeliveryService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/delivery")
@RequiredArgsConstructor
public class DeliveryController {
    private final DeliveryService deliveryService;

    /*
     * 배송정보 생성
     * POST /api/delivery
     * :고객사,운송직원과 연결된 배송 정보를 데이터베이스에 추가
     */
    @PostMapping("")
    public ResponseEntity<?> createDelivery(@RequestBody DeliveryRequest.Create request) {
        return ResponseEntity.ok(deliveryService.createDelivery(request));
    }
}
