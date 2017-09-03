/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.controllers;

import com.google.gson.JsonObject;
import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import io.github.jass2125.redis.core.entity.Cart;
import io.github.jass2125.redis.core.entity.Order;
import io.github.jass2125.redis.core.entity.UserPrincipal;
import io.github.jass2125.redis.core.services.client.CartService;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import io.github.jass2125.redis.core.annotations.UserSession;
import io.github.jass2125.redis.core.converters.GsonConverter;
import io.github.jass2125.redis.core.services.client.OrderService;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Named;
import org.bson.Document;
import org.eclipse.persistence.sessions.server.ExternalConnectionPool;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 30/08/2017 11:22:23
 */
@Named
@RequestScoped
public class OrderBean implements Serializable {

    @Inject
    private CartService cartService;
    @Inject
    private Map<String, Object> sessionMap;
    @Inject
    private Order order;
    @Inject
    @UserSession
    private UserPrincipal userPrincipal;
    @Inject
    private Cart cart;
    @Inject
    private OrderService orderService;
    @Inject
    private FacesContext context;
    @Inject
    private ExternalContext externalContext;

    public String finalizeOrder() {
        try {
            cart = cartService.getCart(String.valueOf(userPrincipal.getId()));
            order.setCart(cart);
            order.setOwner(userPrincipal);
            orderService.saveOrder(order);
            externalContext.getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, "Sua compra foi finalizada com sucesso", null));
            return "cart?faces-redirect=true";
        } catch (Exception e) {
            externalContext.getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, e.getMessage(), null));
            return "cart?faces-redirect=true";
        }
    }
}
