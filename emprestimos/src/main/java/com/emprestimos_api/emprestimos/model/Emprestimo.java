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

    @Override
    public boolean equals(Object obj) {
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Emprestimo other = (Emprestimo) obj;

        return this.tipo_emprestimo.equals(other.tipo_emprestimo);
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 97 * hash + (this.tipo_emprestimo != null ? this.tipo_emprestimo.hashCode() : 0);
        return hash;
    }

}


