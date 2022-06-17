package com.emprestimos_api.emprestimos.model;

import com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos.EmprestimoGarantia;
import com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos.EmprestimoPessoal;
import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;
import com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos.EmprestimoConsignado;
import com.emprestimos_api.emprestimos.service.GerenciadorDeModalidadeDeEmprestimoParaClienteService;
import lombok.Data;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

@Data
public class Solicitacao {
    private String numeroSolicitacao;
    private LocalDateTime dataSolicitacao;
    private Cliente cliente;
    private List<IEmprestimo> produtosEmprestimo;

    public Solicitacao(Cliente cliente) {
        this.numeroSolicitacao = UUID.randomUUID().toString();
        this.dataSolicitacao = LocalDateTime.now();
        this.cliente = cliente;
        executaValidacaoDeClienteParaCadaTipoEmprestimoListado();
    }

    public void executaValidacaoDeClienteParaCadaTipoEmprestimoListado() {

        List<IEmprestimo> emprestimosPossiveis = List.of(new EmprestimoPessoal("Emprestimo Pessoal", 4), new EmprestimoConsignado("Emprestimo Consignado", 2), new EmprestimoGarantia("Emprestimo Garantia", 3));

        GerenciadorDeModalidadeDeEmprestimoParaClienteService gerenciadorDeModalidadeDeEmprestimo = new GerenciadorDeModalidadeDeEmprestimoParaClienteService(emprestimosPossiveis);

        this.produtosEmprestimo = gerenciadorDeModalidadeDeEmprestimo.validaSeClienteTemAcessoAoEmprestimo(cliente);

    }
}
