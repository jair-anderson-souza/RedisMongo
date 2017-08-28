/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.services;

import com.google.gson.Gson;
import io.github.jass2125.redisexample.core.services.client.CartService;
import io.github.jass2125.redisexample.core.dao.CartDao;
import io.github.jass2125.redisexample.core.entity.Cart;
import io.github.jass2125.redisexample.core.entity.Item;
import io.github.jass2125.redisexample.core.entity.UserPrincipal;
//import io.github.jass2125.redisexample.core.services.clients.UserServicde;
import java.util.List;
import javax.ejb.EJB;
import javax.ejb.Remote;
import javax.ejb.Stateless;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 3, 2017 4:30:28 PM
 */
@Stateless
@Remote(CartService.class)
public class CartServiceImpl implements CartService {

    @EJB
    private CartDao cartDao;
//    @EJB
//    private UserServicde userService;

    @Override
    public void saveCart(Long id, Item item) {
//        UserPrincipal user = userService.searchById(id);
        UserPrincipal user = null;
        if (user != null) {
            String cartString = cartDao.searchCartByUser(String.valueOf((id)));
            Gson gson = new Gson();
            Cart cart = gson.fromJson(cartString, Cart.class);
            if (cart != null) {
                int it = verificaNovoItem(cart.getItems(), item);
                if (it != -1) {
                    item.setQuantity(item.getQuantity() + cart.getItems().get(it).getQuantity());
                    cart.getItems().set(it, item);
                }else{
                    cart.addItem(item);
                }
            } else if (cart == null) {
                cart = new Cart();
                cart.addItem(item);
            } 
            cart.setSessionId(String.valueOf(id));
            String gsonObj = gson.toJson(cart);
            cartDao.saveCart(gsonObj, cart.getSessionId());
        }
    }

    public int verificaNovoItem(List<Item> items, Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Cart getCart(String id) {
        String searchCartByUser = cartDao.searchCartByUser(id);
        Gson gson = new Gson();
        Cart cart = gson.fromJson(searchCartByUser, Cart.class);
        return cart;
    }

}
