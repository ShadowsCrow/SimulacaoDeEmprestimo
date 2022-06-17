package com.emprestimos_api.emprestimos.dto;

import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;
import com.emprestimos_api.emprestimos.model.Solicitacao;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

@Data
public class SolicitacaoDto {
    @JsonProperty("numero_solicitacao")
    private String numeroSolicitacao;
    @JsonProperty("data_solicitacao")
    private LocalDateTime dataSolicitacao;
    @JsonProperty("cliente")
    private ClienteDto clienteDto;
    @JsonProperty("produtos_emprestimos")
    private List<IEmprestimo> produtosEmprestimo;

    public SolicitacaoDto(Solicitacao solicitacao) {
        this.numeroSolicitacao = solicitacao.getNumeroSolicitacao();
        this.dataSolicitacao = solicitacao.getDataSolicitacao();
        this.clienteDto = ClienteDto.convert(solicitacao.getCliente());
        this.produtosEmprestimo = solicitacao.getProdutosEmprestimo();
    }

    public static List<SolicitacaoDto> convert(List<Solicitacao> solicitacao) {
        return solicitacao.stream().map(SolicitacaoDto::new).collect(Collectors.toList());
    }
}
