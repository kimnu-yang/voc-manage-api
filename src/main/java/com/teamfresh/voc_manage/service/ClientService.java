package com.teamfresh.voc_manage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
import com.teamfresh.voc_manage.model.error.ErrorResult;
import com.teamfresh.voc_manage.model.request.*;
import com.teamfresh.voc_manage.repository.*;

import lombok.RequiredArgsConstructor;

@Service
@RequiredArgsConstructor
public class ClientService {
    
    private final ClientRepository clientRepository;

    public List<Client> clientList() {
        return clientRepository.findAll();
    }

    public Object createClient(ClientRequest.Create request) {
        Client client = new Client();
        BeanUtils.copyProperties(request, client);

        if(client.getName() == null) {
            return new ErrorResult("1001", "Missing required argument: name");
        } else if (client.getManager() == null) {
            return new ErrorResult("1001", "Missing required argument: manager");
        } else if (client.getContact() == null) {
            return new ErrorResult("1001", "Missing required argument: contact");
        }

        return clientRepository.save(client);
    }
}
