package com.ninja_squad.iut.tpjpa.model;

import javax.persistence.Column;
import javax.persistence.DiscriminatorValue;
import javax.persistence.Entity;

@Entity
@DiscriminatorValue("CHEQUE")
public class PaiementParCheque extends AbstractPaiement {

	@Column(name = "NUMERO_CHEQUE")
	private String numeroCheque;
	
	private String emetteur;
	
	public String getNumeroCheque() {
		return numeroCheque;
	}
	
	public void setNumeroCheque(String numeroCheque) {
		this.numeroCheque = numeroCheque;
	}
	
	public String getEmetteur() {
		return emetteur;
	}
	
	public void setEmetteur(String emetteur) {
		this.emetteur = emetteur;
	}
}
