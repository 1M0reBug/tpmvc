package com.ninja_squad.iut.tpjpa.dao;

import java.util.List;

import com.ninja_squad.iut.tpjpa.model.Spectacle;

public interface SpectacleDao {

    List<Spectacle> findAll();

    void persist(Spectacle spectacle);

    Spectacle findById(Long id);

    List<Spectacle> findByArtiste(String artiste);

}