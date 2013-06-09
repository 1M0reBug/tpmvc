package com.ninja_squad.iut.tpjpa.model;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="Dali", date="2013-01-04T16:54:52.264+0100")
@StaticMetamodel(Representation.class)
public class Representation_ {
	public static volatile SingularAttribute<Representation, Long> id;
	public static volatile SingularAttribute<Representation, Date> date;
	public static volatile SingularAttribute<Representation, Spectacle> spectacle;
}
