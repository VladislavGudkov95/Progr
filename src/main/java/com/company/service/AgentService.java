package com.company.service;

import com.company.dao.Dao;
import com.company.model.Agent;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class AgentService implements Dao<Agent,Integer> {

    private final SessionFactory factory;

    public AgentService(SessionFactory factory) {
        this.factory = factory;
    }


    @Override
    public Agent findById(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(Agent.class,id);
        }
    }

    @Override
    public List<Agent> findAll() {
        try(Session session = factory.openSession()){
            return session.createQuery("from Agent",Agent.class).list();
        }
    }

    @Override
    public void save(Agent agent) {
        try(Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.save(agent);
            transaction.commit();
        }
    }

    @Override
    public void update(Agent agent) {
        try(Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.update(agent);
            transaction.commit();
        }
    }

    @Override
    public void delete(Agent agent) {
        try(Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.delete(agent);
            transaction.commit();
        }
    }
}
