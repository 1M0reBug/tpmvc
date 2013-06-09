package com.ninja_squad.iut.tpjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;

import com.ninja_squad.iut.tpjpa.model.Spectacle;

@Repository
public class SpectacleDaoImpl implements SpectacleDao {

    @PersistenceContext
    private EntityManager em;

	protected SpectacleDaoImpl() {
    }

	public SpectacleDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
    public List<Spectacle> findAll() {
		String jpql = "select spectacle from Spectacle spectacle order by spectacle.titre";
		return em.createQuery(jpql, Spectacle.class).getResultList();
	}

	@Override
    public void persist(Spectacle spectacle) {
		em.persist(spectacle);
	}

	@Override
    public Spectacle findById(Long id) {
		return em.find(Spectacle.class, id);
	}

	@Override
    public List<Spectacle> findByArtiste(String artiste) {
		String jpql =
			"select spectacle from Spectacle spectacle"
			+ " where lower(spectacle.artiste) like :artiste"
			+ " order by spectacle.titre";
		return em.createQuery(jpql, Spectacle.class)
				 .setParameter("artiste", "%" + artiste.toLowerCase() + "%")
				 .getResultList();
	}
}
