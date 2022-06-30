package com.emprestimos_api.emprestimos.controller;

import com.emprestimos_api.emprestimos.dto.SolicitacaoDto;
import com.emprestimos_api.emprestimos.model.Cliente;
import com.emprestimos_api.emprestimos.model.Solicitacao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import com.emprestimos_api.emprestimos.repository.ClienteRepository;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RequestMapping("/solicitacoes")
@RestController
public class solicitacaoController {
    @Autowired
    private ClienteRepository clienteRepository;

    @GetMapping
    public List<SolicitacaoDto> getTodasAsSolicitacoesOuFiltraPeloIDDoCliente(String id) {

        List<Cliente> clientes = new ArrayList<>();
        List<Solicitacao> solicitacoes = new ArrayList<>();

        if (id == null) {
            clientes = clienteRepository.findAll();
        }
        else{
            clientes = clienteRepository.findByid(Long.parseLong(id));
        }

        for (Cliente cliente : clientes) {
            Solicitacao solicitacao = new Solicitacao(cliente);
            solicitacoes.add(solicitacao);
        }

        return SolicitacaoDto.convert(solicitacoes);


    }
}
