package com.emprestimos_api.emprestimos.dto;

import lombok.Data;

@Data
public class ErroDeFormularioDto {

    private String campo;
    private String mensagem;


    public ErroDeFormularioDto(String campo, String mensagem) {
        this.campo = campo;
        this.mensagem = mensagem;
    }

}
