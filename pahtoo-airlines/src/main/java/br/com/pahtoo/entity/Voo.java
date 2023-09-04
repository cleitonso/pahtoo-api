package br.com.pahtoo.entity;

import java.io.Serializable;
import java.util.Date;
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
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the voo database table.
 * 
 */
@Entity
@Table(name="voo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Voo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="voo_id")
	private int vooId;

	@Temporal(TemporalType.TIMESTAMP)
	@Column(name="voo_datahora")
	private Date vooDatahora;

	@Column(name="voo_totalassentos")
	private int vooTotalassentos;

	//bi-directional many-to-one association to Aeroporto
	@ManyToOne
	@JoinColumn(name="voo_destino")
	private Aeroporto aeroporto1;

	//bi-directional many-to-one association to Aeroporto
	@ManyToOne
	@JoinColumn(name="voo_origem")
	private Aeroporto aeroporto2;

	//bi-directional many-to-one association to Vooclasse
	@OneToMany(mappedBy="voo")
	private List<Vooclasse> vooclasses;

	//bi-directional many-to-one association to Statusvoo
	@ManyToOne
	@JoinColumn(name="voo_statusvoo_id")
	private Statusvoo statusvoo;
}