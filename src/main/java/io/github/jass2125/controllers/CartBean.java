/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.controllers;

import io.github.jass2125.redis.core.services.client.ProductService;
import io.github.jass2125.redis.core.entity.Cart;
import io.github.jass2125.redis.core.entity.Item;
import io.github.jass2125.redis.core.entity.Product;
import io.github.jass2125.redis.core.entity.UserPrincipal;
import io.github.jass2125.redis.core.exceptions.CartException;
import io.github.jass2125.redis.redis.services.client.CartService;
import java.io.Serializable;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 18:57:40
 */
@Named
@RequestScoped
public class CartBean implements Serializable {

    @Inject
    private Item item;
    @Inject
    private Product product;
    @Inject
    private Cart cart;
    @Inject
    private ProductService productService;
    @Inject
    private Map<String, Object> sessionMap;
    @Inject
    private FacesContext context;
    @Inject
    private CartService cartService;
    private UserPrincipal userPrincipalOnession;
    private Cart cart1;
    private List<Item> items;

    public List<Item> getItems() {
        recoverUserOnSession();
        try {
            cart1 = cartService.getCart(String.valueOf(userPrincipalOnession.getId()));
            items = cart1.getItems();
            return items;
        } catch (CartException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
        }
        return Collections.EMPTY_LIST;
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public Product getProduct() {
        return product;
    }

    public void setCart1(Cart cart1) {
        this.cart1 = cart1;
    }

    public Cart getCart1() {
        return cart1;
    }

    public Item getItem() {
        return item;
    }

    public void setItem(Item item) {
        this.item = item;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public Cart getCart() {
        return cart;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public List<Product> getLoadProducts() {
        return productService.getProducts();
    }

    public void recoverUserOnSession() {
        this.userPrincipalOnession = (UserPrincipal) sessionMap.get("user");
    }

    public String addProduct() {
        try {
            recoverUserOnSession();
            item.setProduct(product);
            cart.addItem(item);
            cartService.saveCart(userPrincipalOnession.getId(), cart);
            context.getExternalContext().getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Seu item foi adicionado com sucesso", null));
        } catch (CartException e) {
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Seu item foi adicionado com sucesso", null));
        }
        return "home.xhtml/faces-redirect=true";
    }

}
