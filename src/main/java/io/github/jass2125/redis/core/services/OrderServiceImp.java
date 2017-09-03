/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.services;

import com.google.gson.Gson;
import io.github.jass2125.redis.core.entity.Order;
import io.github.jass2125.redis.core.services.client.OrderService;
import io.github.jass2125.redis.core.util.Mongo;
import io.github.jass2125.redis.core.exceptions.OrderException;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 30/08/2017 11:52:36
 */
public class OrderServiceImp implements OrderService {

    @Inject
    private Gson gson;
    @Inject
    private Mongo mongoDB;

    @Override
    public void saveOrder(Order order) throws OrderException {
        try {
            String orderJson = gson.toJson(order);
            mongoDB.save(orderJson);
        } catch (Exception e) {
            throw new OrderException(e, "Não foi possível finalizar a compra!");
        }
    }

}
