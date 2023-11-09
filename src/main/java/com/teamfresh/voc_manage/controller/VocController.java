package com.teamfresh.voc_manage.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.service.VocService;

import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/voc")
@RequiredArgsConstructor
public class VocController {
    private final VocService vocService;

    @GetMapping("")
    public ResponseEntity<?> VocList() {
        return ResponseEntity.ok(vocService.vocList());
    }

    @PostMapping("")
    public ResponseEntity<Voc> createVoc(@RequestBody VocRequest.Create request) {
        return ResponseEntity.ok(vocService.createVoc(request));
    }
}
