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
 * The persistent class for the statusvoo database table.
 * 
 */
@Entity
@Table(name="statusvoo")
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Statusvoo implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name="statusvoo_id")
	private int statusvooId;

	@Column(name="statusvoo_descricao")
	private String statusvooDescricao;

}