//package com.project.lgnscrt.config;
//
//import com.project.lgnscrt.HibernateSearchService;
//import org.hibernate.search.jpa.FullTextEntityManager;
//import org.hibernate.search.jpa.Search;
//import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
//import org.springframework.context.ApplicationListener;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//import org.springframework.context.event.ContextRefreshedEvent;
//import org.springframework.stereotype.Component;
//
//import javax.persistence.EntityManager;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//
//
//@Component
//public class HibernateSearchConfiguration implements ApplicationListener<ContextRefreshedEvent> {
//
//    @PersistenceContext
//    private EntityManager entityManager;
//
//
//    @Override
//    @Transactional
//    public void onApplicationEvent(ContextRefreshedEvent event) {
//
//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//        try {
//            fullTextEntityManager.createIndexer().startAndWait();
//        } catch (InterruptedException e) {
//            System.out.println("Error occured trying to build Hibernate Search indexes "
//                    + e.toString());
//        }
//    }
//
//
//}
