package com.teamfresh.voc_manage.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkerService {
    
    private final TransportRepository transportRepository;
    private final WorkerRepository workerRepository;

    public Worker createWorker(WorkerRequest.Create request) {
        Optional<Transport> transport = transportRepository.findById(request.getTransportId());

        Worker worker = new Worker();
        BeanUtils.copyProperties(request, worker);
        worker.setTransport(transport.get());

        return workerRepository.save(worker);
    }
}
