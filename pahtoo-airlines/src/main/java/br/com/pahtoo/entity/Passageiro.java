package br.com.pahtoo.entity;

import java.io.Serializable;
import java.util.Date;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the passageiro database table.
 * 
 */
@Entity
@Table(name="passageiro")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Passageiro implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="passageiro_id")
	private int passageiroId;

	@Column(name="passageiro_documento")
	private String passageiroDocumento;

	@Temporal(TemporalType.DATE)
	@Column(name="passageiro_dtnasc")
	private Date passageiroDtnasc;

	@Column(name="passageiro_email")
	private String passageiroEmail;

	@Column(name="passageiro_nome")
	private String passageiroNome;

	@Column(name="passageiro_telefone")
	private String passageiroTelefone;
}