package br.com.pahtoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pahtoo.entity.Voo;

@Repository
public interface VooRepository extends JpaRepository<Voo, Integer> {

}
