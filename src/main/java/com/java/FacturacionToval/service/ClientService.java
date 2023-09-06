package com.java.FacturacionToval.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.java.FacturacionToval.model.Client;
import com.java.FacturacionToval.repository.ClientRepository;

@Service
public class ClientService {
    @Autowired
    private ClientRepository clienteRepository;

    public Client crearCliente(Client cliente) throws Exception {
        return clienteRepository.save(cliente);
    }

    public Client obtenerCliente(int id) throws Exception {
        Optional<Client> clienteExistente = clienteRepository.findById(id);
        if (!clienteExistente.isPresent()) {
            throw new Exception("Client with id: " + id + " not found.");
        } else {
            return clienteExistente.get();
        }
    }

    public void modificarCliente(Client client, int id) throws Exception {
        Optional<Client> clienteExistente = clienteRepository.findById(id);
        if (clienteExistente.isPresent()) {
            throw new Exception("Client with id: " + id + " not found.");
        } else {
            clienteExistente.get().setDocnumber(client.getDocnumber());
            clienteExistente.get().setName(client.getName());
            clienteExistente.get().setLastname(client.getLastname());
            clienteRepository.save(clienteExistente.get());
        }
    }

    public void borrarCliente(int id) throws Exception {
        Optional<Client> clienteExistente = clienteRepository.findById(id);
        if (!clienteExistente.isPresent()) {
            throw new Exception("Client with id: " + id + " not found.");
        } else {
            clienteRepository.deleteById(id);
        }
    }

}
