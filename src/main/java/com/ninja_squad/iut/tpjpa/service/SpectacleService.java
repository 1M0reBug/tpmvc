package com.ninja_squad.iut.tpjpa.service;

import java.util.List;

import com.ninja_squad.iut.tpjpa.model.Spectacle;

public interface SpectacleService {

    List<Spectacle> findAll();

    Spectacle findById(Long id);

    Spectacle createSpectacle(Spectacle spectacle);
}