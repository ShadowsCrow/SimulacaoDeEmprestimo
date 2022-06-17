package com.emprestimos_api.emprestimos.repository;

import com.emprestimos_api.emprestimos.model.Cliente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.List;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository repository;

    @Autowired
    TestEntityManager em;

    @Test
    public void deveriaCarregarUmClienteAoBuscarPeloCpf() {
        String cpf = "987.654.321-00";

        Cliente clienteTestCpf = new Cliente();
        clienteTestCpf.setCpf(cpf);
        clienteTestCpf.setName("Cliente Teste");
        clienteTestCpf.setAge(20);
        clienteTestCpf.setUf("SP");
        clienteTestCpf.setRendaMensal(1000.00f);

        em.persist(clienteTestCpf);

        List<Cliente> cliente = repository.findByCpf(cpf);
        Assert.assertNotNull(cliente);
        String clienteCpf = cliente.get(0).getCpf();
        Assert.assertEquals(cpf, clienteCpf);
    }

    @Test
    public void naoDeveriaCarregarUmClienteCujoOCpfNaoExiste() {
        String cpf = "000.054.321-00";

        List<Cliente> cliente = repository.findByCpf(cpf);
        Assert.assertTrue(cliente.isEmpty());
    }
}
