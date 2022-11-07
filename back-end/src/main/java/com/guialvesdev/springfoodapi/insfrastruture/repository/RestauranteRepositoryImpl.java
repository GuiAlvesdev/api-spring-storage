package com.guialvesdev.springfoodapi.insfrastruture.repository;

import com.guialvesdev.springfoodapi.domain.model.Restaurante;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements  RestauranteRepositoryQueries{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> find(String nome,
             BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){

        var jpql = new StringBuilder();
        jpql.append("from Restaurante where 0 = 0 ");

        if (StringUtils.hasLength(nome)){
            jpql.append("where nome like :nome ");
        }

        if(taxaFreteInicial != null){
            jpql.append("and taxaFrete >= :taxaInicial ");
        }

        if(taxaFreteInicial != null){
            jpql.append("and taxaFrete <= :taxaFinal ");
        }


        return manager .createQuery(jpql.toString(), Restaurante.class)
                .setParameter("nome", "%" + "%")
                .setParameter("taxaInicial", taxaFreteInicial)
                .setParameter("taxaFinal", taxaFreteFinal)
                .getResultList();




    }





}
