package com.ninja_squad.iut.tpjpa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-05T08:23:30.105+0100")
@StaticMetamodel(PaiementParCheque.class)
public class PaiementParCheque_ extends AbstractPaiement_ {
	public static volatile SingularAttribute<PaiementParCheque, String> numeroCheque;
	public static volatile SingularAttribute<PaiementParCheque, String> emetteur;
}
