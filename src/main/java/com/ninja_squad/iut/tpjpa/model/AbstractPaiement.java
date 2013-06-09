package com.ninja_squad.iut.tpjpa.model;

import java.math.BigDecimal;

import javax.persistence.DiscriminatorColumn;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Inheritance;
import javax.persistence.InheritanceType;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

@Entity
@Table(name = "PAIEMENT")
@Inheritance(strategy = InheritanceType.SINGLE_TABLE)
@DiscriminatorColumn(name = "TYPE_PAIEMENT")
public class AbstractPaiement {
	
	@Id
	@SequenceGenerator(name = "paiementGenerator", sequenceName = "PAIEMENT_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "paiementGenerator")
	private Long id;
	private BigDecimal somme;
	
	public Long getId() {
		return id;
	}
	
	public void setId(Long id) {
		this.id = id;
	}
	
	public BigDecimal getSomme() {
		return somme;
	}
	
	public void setSomme(BigDecimal somme) {
		this.somme = somme;
	}
}
