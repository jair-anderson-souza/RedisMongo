/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.dao;

import io.github.jass2125.redisexample.core.entity.Product;
import java.util.List;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.inject.Inject;
import javax.persistence.EntityManager;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 3, 2017 2:16:36 PM
 */
public class ProductDao {

    @Inject
    private EntityManager em;

    @PostConstruct
    private void init() {
    }

    public List<Product> searchAllProducts() {
        return em.createQuery("SELECT P FROM Product P", Product.class).getResultList();
    }

    public void saveProduct(Product p) {
        try {
            em.getTransaction().begin();
            em.persist(p);
            em.getTransaction().commit();
        } catch (Exception e) {
            e.printStackTrace();
            em.getTransaction().rollback();
        }
    }

    public Product searchById(Long id) {
        try {
            return em.createQuery("SELECT P FROM Product P WHERE P.id = :id", Product.class).setParameter("id", id).getSingleResult();
        } catch (Exception e) {
            return null;
        }
    }
}
