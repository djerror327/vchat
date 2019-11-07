package com.vchat.dao;

import com.vchat.model.MThread;
import com.vchat.model.Msg;
import com.vchat.model.OnlineStatus;
import com.vchat.model.User;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;
import org.hibernate.cfg.Configuration;
import org.hibernate.cfg.Environment;
import org.hibernate.service.ServiceRegistry;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.PropertySource;
import org.springframework.stereotype.Component;

import java.util.Objects;
import java.util.Properties;

/**
 * @author tjayasekara on 11/5/2019
 * @project vchat-app
 **/

@Component
@PropertySource("hibernate.properties")
class HibernateConfig {

    private static SessionFactory sessionFactory;
    @Autowired
    private org.springframework.core.env.Environment env;

    //build sessionFactory
    private void getSessionFactory() {
        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
                .applySettings(getConfig().getProperties()).build();
        sessionFactory = getConfig().buildSessionFactory(serviceRegistry);
    }

    //read hibernate property file
    private Properties getProps() {
        Properties props = new Properties();
        props.put(Environment.DRIVER, Objects.requireNonNull(env.getProperty("hibernate.connection.driver.class")));
        props.put(Environment.URL, Objects.requireNonNull(env.getProperty("hibernate.datasource.url")));
        props.put(Environment.USER, Objects.requireNonNull(env.getProperty("hibernate.datasource.username")));
        props.put(Environment.PASS, Objects.requireNonNull(env.getProperty("hibernate.datasource.password")));
        props.put(Environment.DIALECT, Objects.requireNonNull(env.getProperty("hibernate.jpa.properties.hibernate.dialect")));
        props.put(Environment.SHOW_SQL, Objects.requireNonNull(env.getProperty("hibernate.jpa.show-sql")));
        props.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, Objects.requireNonNull(env.getProperty("current.session.context.class")));
        props.put(Environment.HBM2DDL_AUTO, Objects.requireNonNull(env.getProperty("hibernate.jpa.hibernate.ddl-auto")));
        return props;
    }

    //set configuration and map Entity classes
    private Configuration getConfig() {
        Configuration configuration = new Configuration();
        configuration.setProperties(getProps());

        //set mapping classes
        configuration.addAnnotatedClass(OnlineStatus.class);
        configuration.addAnnotatedClass(Msg.class);
        configuration.addAnnotatedClass(MThread.class);
        configuration.addAnnotatedClass(User.class);

        return configuration;
    }

    Session getSession() {
        if (sessionFactory == null) {
            getSessionFactory();
            return sessionFactory.openSession();
        } else {
            return sessionFactory.openSession();
        }
    }
}
