package br.com.pahtoo.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the aeroporto database table.
 * 
 */
@Entity
@Table(name="aeroporto")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Aeroporto implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="aeroporto_id")
	private int aeroportoId;

	@Column(name="aeroporto_descricao")
	private String aeroportoDescricao;

	@Column(name="aeroporto_iata")
	private String aeroportoIata;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="aeroporto_cidade_id")
	private Cidade cidade;

	//bi-directional many-to-one association to Voo
	@OneToMany(mappedBy="aeroporto1")
	private List<Voo> origem;

	//bi-directional many-to-one association to Voo
	@OneToMany(mappedBy="aeroporto2")
	private List<Voo> destino;
}