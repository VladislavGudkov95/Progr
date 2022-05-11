package com.company.service;

import com.company.dao.Dao;
import com.company.model.Agent;

import java.util.List;

public class DaoTest implements Dao<Agent>  {
    @Override
    public Agent findById(Integer id) {
        return null;
    }

    @Override
    public List<Agent> findAll() {
        return null;
    }

    @Override
    public void save(Agent agent) {

    }

    @Override
    public void update(Agent agent) {

    }

    @Override
    public void delete(Agent agent) {

    }
}
