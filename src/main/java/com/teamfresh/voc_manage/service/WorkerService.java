package com.teamfresh.voc_manage.service;

import java.util.Optional;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.error.ErrorResult;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class WorkerService {
    
    private final TransportRepository transportRepository;
    private final WorkerRepository workerRepository;

    public Object createWorker(WorkerRequest.Create request) {
        Optional<Transport> transport = transportRepository.findById(request.getTransportId());
        if(!transport.isPresent()){
            return new ErrorResult("2001", "Can't find data by argument: transportId");
        }

        Worker worker = new Worker();
        BeanUtils.copyProperties(request, worker);

        if(worker.getName() == null) {
            return new ErrorResult("1001", "Missing required argument: name");
        } else if (worker.getContact() == null) {
            return new ErrorResult("1001", "Missing required argument: contact");
        }

        worker.setTransport(transport.get());

        return workerRepository.save(worker);
    }
}
