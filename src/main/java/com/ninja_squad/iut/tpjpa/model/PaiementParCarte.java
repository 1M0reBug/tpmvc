package com.ninja_squad.iut.tpjpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CARTE")
public class PaiementParCarte extends AbstractPaiement {
	@Column(name = "NUMERO_CARTE")
	private String numeroCarte;

	public String getNumeroCarte() {
		return numeroCarte;
	}

	public void setNumeroCarte(String numeroCarte) {
		this.numeroCarte = numeroCarte;
	}
}
