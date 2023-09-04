package br.com.pahtoo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.EmbeddedId;
import jakarta.persistence.Entity;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the vooclasse database table.
 * 
 */
@Entity
@Table(name="vooclasse")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Vooclasse implements Serializable {
	private static final long serialVersionUID = 1L;

	@EmbeddedId
	private VooclassePK id;

	@Column(name="vooclasse_id")
	private int vooclasseId;

	@Column(name="vooclasse_qtassentos")
	private int vooclasseQtassentos;

	//bi-directional many-to-one association to Classe
	@ManyToOne
	@JoinColumn(name="vooclasse_classe_id")
	private Classe classe;

	//bi-directional many-to-one association to Voo
	@ManyToOne
	@JoinColumn(name="vooclasse_voo_id")
	private Voo voo;

}