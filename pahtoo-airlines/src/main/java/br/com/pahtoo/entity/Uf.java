package br.com.pahtoo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the uf database table.
 * 
 */
@Entity
@Table(name="uf")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Uf implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="uf_id")
	private int ufId;

	@Column(name="uf_nome")
	private String ufNome;

	@Column(name="uf_sigla")
	private String ufSigla;
}