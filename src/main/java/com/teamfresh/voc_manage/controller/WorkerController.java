package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.WorkerService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/worker")
@RequiredArgsConstructor
public class WorkerController {
    private final WorkerService workerService;

    /*
     * 운송직원 생성
     * POST /api/worker
     * :운송사와 연결된 운송직원 정보를 데이터베이스에 추가
     */
    @PostMapping("")
    public ResponseEntity<?> createWorker(@RequestBody WorkerRequest.Create request) {
        return ResponseEntity.ok(workerService.createWorker(request));
    }
}
