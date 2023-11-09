package com.teamfresh.voc_manage.service;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.stereotype.Service;

import com.teamfresh.voc_manage.model.*;
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

    public Client createClient(ClientRequest.Create request) {
        Client client = new Client();
        BeanUtils.copyProperties(request, client);

        return clientRepository.save(client);
    }
}
