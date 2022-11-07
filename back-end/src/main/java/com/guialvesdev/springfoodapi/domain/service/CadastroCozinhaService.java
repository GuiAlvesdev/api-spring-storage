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

        @Autowired
        private CozinhaRepository cozinhaRepository;

        public Cozinha salvar(Cozinha cozinha){
            return cozinhaRepository.salvar(cozinha);
        }

        public void excluir(Long cozinhaId){
            try {
                cozinhaRepository.remover(cozinhaId);
            }catch (EmptyResultDataAccessException e){
                throw new EntidadeNaoEncontradaException(String.format("Nao existe um cadastro de cozinha com codigo %d", cozinhaId));


            }catch (DataIntegrityViolationException e){
                throw new EntidadeEmUsoException(String.format("Cozinha de codigo %d nao pode ser removida, esta em uso", cozinhaId));
            }

        }


}
