package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.request.ClientRequest;
import com.teamfresh.voc_manage.service.ClientService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/client")
@RequiredArgsConstructor
public class ClientController {
    private final ClientService clientService;

    /*
     * 고객사 조회
     * GET /api/client
     * :데이터베이스에 등록된 모든 고객사를 조회
     */
    @GetMapping("")
    public ResponseEntity<?> clientList() {
        return ResponseEntity.ok(clientService.clientList());
    }

    /*
     * 고객사 생성
     * POST /api/client
     * :고객사 정보를 데이터베이스에 추가
     */
    @PostMapping("")
    public ResponseEntity<?> createClient(@RequestBody ClientRequest.Create request) {
        return ResponseEntity.ok(clientService.createClient(request));
    }
}
