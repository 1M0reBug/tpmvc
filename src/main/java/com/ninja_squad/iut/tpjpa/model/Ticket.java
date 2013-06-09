package com.ninja_squad.iut.tpjpa.model;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;
import javax.persistence.SequenceGenerator;

@Entity
public class Ticket {

	@Id
	@SequenceGenerator(name = "ticketGenerator", sequenceName = "TICKET_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticketGenerator")
	private Long id;

	private String numero;

	@ManyToOne
	@JoinColumn(name = "ID_REPRESENTATION")
	private Representation representation;

	@ManyToMany
	@JoinTable(name = "PAIEMENT_TICKET",
	           joinColumns = @JoinColumn(name = "ID_TICKET"),
	           inverseJoinColumns = @JoinColumn(name = "ID_PAIEMENT"))
	private Set<AbstractPaiement> paiements = new HashSet<AbstractPaiement>();

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public Set<AbstractPaiement> getPaiements() {
		return paiements;
	}

	public void addPaiement(AbstractPaiement paiement) {
		paiements.add(paiement);
	}

	public Representation getRepresentation() {
		return representation;
	}

	public void setRepresentation(Representation representation) {
		this.representation = representation;
	}
}
