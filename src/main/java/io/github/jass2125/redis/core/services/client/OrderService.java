/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.services.client;

import io.github.jass2125.redis.core.entity.Order;
import io.github.jass2125.redis.core.exceptions.OrderException;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 30/08/2017 11:22:10
 */
public interface OrderService {

    public void saveOrder(Order order) throws OrderException;

}
