package com.guialvesdev.springfoodapi.domain.service;

import com.guialvesdev.springfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.guialvesdev.springfoodapi.domain.model.Cozinha;
import com.guialvesdev.springfoodapi.domain.model.Restaurante;
import com.guialvesdev.springfoodapi.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CadastroRestauranteService {

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CozinhaRepository cozinhaRepository;


    public Restaurante salvar(Restaurante restaurante){
        Long cozinhaId = restaurante.getCozinha().getId;
        Cozinha cozinha = cozinhaRepository.buscar(cozinhaId);

        if(cozinha == null){
            throw new EntidadeNaoEncontradaException(
                String.format("Nao existe cadastro de cozinha com codigo %d", cozinhaId));

            }
        restaurante.seCozinha(cozinha);
        return restauranteRepository.salvar(restaurante);

        }


    }




}
