package com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos;

import com.emprestimos_api.emprestimos.model.Cliente;
import com.emprestimos_api.emprestimos.model.Emprestimo;
import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;

import static com.sun.xml.bind.v2.schemagen.Util.equalsIgnoreCase;

public class EmprestimoGarantia extends Emprestimo implements IEmprestimo  {
    public EmprestimoGarantia(String tipo_emprestimo, int taxa) {
        super(tipo_emprestimo, taxa);
    }

    @Override
    public boolean validaAcessoParaEmprestimoParaCliente(Cliente cliente) {
        if (cliente.getRendaMensal() >= 0) {
            if (cliente.getAge() < 30) {
                return true;
            }
            if (equalsIgnoreCase(cliente.getUf(), "SP")) {
                return true;
            }
        }
        return false;
    }
}
