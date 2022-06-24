package com.emprestimos_api.emprestimos.model;

import lombok.Data;

import javax.persistence.*;
import javax.validation.constraints.NotNull;


@Data
@Entity
@Table(uniqueConstraints = {@UniqueConstraint(columnNames = {"cpf"})})
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    @NotNull
    private String name;
    @NotNull @Column
    private String cpf;
    @NotNull
    private int age;
    @NotNull
    private String uf;
    @NotNull
    private float rendaMensal;


}


