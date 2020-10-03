//package com.project.lgnscrt;
//
//import com.project.lgnscrt.entity.Sensor;
//import org.apache.lucene.search.Query;
//import org.hibernate.search.jpa.FullTextEntityManager;
//import org.hibernate.search.jpa.Search;
//import org.hibernate.search.query.dsl.QueryBuilder;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.beans.factory.annotation.Qualifier;
//import org.springframework.context.annotation.Bean;
//import org.springframework.stereotype.Service;
//
//import javax.persistence.EntityManager;
//import javax.persistence.NoResultException;
//import javax.persistence.PersistenceContext;
//import javax.transaction.Transactional;
//import java.util.List;
//
//@Service
//public class HibernateSearchService {
//
//    @PersistenceContext
//    private final EntityManager entityManager;
//
//    public HibernateSearchService(EntityManager entityManager) {
//        this.entityManager = entityManager;
//    }
//
//    public void initializeHibernateSearch() {
//
//        try {
//            FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//            fullTextEntityManager.createIndexer().startAndWait();
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
//    }
//
//    @Transactional
//    public List<Sensor> fuzzySearch(String searchTerm) {
//
//        FullTextEntityManager fullTextEntityManager = Search.getFullTextEntityManager(entityManager);
//        QueryBuilder qb = fullTextEntityManager.getSearchFactory().buildQueryBuilder().forEntity(Sensor.class).get();
//        Query luceneQuery = qb.keyword().fuzzy().withEditDistanceUpTo(1).withPrefixLength(1).onFields("name","model","rangeFrom","rangeTo","type","unit","location","description")
//                .matching(searchTerm).createQuery();
//
//        javax.persistence.Query jpaQuery = fullTextEntityManager.createFullTextQuery(luceneQuery, Sensor.class);
//
//        List<Sensor> sensorList = null;
//        try {
//            sensorList = jpaQuery.getResultList();
//        } catch (NoResultException nre) {
//            nre.printStackTrace();
//
//        }
//
//        return sensorList;
//
//
//    }
//}