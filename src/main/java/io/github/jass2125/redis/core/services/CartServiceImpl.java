/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.services;

import io.github.jass2125.controllers.GsonConverter;
import io.github.jass2125.redisexample.core.services.client.CartService;
import io.github.jass2125.redisexample.core.dao.CartDao;
import io.github.jass2125.redisexample.core.entity.Cart;
import io.github.jass2125.redisexample.core.entity.Item;
//import io.github.jass2125.redisexample.core.services.clients.UserServicde;
import java.util.List;
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

    public void verifyDuplicatePdroducts(List<Item> it, List<Item> it2) {
        for (Item item : it) {
            for (Item item1 : it2) {
                if (it.equals(it2)) {
                    updateQuantity(item, item1);
                }
                it.add(item1);
            }
        }
    }

    public void saveCart(Long id, Item item) {
//        UserPrincipal user = userService.searchById(id);
//        UserPrincipal user = null;
//        if (user != null) {
//            String cartString = cartDao.searchCartByUser(String.valueOf((id)));
//            Gson gson = new Gson();
//            Cart cart = gson.fromJson(cartString, Cart.class);
//            if (cart != null) {
////                int it = verificaNovoItem(cart.getItems(), item);
//                int it = 0;
//                if (it != -1) {
//                    item.setQuantity(item.getQuantity() + cart.getItems().get(it).getQuantity());
//                    cart.getItems().set(it, item);
//                } else {
//                    cart.addItem(item);
//                }
//            } else if (cart == null) {
//                cart = new Cart();
//                cart.addItem(item);
//            }
//            cart.setSessionId(String.valueOf(id));
//            String gsonObj = gson.toJson(cart);
//            cartDao.saveCart(gsonObj, cart.getSessionId());
//        }
    }

    public int verificaNdovoItem(List<Item> items, Item item) {
        for (int i = 0; i < items.size(); i++) {
            if (items.get(i).equals(item)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public Cart getCart(String id) {
//        String searchCartByUser = cartDao.searchCartByUser(id);
//        Gson gson = new Gson();
//        Cart cart = gson.fromJson(searchCartByUser, Cart.class);
        return null;
    }

    private void updateQuantity(Item it, Item it2) {
        Long quantity = it.getQuantity();
        quantity += it2.getQuantity();
        it.setQuantity(quantity);
        it.calcTotal();
    }

}
