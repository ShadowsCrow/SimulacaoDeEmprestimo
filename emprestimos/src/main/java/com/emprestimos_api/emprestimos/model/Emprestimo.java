package com.emprestimos_api.emprestimos.model;

import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;
import lombok.Data;

@Data
public abstract class Emprestimo implements IEmprestimo {
    private String tipo_emprestimo;
    private int taxa;

    public Emprestimo(String tipo_emprestimo, int taxa) {
        this.tipo_emprestimo = tipo_emprestimo;
        this.taxa = taxa;
    }

}


