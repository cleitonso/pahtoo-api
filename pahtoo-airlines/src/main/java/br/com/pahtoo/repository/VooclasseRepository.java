package br.com.pahtoo.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import br.com.pahtoo.entity.Vooclasse;
import br.com.pahtoo.entity.VooclassePK;

@Repository
public interface VooclasseRepository extends JpaRepository<Vooclasse, VooclassePK> {

}
