package com.company.service;

import com.company.dao.Dao;
import com.company.model.ProductSale;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;

import java.util.List;

public class ProductSaleService implements Dao<ProductSale> {

    private final SessionFactory factory;

    public ProductSaleService(SessionFactory factory) {
        this.factory = factory;
    }

    @Override
    public ProductSale findById(Integer id) {
        try(Session session = factory.openSession()) {
            return session.get(ProductSale.class,id);
        }
    }

    @Override
    public List<ProductSale> findAll() {
        try(Session session = factory.openSession()){
            return session.createQuery("from ProductSale",ProductSale.class).list();
        }
    }

    @Override
    public void save(ProductSale productSale) {
        try(Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.save(productSale);
            transaction.commit();
        }
    }

    @Override
    public void update(ProductSale productSale) {
        try(Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.update(productSale);
            transaction.commit();
        }
    }

    @Override
    public void delete(ProductSale productSale) {
        try(Session session = factory.openSession()){
            final Transaction transaction = session.beginTransaction();
            session.delete(productSale);
            transaction.commit();
        }
    }
}
