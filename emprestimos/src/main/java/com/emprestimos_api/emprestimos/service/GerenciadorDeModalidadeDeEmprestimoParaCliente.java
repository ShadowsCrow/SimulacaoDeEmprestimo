package com.emprestimos_api.emprestimos.service;

import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;
import com.emprestimos_api.emprestimos.model.Cliente;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class GerenciadorDeModalidadeDeEmprestimoParaCliente {
    private List<IEmprestimo> modalidadesDeEmprestimos;
    private List<IEmprestimo> emprestimosAceitos;

    public GerenciadorDeModalidadeDeEmprestimoParaCliente(List<IEmprestimo> modalidadesDeEmprestimos) {
        this.modalidadesDeEmprestimos = modalidadesDeEmprestimos;
        this.emprestimosAceitos = new ArrayList<>();
    }

    public List<IEmprestimo> validaDeClienteAcessoParaEmprestimo(Cliente cliente) {
        for (IEmprestimo emprestimo : modalidadesDeEmprestimos) {
            if (emprestimo.validaAcessoParaEmprestimoParaCliente(cliente)) {
                emprestimosAceitos.add(emprestimo);
            }
        }
        return emprestimosAceitos;
    }
}
