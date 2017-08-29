/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redisexample.core.dao;

import io.github.jass2125.redis.core.services.CartException;
import io.github.jass2125.redis.core.util.Redis;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 3, 2017 4:32:36 PM
 */
public class CartDao {

    @Inject
    private Redis redis;

    public void saveCart(String sessionId, String cart) {
        try {
            redis.saveWithExpire(sessionId, 7200, cart);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public String searchCartByUser(String id) throws CartException {
        try {
            return redis.get(id);
        } catch (Exception e) {
            return null;
        }
    }

//    public void searchCartByUser(Long id) {
//        
//    }
}
