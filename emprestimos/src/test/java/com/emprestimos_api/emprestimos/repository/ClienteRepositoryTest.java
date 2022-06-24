package com.emprestimos_api.emprestimos.repository;

import com.emprestimos_api.emprestimos.model.Cliente;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.test.context.junit4.SpringRunner;

import java.util.Optional;

@RunWith(SpringRunner.class)
@DataJpaTest
public class ClienteRepositoryTest {

    @Autowired
    private ClienteRepository clienteRepository;

    @Test
    public void deveriaCarregarUmClienteAoBuscarPeloId() {
        long id = 1;
        Assert.assertNotNull(clienteRepository.findById(id));

    }
}

