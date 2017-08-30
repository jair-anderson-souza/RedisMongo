/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.services.client;

import io.github.jass2125.redis.core.entity.Cart;
import java.util.List;

/**
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 3, 2017 5:14:25 PM
 */
public interface ItemService {

    public List<Cart> getItems(Long id);

}
