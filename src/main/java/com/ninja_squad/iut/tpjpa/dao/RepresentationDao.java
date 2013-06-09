package com.ninja_squad.iut.tpjpa.dao;

import java.util.List;

import com.ninja_squad.iut.tpjpa.model.Representation;
import com.ninja_squad.iut.tpjpa.model.RepresentationSearchCriteria;

public interface RepresentationDao {

    List<Representation> findByCriteria(RepresentationSearchCriteria criteria);

    List<Representation> findByCriteriaUsingJPQL(RepresentationSearchCriteria criteria);

}