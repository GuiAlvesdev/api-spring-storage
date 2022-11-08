package com.guialvesdev.springfoodapi.domain.model;



import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Data;
import lombok.EqualsAndHashCode;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Data
@EqualsAndHashCode(onlyExplicitlyIncluded = true)
@Entity
public class Restaurante {

    @EqualsAndHashCode.Include   //GERA HASHCODE DO ID
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    @Column(name = "taxa_frete", nullable = false)
    private BigDecimal taxaFrete;




    @ManyToOne
    @JoinColumn(name = "cozinha_id", nullable = false)
    private Cozinha cozinha;

    @JsonIgnore
    @Embedded   //INCORPORA O ENDERECO
    private Endereco endereco;


    @CreationTimestamp         //hibernate atribui uma data hora aut
    @Column(nullable = false)  //nao pode ser nulo
    private LocalDateTime dataCadastro;


    @UpdateTimestamp            //hibernate atribui uma data hora aut
    @Column(nullable = false)  //nao pode ser nulo
    private LocalDateTime dataAtualizacao;




    @ManyToMany
    @JsonIgnore
    @JoinTable(name = "restaurante_forma_pagamento", joinColumns = @JoinColumn(name = "restaurante_id"), inverseJoinColumns = @JoinColumn(name = "forma_pagamento_id"))
    private List<FormaPagamento> formasPagamento = new ArrayList<>();




}
