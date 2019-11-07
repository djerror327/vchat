package com.vchat.dao;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author tjayasekara on 11/5/2019
 * @project vchat-app
 **/
@Component
public class CommonDao {

    @Autowired
    private HibernateConfig config;

    public <T> List select(String queryName, String param, Object obj) {
        List list = new ArrayList();
        Session session = config.getSession();
        if (session != null) {
            if (param == null && obj == null) {
                //get all data
                list = session.getNamedQuery(queryName).getResultList();
            } else {
                //get data by param
                list = session.getNamedQuery(queryName).setParameter(param, obj).getResultList();
            }
        }
        return list;
    }

    public <T> void saveOrUpdate(T obj) {
//        Session session = new HibernateConfig().getSession();
        Session session = config.getSession();
        if (session != null) {
            session.beginTransaction();
            session.saveOrUpdate(obj);
            session.getTransaction().commit();
            session.close();
        } else {
            //log4j
        }
    }

    public <T> void delete(T obj) {
//        Session session = new HibernateConfig().getSession();
        Session session = config.getSession();
        if (session != null) {
            session.beginTransaction();
            session.delete(obj);
            session.getTransaction().commit();
            session.close();
        } else {
            //log4j
        }
    }
}
