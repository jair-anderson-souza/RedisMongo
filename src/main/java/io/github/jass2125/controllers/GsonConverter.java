/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.controllers;

import com.google.gson.Gson;
import io.github.jass2125.redis.core.entity.Cart;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 28/08/2017 00:11:16
 */
public class GsonConverter {

    @Inject
    private Gson gson;

    public String convertToJson(Cart cart) {
        return gson.toJson(cart);
    }

    public Cart convertToObject(String json) {
        return gson.fromJson(json, Cart.class);
    }

}
