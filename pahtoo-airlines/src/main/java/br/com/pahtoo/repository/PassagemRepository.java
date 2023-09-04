package br.com.pahtoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pahtoo.entity.Passagem;

@Repository
public interface PassagemRepository extends JpaRepository<Passagem, Integer> {

}
