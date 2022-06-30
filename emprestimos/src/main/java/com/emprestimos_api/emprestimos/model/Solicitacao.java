package com.emprestimos_api.emprestimos.model;

import com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos.EmprestimoGarantia;
import com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos.EmprestimoPessoal;
import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;
import com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos.EmprestimoConsignado;
import com.emprestimos_api.emprestimos.service.GerenciadorDeModalidadeDeEmprestimoParaCliente;
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

        List<IEmprestimo> emprestimosLista = List.of(new EmprestimoPessoal("Emprestimo Pessoal", 4), new EmprestimoConsignado("Emprestimo Consignado", 2), new EmprestimoGarantia("Emprestimo Garantia", 3));
        GerenciadorDeModalidadeDeEmprestimoParaCliente gerenciadorDeModalidadeDeEmprestimo = new GerenciadorDeModalidadeDeEmprestimoParaCliente(emprestimosLista);
        this.produtosEmprestimo = gerenciadorDeModalidadeDeEmprestimo.validaDeClienteAcessoParaEmprestimo(cliente);

    }
}
