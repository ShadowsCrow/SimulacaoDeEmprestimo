package com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos;

import com.emprestimos_api.emprestimos.model.Cliente;
import com.emprestimos_api.emprestimos.model.Emprestimo;

public class EmprestimoConsignado extends Emprestimo {

    public EmprestimoConsignado(String tipo_emprestimo, int taxa) {
        super(tipo_emprestimo, taxa);
    }

    @Override
    public boolean validaAcessoParaEmprestimoParaCliente(Cliente cliente) {
        if (cliente.getRendaMensal() >= 5000){
            return true;
        }
        return false;
    }
}
