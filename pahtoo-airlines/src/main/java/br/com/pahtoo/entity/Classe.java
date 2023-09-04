package br.com.pahtoo.entity;

import java.io.Serializable;
import java.util.List;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.OneToMany;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


/**
 * The persistent class for the classe database table.
 * 
 */
@Entity
@Table(name="classe")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Classe implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="classe_id")
	private int classeId;

	@Column(name="classe_nome")
	private String classeNome;

	//bi-directional many-to-one association to Vooclasse
	@OneToMany(mappedBy="classe")
	private List<Vooclasse> vooclasses;
}