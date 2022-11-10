package com.guialvesdev.springfoodapi.domain.service;

import com.guialvesdev.springfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.guialvesdev.springfoodapi.domain.model.Cozinha;
import com.guialvesdev.springfoodapi.domain.model.Restaurante;
import com.guialvesdev.springfoodapi.repository.CozinhaRepository;
import com.guialvesdev.springfoodapi.repository.RestauranteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class CadastroRestauranteService {
    private static final String MSG_RESTAURANTE_NAO_ENCONTRADO = "restaurante nao localizado";
    private static final String MSG_COZINHA_NAO_EXISTE = "Não existe cadastro de cozinha com código %d";

    @Autowired
    private RestauranteRepository restauranteRepository;

    @Autowired
    private CadastroCozinhaService cadastroCozinhaService;


    public Restaurante salvar(Restaurante restaurante) {
        Long cozinhaId = restaurante.getCozinha().getId();

        Cozinha cozinha = cadastroCozinhaService.buscarOuFalhar().orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_COZINHA_NAO_EXISTE, cozinhaId)));

        restaurante.setCozinha(cozinha);

        return restauranteRepository.save(restaurante);
    }


    public Restaurante buscarOuFalhar(Long restauranteId){
        return restauranteRepository.findById(restauranteId).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_RESTAURANTE_NAO_ENCONTRADO, restauranteId)));
    }





}
