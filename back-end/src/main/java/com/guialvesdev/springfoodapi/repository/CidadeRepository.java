package com.guialvesdev.springfoodapi.repository;

import com.guialvesdev.springfoodapi.domain.model.Cidade;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Long> {

}
