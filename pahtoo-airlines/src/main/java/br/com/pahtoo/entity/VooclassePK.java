package br.com.pahtoo.entity;

import java.io.Serializable;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * The primary key class for the vooclasse database table.
 * 
 */
@Embeddable
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class VooclassePK implements Serializable {
	//default serial version id, required for serializable classes.
	private static final long serialVersionUID = 1L;

	@Column(name="vooclasse_voo_id", insertable=false, updatable=false)
	private int vooclasseVooId;

	@Column(name="vooclasse_classe_id", insertable=false, updatable=false)
	private int vooclasseClasseId;

}