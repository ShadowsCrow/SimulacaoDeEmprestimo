package com.emprestimos_api.emprestimos.controller;

import com.emprestimos_api.emprestimos.controller.form.ClienteForm;
import com.emprestimos_api.emprestimos.dto.ClienteDto;
import com.emprestimos_api.emprestimos.model.Cliente;
import com.emprestimos_api.emprestimos.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.util.UriComponentsBuilder;

import javax.validation.Valid;
import java.net.URI;
import java.util.List;

@RequestMapping("/clientes")
@RestController
public class clienteController {

    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<ClienteDto> getTodosClientesOuFiltraPorid(String id) {
            if (id == null) {
                return ClienteDto.convert(clienteRepository.findAll());
            }

            return (List<ClienteDto>) ClienteDto.convert(clienteRepository.findByid(Long.parseLong(id)));

    }

    @PostMapping
    public ResponseEntity<ClienteDto> postNovoRegistroDeCliente(@RequestBody @Valid ClienteForm form, UriComponentsBuilder uriBuilder) {
        Cliente cliente = form.convert();
        clienteRepository.save(cliente);
        URI uri = uriBuilder.path("/clientes/{id}").buildAndExpand(cliente.getId()).toUri();
        return ResponseEntity.created(uri).body(new ClienteDto(cliente));
    }

}



