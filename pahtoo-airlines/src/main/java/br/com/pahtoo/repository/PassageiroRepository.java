package br.com.pahtoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pahtoo.entity.Passageiro;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Integer> {

}
