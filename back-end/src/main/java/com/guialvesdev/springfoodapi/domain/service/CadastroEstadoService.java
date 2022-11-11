package com.guialvesdev.springfoodapi.domain.service;

import com.guialvesdev.springfoodapi.domain.exception.EntidadeEmUsoException;
import com.guialvesdev.springfoodapi.domain.exception.EstadoNaoEncontradoException;
import com.guialvesdev.springfoodapi.domain.model.Estado;
import com.guialvesdev.springfoodapi.repository.EstadoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    private static final String MSG_ESTADO_EM_USO = "estado de codigo %d nao pode ser removido, pois esta em uso";



    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){
        return estadoRepository.save(estado);

    }

    public void excluir(Long estadoId){
        try {
            estadoRepository.deleteById(estadoId);

        } catch (EmptyResultDataAccessException e) {
            throw new EstadoNaoEncontradoException(estadoId);

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ESTADO_EM_USO, estadoId));
        }
    }

    public Estado buscarOuFalhar(Long estadoId) {
        return estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EstadoNaoEncontradoException(estadoId));
    }



}
