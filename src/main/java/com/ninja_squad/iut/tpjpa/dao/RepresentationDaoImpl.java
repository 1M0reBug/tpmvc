package com.ninja_squad.iut.tpjpa.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Path;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;

import org.springframework.stereotype.Repository;

import com.ninja_squad.iut.tpjpa.model.Representation;
import com.ninja_squad.iut.tpjpa.model.RepresentationSearchCriteria;
import com.ninja_squad.iut.tpjpa.model.Representation_;
import com.ninja_squad.iut.tpjpa.model.Spectacle;
import com.ninja_squad.iut.tpjpa.model.Spectacle_;

@Repository
public class RepresentationDaoImpl implements RepresentationDao {

    @PersistenceContext
    private EntityManager em;

    protected RepresentationDaoImpl() {
    }

    public RepresentationDaoImpl(EntityManager em) {
		this.em = em;
	}

	@Override
    public List<Representation> findByCriteria(RepresentationSearchCriteria criteria) {
		CriteriaBuilder cb = em.getCriteriaBuilder();
		CriteriaQuery<Representation> cq = cb.createQuery(Representation.class);
		Root<Representation> representation = cq.from(Representation.class);
		Path<Spectacle> spectacle = representation.join(Representation_.spectacle);
		Predicate dateAfter = cb.greaterThanOrEqualTo(representation.get(Representation_.date), criteria.getDateDebut());
		Predicate dateBefore = cb.lessThanOrEqualTo(representation.get(Representation_.date), criteria.getDateFin());
		Predicate likeArtiste = cb.like(cb.lower(spectacle.get(Spectacle_.artiste)), "%" + criteria.getArtiste().toLowerCase() + "%");

		cq.where(dateBefore, dateAfter, likeArtiste);
		representation.fetch(Representation_.spectacle);
		cq.select(representation).orderBy(cb.asc(representation.get(Representation_.date)));
		return em.createQuery(cq).getResultList();
	}

	@Override
    public List<Representation> findByCriteriaUsingJPQL(RepresentationSearchCriteria criteria) {
		String jpql =
			"select representation from Representation representation"
			+ " inner join fetch representation.spectacle spectacle"
			+ " where representation.date >= :dateDebut"
			+ " and representation.date <= :dateFin"
			+ " and lower(spectacle.artiste) like :artiste"
			+ " order by representation.date";
		return em.createQuery(jpql, Representation.class)
				 .setParameter("dateDebut", criteria.getDateDebut())
				 .setParameter("dateFin", criteria.getDateFin())
				 .setParameter("artiste", "%" + criteria.getArtiste().toLowerCase() + "%")
				 .getResultList();
	}
}
