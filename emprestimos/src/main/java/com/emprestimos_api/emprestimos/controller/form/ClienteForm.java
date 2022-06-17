package com.emprestimos_api.emprestimos.controller.form;

import com.emprestimos_api.emprestimos.model.Cliente;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;
import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

@Data
public class ClienteForm {

    @NotNull @NotEmpty @Length(max = 100)
    private String name;
    @NotNull @NotEmpty @Length(min=14, max = 14)
    private String cpf;
    @NotNull
    private int age;
    @NotNull @NotEmpty @Length(max = 2)
    private String uf;
    @JsonProperty("renda_mensal")
    @NotNull
    private float rendaMensal;


    public Cliente convert() {
        Cliente cliente = new Cliente();
        cliente.setName(name);
        cliente.setCpf(cpf);
        cliente.setAge(age);
        cliente.setUf(uf);
        cliente.setRendaMensal(rendaMensal);

        return cliente;
    }
}
