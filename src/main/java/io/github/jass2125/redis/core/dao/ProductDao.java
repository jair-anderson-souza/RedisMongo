/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.dao;

import io.github.jass2125.redis.core.entity.Product;
import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 3, 2017 2:16:36 PM
 */
public class ProductDao {

    @PersistenceContext
    private EntityManager em;

    public List<Product> searchAllProducts() {
        return em.createQuery("SELECT P FROM Product P", Product.class).getResultList();
    }

    public void saveProduct(Product product) {
        try {
//            em.getTransaction().begin();
            em.persist(product);
//            em.getTransaction().commit();
        } catch (Exception e) {
//            em.getTransaction().rollback();
            e.printStackTrace();
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
