package com.emprestimos_api.emprestimos.repository;

import com.emprestimos_api.emprestimos.model.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ClienteRepository extends JpaRepository<Cliente, Long> {

    List<Cliente> findByCpf(String cpf);


}

