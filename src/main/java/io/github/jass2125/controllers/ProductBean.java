/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.controllers;

import io.github.jass2125.redis.core.services.client.ProductService;
import io.github.jass2125.redisexample.core.entity.Product;
import java.io.Serializable;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 18:57:40
 */
@Named
@RequestScoped
public class ProductBean implements Serializable {

    @Inject
    private Product product;
    @Inject
    private ProductService productService;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public List<Product> getLoadProducts() {
        return productService.getProducts();
    }
}
