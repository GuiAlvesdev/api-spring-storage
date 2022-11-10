package com.guialvesdev.springfoodapi.domain.service;

import com.guialvesdev.springfoodapi.domain.exception.EntidadeEmUsoException;
import com.guialvesdev.springfoodapi.domain.exception.EntidadeNaoEncontradaException;
import com.guialvesdev.springfoodapi.domain.model.Cozinha;
import com.guialvesdev.springfoodapi.repository.CozinhaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroCozinhaService {
    private static final String MSG_COZINHA_NAO_ENCONTRADA = "Não existe um cadastro de cozinha com código %d";
    private static final String MSG_COZINHA_EM_USO = "Nao existe um cadastro de cozinha com o codigo %d";

    @Autowired
    private CozinhaRepository cozinhaRepository;

    public Cozinha salvar(Cozinha cozinha) {
        return cozinhaRepository.save(cozinha);
    }

    public void excluir(Long cozinhaId) {
        try {
            cozinhaRepository.deleteById(cozinhaId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_COZINHA_NAO_ENCONTRADA, cozinhaId));
        }
    }


    public Cozinha buscarOuFalhar(Long cozinhaId){
        return cozinhaRepository.findById(cozinhaId).orElseThrow(() -> new EntidadeNaoEncontradaException(String.format(MSG_COZINHA_EM_USO, cozinhaId)));
    }


}
