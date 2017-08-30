/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.entity;

import java.io.Serializable;
import java.util.Objects;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 29/08/2017 21:47:35
 */
public class Order implements Serializable {

    private UserPrincipal owner;
    private Cart cart;

    public Order() {
    }

    public Cart getCart() {
        return cart;
    }

    public UserPrincipal getOwner() {
        return owner;
    }

    public void setCart(Cart cart) {
        this.cart = cart;
    }

    public void setOwner(UserPrincipal owner) {
        this.owner = owner;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 79 * hash + Objects.hashCode(this.owner);
        hash = 79 * hash + Objects.hashCode(this.cart);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Order other = (Order) obj;
        if (!Objects.equals(this.owner, other.owner)) {
            return false;
        }
        return Objects.equals(this.cart, other.cart);
    }

}
