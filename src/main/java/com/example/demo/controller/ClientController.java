package com.example.demo.controller;

import com.example.demo.dto.ClientData;
import com.example.demo.dto.ClientDTO;
import com.example.demo.service.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URI;
import java.util.List;

@RestController
@RequestMapping(value = "/")
public class ClientController {
    @Autowired
    ClientService clientService;

    @PostMapping(path = "/crearclient", consumes = MediaType.APPLICATION_JSON_VALUE, produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity addClient(
            @RequestBody
                    ClientDTO clientDTO
    ) {
        int result = clientService.addClient(clientDTO);
        return ResponseEntity.created(URI.create("/client/" + result)).build();
    }

    @GetMapping(path = "/listclientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<List<ClientDTO>> getAllClients(
            @RequestParam(value = "limit", defaultValue = "5") int limit,
            @RequestParam(value = "page", defaultValue = "0") int page
    ) {
        List<ClientDTO> allClients = clientService
                .getAllClients(limit, page);
        return ResponseEntity.ok(allClients);
    }

    @GetMapping(path = "/kpideclientes", produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<ClientData> getKpiData() {
        return ResponseEntity.ok(clientService.getData());
    }
}
