package com.guialvesdev.springfoodapi.exceptionhandler;

import lombok.Getter;

@Getter
public enum ProblemType {

    ERRO_SISTEMA("/erro-de-sistema", "Erro de sistema"),
    PARAMETRO_INVALIDO("/parametro-invalido", "Parametro invalido"),
    MENSAGEM_INCOMPREENSIVEL("/mensagem-incompreensivel", "Mensagem incompreensivel"),
    RECURSO_NAO_ENCONTRADO("/recurso-nao-encontrado", "Recurso nao encontrado"),
    ENTIDADE_EM_USO("/entidade-em-uso", "Entidade em uso"),
    ERRO_NEGOCIO("/erro-negocio", "Violacao de regra de negocio");

    private String title;
    private String uri;

    ProblemType(String path, String title){
        this.uri = "htttp://apifood.com.br" + path;
        this.title;
    }



}
