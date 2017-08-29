/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.services;

import io.github.jass2125.controllers.GsonConverter;
import io.github.jass2125.redis.redis.services.client.CartService;
import io.github.jass2125.redis.core.dao.CartDao;
import io.github.jass2125.redis.core.entity.Cart;
import io.github.jass2125.redis.core.entity.Item;
import io.github.jass2125.redis.core.exceptions.CartException;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 3, 2017 4:30:28 PM
 */
public class CartServiceImpl implements CartService {

    @Inject
    private CartDao cartDao;
    @Inject
    private GsonConverter gsonConverter;
//    @EJB
//    private UserServicde userService;

    @Override
    public void saveCart(Long id, Cart cart) throws CartException {
        try {
            String cartByUser = cartDao.searchCartByUser(id.toString());
            if (cartByUser != null) {
                Cart cart2 = gsonConverter.convertToObject(cartByUser);
                cart.getItems().forEach(t -> {
                    cart2.addItem(t);
                });
                String json = gsonConverter.convertToJson(cart2);
                cartDao.saveCart(String.valueOf(id), json);
            } else {
                String cartJson = gsonConverter.convertToJson(cart);
                cartDao.saveCart(id.toString(), cartJson);
            }
        } catch (CartException e) {
            throw new CartException(e, "Não foi possível salvar esse carrinho!!");
        }
    }

    @Override
    public Cart getCart(String id) throws CartException {
        String cartJson = cartDao.searchCartByUser(String.valueOf(id));
        Cart cart = gsonConverter.convertToObject(cartJson);
        return cart;
    }
}
