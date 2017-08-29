/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.services;

import io.github.jass2125.redis.core.dao.ProductDao;
import io.github.jass2125.redis.core.services.client.ProductService;
import io.github.jass2125.redis.core.entity.Product;
import java.util.Collections;
import java.util.List;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 3, 2017 2:11:58 PM
 */
public class ProductServiceImpl implements ProductService {

    @Inject
    private ProductDao productDao;

    @Override
    public List<Product> getProducts() {
        try {
            List<Product> products = productDao.searchAllProducts();
            return products;
        } catch (Exception e) {
            return Collections.EMPTY_LIST;
        }
    }

    @Override
    public Product searchById(Long id) {
        try {
            return productDao.searchById(id);
        } catch (Exception e) {
            return null;
        }
    }

    @Override
    public void saveProduct(Product product) {
        try {
            productDao.saveProduct(product);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
