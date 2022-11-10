package com.guialvesdev.springfoodapi.domain.service;

import com.guialvesdev.springfoodapi.domain.exception.EntidadeNaoEncontradaException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

@Service
public class CadastroEstadoService {

    private static final String MSG_ESTADO_EM_USO = "estado de codigo %d nao pode ser removido, pois esta em uso";

    private static final String MSG_ESTADO_NAO_ENCONTRADO = "nao existe um cadastro de estado com o codigo %d";


    @Autowired
    private EstadoRepository estadoRepository;

    public Estado salvar(Estado estado){
        return estadoRepository.save(estado);

    }

    public void excluir(Long estadoId){
        try {
            estadoRepository.deleteById(estadoId);

        } catch (EmptyResultDataAccessException e) {
            throw new EntidadeNaoEncontradaException(
                    String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId));

        } catch (DataIntegrityViolationException e) {
            throw new EntidadeEmUsoException(
                    String.format(MSG_ESTADO_EM_USO, estadoId));
        }
    }

    public Estado buscarOuFalhar(Long estadoId) {
        return estadoRepository.findById(estadoId)
                .orElseThrow(() -> new EntidadeNaoEncontradaException(
                        String.format(MSG_ESTADO_NAO_ENCONTRADO, estadoId)));
    }














}
