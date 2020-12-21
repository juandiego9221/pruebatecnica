package com.example.demo.service;

import com.example.demo.dto.ClientData;
import com.example.demo.dto.ClientDTO;
import com.example.demo.entity.Client;
import com.example.demo.repository.ClientRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.OptionalDouble;
import java.util.stream.Collectors;

@Service
public class ClientServiceImpl implements ClientService {

    @Autowired
    ClientRepository clientRepository;

    @Override
    public int addClient(ClientDTO clientDTO) {
        Client client = new Client();
        client.setAge(clientDTO.getAge());
        client.setBirthday(clientDTO.getBirthday());
        client.setLastname(clientDTO.getLastname());
        client.setName(clientDTO.getName());
        int id = clientRepository.save(client).getId();
        return id;
    }

    @Override
    public List<ClientDTO> getAllClients(int limit, int page) {
        List<ClientDTO> clients = clientRepository
                .findAll(PageRequest.of(page, limit)).getContent().stream().map(this::toClientResponse).collect(Collectors.toList());
        return clients;
    }

    @Override
    public ClientData getData() {
        List<Client> all = clientRepository.findAll();
        OptionalDouble result = all.stream().mapToInt(Client::getAge).average();
        double asDouble = result.getAsDouble();//promedio
        List<Double> collect = all.stream().map(x -> {
            double i = Math.pow(x.getAge() - asDouble, 2);
            return i;
        }).collect(Collectors.toList());
        double sum = collect.stream().mapToDouble(Double::doubleValue).sum();
        double asDouble2 = Math.sqrt(sum / (double) all.size());
        BigDecimal average = new BigDecimal(asDouble);
        BigDecimal desviation = new BigDecimal(asDouble2);
        ClientData clientData = new ClientData();
        clientData.setAverageAge(average);
        clientData.setDesviation(desviation);
        return clientData;
    }

    private ClientDTO toClientResponse(Client client) {
        ClientDTO clientDTO = new ClientDTO();
        BeanUtils.copyProperties(client, clientDTO);
        return clientDTO;
    }

}
