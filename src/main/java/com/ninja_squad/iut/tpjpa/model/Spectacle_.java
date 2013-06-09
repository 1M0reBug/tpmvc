package com.ninja_squad.iut.tpjpa.model;

import javax.annotation.Generated;
import javax.persistence.metamodel.SetAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-02-05T07:59:31.606+0100")
@StaticMetamodel(Spectacle.class)
public class Spectacle_ {
	public static volatile SingularAttribute<Spectacle, Long> id;
	public static volatile SingularAttribute<Spectacle, String> titre;
	public static volatile SingularAttribute<Spectacle, String> artiste;
	public static volatile SingularAttribute<Spectacle, TypeDeSpectacle> type;
	public static volatile SetAttribute<Spectacle, Representation> representations;
	public static volatile SingularAttribute<Spectacle, Long> version;
}
