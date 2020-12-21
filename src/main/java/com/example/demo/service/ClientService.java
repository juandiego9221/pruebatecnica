package com.example.demo.service;

import com.example.demo.dto.ClientData;
import com.example.demo.dto.ClientDTO;

import java.util.List;

public interface ClientService {
    int addClient(ClientDTO clientDTO);

    List<ClientDTO> getAllClients(int limit, int page);

    ClientData getData();
}
