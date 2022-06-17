package com.emprestimos_api.emprestimos.interfaces;

import com.emprestimos_api.emprestimos.model.Cliente;

public interface IEmprestimo {

    public boolean validaAcessoParaEmprestimoParaCliente(Cliente cliente);

}
