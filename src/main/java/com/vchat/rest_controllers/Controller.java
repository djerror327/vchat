package com.vchat.rest_controllers;

import com.vchat.dao.CommonDao;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;

/**
 * @author tjayasekara on 11/4/2019
 * @project applicationpropertiesdemo
 **/
@org.springframework.stereotype.Controller
public class Controller {
    @Autowired
    CommonDao commonDao;
//    private static SessionFactory sessionFactory;
//    @Autowired
//     private org.springframework.core.env.Environment env;

    @GetMapping(path = "/home")
    public String getHome() {
//        Configuration configuration = new Configuration();
//        Properties settings = new Properties();
//        settings.put(Environment.DRIVER,env.getProperty("hibernate.connection.driver.class") );
//        settings.put(Environment.URL, env.getProperty("spring.datasource.url"));
//        settings.put(Environment.USER, env.getProperty("spring.datasource.username"));
//        settings.put(Environment.PASS, env.getProperty("spring.datasource.password"));
//        settings.put(Environment.DIALECT, env.getProperty("spring.jpa.properties.hibernate.dialect"));
//        settings.put(Environment.SHOW_SQL, env.getProperty("spring.jpa.show-sql"));
//        settings.put(Environment.CURRENT_SESSION_CONTEXT_CLASS, env.getProperty("current.session.context.class"));
//        settings.put(Environment.HBM2DDL_AUTO, env.getProperty("spring.jpa.hibernate.ddl-auto"));

//        configuration.setProperties(settings);
//
//        configuration.addAnnotatedClass(OnlineStatus.class);
//        configuration.addAnnotatedClass(Msg.class);
//        configuration.addAnnotatedClass(MThread.class);
//        configuration.addAnnotatedClass(User.class);

//        ServiceRegistry serviceRegistry = new StandardServiceRegistryBuilder()
//                .applySettings(configuration.getProperties()).build();
//        sessionFactory = configuration.buildSessionFactory(serviceRegistry);

//        Session session = sessionFactory.openSession();
//        session.beginTransaction();

        // Add new Employee object
//        UserDetails emp = new UserDetails();
//        emp.setEmail("demo-user@mail.com");
//        emp.setFirstName("demo1");
//        emp.setLastName("user2");

//        OnlineStatus emp = new OnlineStatus();
//        emp.setId(2);
//        emp.setName("not online");
//       List list= CommonDao.select("OnlineStatus.findById","id",1);
//        List list = commonDao.select("OnlineStatus.findAll", null, null);
//        if (list.size() != 0) {
//            OnlineStatus obj = (OnlineStatus) list.get(0);
//            System.out.println("list size : " + list.size() + " value : " + obj.getName());
//        } else {
//            System.out.println("data not found : list size : " + list.size());
//        }

//        session.save(emp);
//        session.getTransaction().commit();
//        session.flush();
//        session.close();
//        HibernateUtil.shutdown();
        return "index.html";
    }
}
