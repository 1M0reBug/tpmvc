package com.ninja_squad.iut.tpjpa.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ninja_squad.iut.tpjpa.dao.SpectacleDao;
import com.ninja_squad.iut.tpjpa.model.Spectacle;

@Service
@Transactional
public class SpectacleServiceImpl implements SpectacleService {

    private SpectacleDao spectacleDao;

    @Autowired
    public SpectacleServiceImpl(SpectacleDao spectacleDao) {
        this.spectacleDao = spectacleDao;
    }

    @Override
    public List<Spectacle> findAll() {
        return spectacleDao.findAll();
    }

    @Override
    public Spectacle findById(Long id) {
        return spectacleDao.findById(id);
    }

    @Override
    public Spectacle createSpectacle(Spectacle spectacle) {
        spectacleDao.persist(spectacle);
        return spectacle;
    }
}
