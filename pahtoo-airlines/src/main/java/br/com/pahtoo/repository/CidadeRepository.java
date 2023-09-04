package br.com.pahtoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pahtoo.entity.Cidade;

@Repository
public interface CidadeRepository extends JpaRepository<Cidade, Integer> {

}
