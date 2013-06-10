package com.ninja_squad.iut.tpjpa.model;

import org.codehaus.jackson.annotate.JsonIgnore;

import javax.persistence.*;
import java.util.Collections;
import java.util.HashSet;
import java.util.Set;

/**
 * Entity implementation class for Entity: Spectacle
 */
@Entity
public class Spectacle {

	@Id
	@SequenceGenerator(name = "spectacle_generator", sequenceName = "SPECTACLE_SEQ", allocationSize = 1)
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "spectacle_generator")
	private Long id;

	private String titre;

	private String artiste;

	@Enumerated(EnumType.STRING)
	private TypeDeSpectacle type;

	@OneToMany(mappedBy = "spectacle")
    @JsonIgnore
	private Set<Representation> representations = new HashSet<Representation>(0);

	@Version
	private long version = 0;

	public Spectacle() {
	}

	public Spectacle(String titre, String artiste, TypeDeSpectacle type) {
		this.titre = titre;
		this.artiste = artiste;
		this.type = type;
	}

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getTitre() {
		return titre;
	}

	public void setTitre(String titre) {
		this.titre = titre;
	}

	public String getArtiste() {
		return artiste;
	}

	public void setArtiste(String artiste) {
		this.artiste = artiste;
	}

	public TypeDeSpectacle getType() {
		return type;
	}

	public void setType(TypeDeSpectacle type) {
		this.type = type;
	}

	public Set<Representation> getRepresentations() {
		return Collections.unmodifiableSet(representations);
	}

	public void addRepresentation(Representation representation) {
		representation.setSpectacle(this);
		representations.add(representation);
	}

	public long getVersion() {
		return version;
	}
}
