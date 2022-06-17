package com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos;

import com.emprestimos_api.emprestimos.model.Cliente;
import com.emprestimos_api.emprestimos.model.Emprestimo;
import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;

public class EmprestimoPessoal extends Emprestimo implements IEmprestimo {


    public EmprestimoPessoal(String tipo_emprestimo, int taxa) {
        super(tipo_emprestimo, taxa);
    }

    @Override
    public boolean validaAcessoParaEmprestimoParaCliente(Cliente cliente) {
        if (cliente.getRendaMensal() >= 0) {
            return true;
        }

        return false;
    }
}
