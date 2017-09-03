package io.github.jass2125.redis.core.controllers;

import io.github.jass2125.redis.core.entity.Product;
import io.github.jass2125.redis.core.annotations.Security;
import io.github.jass2125.redis.core.services.client.ProductService;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
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
@Security
public class ProductBean implements Serializable {

    @Inject
    private Product product;
    @Inject
    private ProductService productService;
    @Inject
    private ExternalContext externalContext;
    @Inject
    private FacesContext context;

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public String saveProduct() {
        try {
            productService.saveProduct(product);
            externalContext.getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sua compra foi finalizada com sucesso", null));
            return "products.xhtml?faces-redirect=true";
//            return "cart?faces-redirect=true";
        } catch (Exception e) {
            externalContext.getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Erro", null));
            return "products.xhtml?faces-redirect=true";
        }
    }
}
