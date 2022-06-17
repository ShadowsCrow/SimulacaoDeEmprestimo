package com.emprestimos_api.emprestimos.service;

import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;
import com.emprestimos_api.emprestimos.model.Cliente;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;
@Data
public class GerenciadorDeModalidadeDeEmprestimoParaClienteService {
    private List<IEmprestimo> modalidades_de_emprestimos;
    private List<IEmprestimo> emprestimos_aceitos;

    public GerenciadorDeModalidadeDeEmprestimoParaClienteService(List<IEmprestimo> modalidades_de_emprestimos) {
        this.modalidades_de_emprestimos = modalidades_de_emprestimos;
        this.emprestimos_aceitos = new ArrayList<>();
    }

    public List<IEmprestimo> validaSeClienteTemAcessoAoEmprestimo(Cliente cliente) {
        for (IEmprestimo emprestimo : modalidades_de_emprestimos) {
            if (emprestimo.validaAcessoParaEmprestimoParaCliente(cliente)) {
                emprestimos_aceitos.add(emprestimo);
            }
        }
        return emprestimos_aceitos;
    }
}
