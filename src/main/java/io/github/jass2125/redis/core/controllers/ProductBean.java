package io.github.jass2125.redis.core.controllers;

import io.github.jass2125.redis.core.entity.Product;
import io.github.jass2125.redis.core.services.client.ProductService;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 28/08/2017 21:10:29
 */
@Named
@RequestScoped
public class ProductBean {

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

    public String saveProduct() {
        productService.saveProduct(product);
        return "products.xhtml";
    }
}
