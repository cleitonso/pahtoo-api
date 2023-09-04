package br.com.pahtoo.entity;

import java.io.Serializable;
import java.math.BigDecimal;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
@Table(name="passagem")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passagem implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="passagem_id")
	private int passagemId;

	@ManyToOne
	@JoinColumn(name="passagem_vooclasse_id")
	private Vooclasse vooclasse;

	@Column(name="passagem_numeroassento")
	private String passagemNumeroassento;

	//bi-directional many-to-one association to Cidade
	@ManyToOne
	@JoinColumn(name="passagem_passageiro_id")
	private Passageiro passageiro;

	@Column(name = "passagem_valor")
	private BigDecimal passagemValor;
}