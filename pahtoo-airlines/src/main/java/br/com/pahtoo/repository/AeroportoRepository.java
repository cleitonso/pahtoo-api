package br.com.pahtoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pahtoo.entity.Aeroporto;

@Repository
public interface AeroportoRepository extends JpaRepository<Aeroporto, Integer> {

}
