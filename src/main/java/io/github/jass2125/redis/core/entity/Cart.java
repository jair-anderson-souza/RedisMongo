/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.entity;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Jul 25, 2017 11:13:49 PM
 */
public class Cart implements Serializable {

    private String sessionId;
    private List<Item> items;

    public Cart() {
        this.items = new ArrayList<>();
    }

    public void setItems(List<Item> items) {
        this.items = items;
    }

    public String getSessionId() {
        return sessionId;
    }

    public void setSessionId(String sessionId) {
        this.sessionId = sessionId;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 31 * hash + Objects.hashCode(this.sessionId);
        hash = 31 * hash + Objects.hashCode(this.items);
        return hash;
    }

    public void addItem(Item item) {
        if (!containsItem(item)) {
            item.calcTotal();
            this.items.add(item);
        }
    }

    public boolean containsItem(Item item) {
        if (this.items.contains(item)) {
            plusQuantity(item);
            return true;
        }
        return false;
    }

    public void plusQuantity(Item item) {
        for (Item it : items) {
            if (it.equals(item)) {
                Long currentQuantity = it.getQuantity() + item.getQuantity();
                it.setQuantity(currentQuantity);
                it.calcTotal();
            }
        }
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
        final Cart other = (Cart) obj;
        if (!Objects.equals(this.sessionId, other.sessionId)) {
            return false;
        }
        return Objects.equals(this.items, other.items);
    }

    @Override
    public String toString() {
        return "Cart{" + "sessionId=" + sessionId + ", items=" + items + '}';
    }

    public List<Item> getItems() {
        return this.items;
    }

}
