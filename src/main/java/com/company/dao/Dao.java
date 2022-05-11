package com.company.dao;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

public interface Dao<Entity> {
    Entity findById(Integer id);
    List<Entity> findAll();
    void save(Entity entity);
    void update(Entity entity);
    void delete(Entity entity);

}
