package com.company;

import com.company.dao.Dao;
import com.company.model.Agent;
import com.company.service.AgentService;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import java.util.List;

public class Test {
    public static void main(String[] args) {
        SessionFactory factory = new Configuration().configure().buildSessionFactory();
        Dao<Agent> agentDao = new AgentService(factory);

        List<Agent> agents = agentDao.findAll();

        for(Agent agent : agents){
            System.out.println(agent);
        }
    }
}
