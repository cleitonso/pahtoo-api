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
 * The persistent class for the cidade database table.
 * 
 */
@Entity
@Table(name="cidade")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Cidade implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="cidade_id")
	private int cidadeId;

	@Column(name="cidade_nome")
	private String cidadeNome;

	//bi-directional many-to-one association to Aeroporto
	@OneToMany(mappedBy="cidade")
	private List<Aeroporto> aeroportos;

	//bi-directional many-to-one association to Uf
	@ManyToOne
	@JoinColumn(name="uf_id")
	private Uf uf;
}