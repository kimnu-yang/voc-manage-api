package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.VocService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/voc")
@RequiredArgsConstructor
public class VocController {
    private final VocService vocService;

    /*
     * VOC 리스트 조회
     * GET /api/voc
     * :데이터베이스에서 VOC 정보를 조회
     */
    @GetMapping("")
    public ResponseEntity<?> VocList() {
        return ResponseEntity.ok(vocService.vocList());
    }

    /*
     * VOC 정보 생성
     * POST /api/voc
     * : 고객사, 배송정보와 연결된 VOC 정보를 데이터베이스에 추가
     */
    @PostMapping("")
    public ResponseEntity<?> createVoc(@RequestBody VocRequest.Create request) {
        return ResponseEntity.ok(vocService.createVoc(request));
    }
}
