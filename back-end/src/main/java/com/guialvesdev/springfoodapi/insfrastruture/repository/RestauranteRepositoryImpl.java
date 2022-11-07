package com.guialvesdev.springfoodapi.insfrastruture.repository;

import com.guialvesdev.springfoodapi.domain.model.Restaurante;
import org.hibernate.criterion.CriteriaQuery;
import org.springframework.stereotype.Repository;
import org.springframework.util.StringUtils;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.persistence.criteria.CriteriaBuilder;
import java.math.BigDecimal;
import java.util.List;

@Repository
public class RestauranteRepositoryImpl implements  RestauranteRepositoryQueries{

    @PersistenceContext
    private EntityManager manager;

    @Override
    public List<Restaurante> find(String nome,
             BigDecimal taxaFreteInicial, BigDecimal taxaFreteFinal){
        CriteriaBuilder builder = manager.getCriteriaBuilder();

        CriteriaQuery<Restaurante> criteria = builder.createQuery(Restaurante.class);
        criteria.from(Restaurante.class);

        TypedQuery<Restaurante> query = manager.createQuery(criteria);
        return query.getResultList();



    }





}
