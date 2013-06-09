package com.ninja_squad.iut.tpjpa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-05T18:04:39.497+0100")
@StaticMetamodel(Ticket.class)
public class Ticket_ {
	public static volatile SingularAttribute<Ticket, Long> id;
	public static volatile SingularAttribute<Ticket, String> numero;
	public static volatile SingularAttribute<Ticket, Representation> representation;
	public static volatile SetAttribute<Ticket, AbstractPaiement> paiements;
}
