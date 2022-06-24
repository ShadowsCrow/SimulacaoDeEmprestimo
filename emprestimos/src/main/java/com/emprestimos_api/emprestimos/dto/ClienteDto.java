package com.emprestimos_api.emprestimos.dto;

import com.emprestimos_api.emprestimos.model.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import javax.persistence.Column;
import javax.persistence.Table;
import javax.persistence.UniqueConstraint;
import java.util.List;
import java.util.stream.Collectors;
@Data
public class ClienteDto
{
    private String name;

    private String cpf;
    private int age;
    private String uf;
    @JsonProperty("renda_mensal")
    private float rendaMensal;

    public ClienteDto(Cliente cliente) {
        this.name = cliente.getName();
        this.cpf = cliente.getCpf();
        this.age = cliente.getAge();
        this.uf = cliente.getUf();
        this.rendaMensal = cliente.getRendaMensal();
    }

    public static List<ClienteDto> convert(List<Cliente> clientes) {
        return clientes.stream().map(ClienteDto::new).collect(Collectors.toList());
    }

    public static ClienteDto convert(Cliente cliente) {
        return new ClienteDto(cliente);
    }
}
