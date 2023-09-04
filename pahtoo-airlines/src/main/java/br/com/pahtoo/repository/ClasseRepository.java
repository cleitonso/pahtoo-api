package br.com.pahtoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pahtoo.entity.Classe;

@Repository
public interface ClasseRepository extends JpaRepository<Classe, Integer> {

}
