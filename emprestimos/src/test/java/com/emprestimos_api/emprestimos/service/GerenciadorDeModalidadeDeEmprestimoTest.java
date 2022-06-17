package com.emprestimos_api.emprestimos.service;

import com.emprestimos_api.emprestimos.interfaces.IEmprestimo;
import com.emprestimos_api.emprestimos.model.Cliente;
import com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos.EmprestimoConsignado;
import com.emprestimos_api.emprestimos.model.modalidadesDeEmprestimos.EmprestimoGarantia;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;

@RunWith(SpringRunner.class)
public class GerenciadorDeModalidadeDeEmprestimoTest {

    @Test
    public void verificaSeOEmprestimoRetornadoNaListaDeEmprestimosEhIgualAoObjetoEmprestimoGarantiaESeOTamanhoDaListaEhIgualAUm() {

        List<IEmprestimo> emprestimosLista = List.of(new EmprestimoConsignado("Emprestimo Consignado", 2), new EmprestimoGarantia("Emprestimo Garantia", 3));
        GerenciadorDeModalidadeDeEmprestimoParaClienteService gerenciador = new GerenciadorDeModalidadeDeEmprestimoParaClienteService(emprestimosLista);
        Cliente cliente = new Cliente();

        cliente.setName("Cliente Teste");
        cliente.setCpf("123456789");
        cliente.setAge(20);
        cliente.setUf("SP");
        cliente.setRendaMensal(3000);

        List<IEmprestimo> Emprestimo = gerenciador.validaSeClienteTemAcessoAoEmprestimo(cliente);
        EmprestimoGarantia resultadoEsperadoEmprestimoGarantia = new EmprestimoGarantia("Emprestimo Garantia", 3);

        assertEquals(1, Emprestimo.size());
        assertEquals(Emprestimo.get(0), resultadoEsperadoEmprestimoGarantia);

    }

}
