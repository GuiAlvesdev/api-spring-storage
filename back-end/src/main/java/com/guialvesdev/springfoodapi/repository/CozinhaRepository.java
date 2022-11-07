package com.guialvesdev.springfoodapi.repository;

import com.guialvesdev.springfoodapi.domain.model.Cozinha;

import java.util.List;

public class CozinhaRepository {

    List<Cozinha> listar();
    Cozinha buscar(Long id);
    Cozinha salvar(Cozinha cozinha);
    void remover(Long id);














}
