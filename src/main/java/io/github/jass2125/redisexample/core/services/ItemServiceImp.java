/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redisexample.core.services;

import com.google.gson.Gson;
import io.github.jass2125.redis.core.util.Redis;
import io.github.jass2125.redisexample.core.entity.Cart;
import io.github.jass2125.redisexample.core.services.client.ItemService;
import java.util.ArrayList;
import java.util.List;
import java.util.Set;
import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 3, 2017 5:13:54 PM
 */
@Stateless
@Remote(ItemService.class)
public class ItemServiceImp implements ItemService {

    private Redis redis;

    @PostConstruct
    public void init() {
        this.redis = new Redis();
    }

    @PreDestroy
    public void end() {
        this.redis = null;
    }

    @Override
    public List<Cart> getItems(Long id) {
        Set<String> keys = redis.getKeys(String.valueOf(id));
        Gson gson = new Gson();
        List<Cart> carts = new ArrayList<>();
        try {
            for (String key : keys) {
                String str = redis.get(key);
                System.out.println("Srt: " + str);
                Cart cart = gson.fromJson(str, Cart.class);
                carts.add(cart);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
        return carts;
    }

}
