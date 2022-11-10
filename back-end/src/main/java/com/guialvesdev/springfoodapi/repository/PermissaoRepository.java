package com.guialvesdev.springfoodapi.repository;


import com.guialvesdev.springfoodapi.domain.model.Permissao;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PermissaoRepository extends JpaRepository<Permissao, Long> {
}
