package com.guialvesdev.springfoodapi.domain.exception;

public class CozinhaNaoEncontradaException extends EntidadeNaoEncontradaException{

    private static final long serialVersionUID = 1L;

    public CozinhaNaoEncontradaException(String mensagem){
        super(mensagem);
    }

    public CozinhaNaoEncontradaException(long cozinhaId){
        this(String.format("Nao existe um cadastro de cozinhja com codigo %d", cozinhaId));

    }
}
