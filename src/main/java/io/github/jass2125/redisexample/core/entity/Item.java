/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redisexample.core.entity;

import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Objects;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Jul 25, 2017 11:13:57 PM
 */
public class Item implements Serializable {

    private Product product;
    private Long quantity;
    private BigDecimal total;

    public Item() {
    }

    public Product getProduct() {
        return product;
    }

    public void setProduct(Product product) {
        this.product = product;
        calcTotal();
    }

    public Long getQuantity() {
        return quantity;
    }

    public void setQuantity(Long quantity) {
        this.quantity = quantity;
    }

    public void setTotal(BigDecimal total) {
        this.total = total;
    }

    public BigDecimal calcTotal() {
        this.total = this.product.getPrice().multiply(new BigDecimal(quantity));
        return total;
    }

    @Override
    public int hashCode() {
        int hash = 3;
        hash = 29 * hash + Objects.hashCode(this.product);
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
        final Item other = (Item) obj;
        return Objects.equals(this.product, other.product);
    }

    @Override
    public String toString() {
        return "Item{" + "product=" + product + ", quantity=" + quantity + '}';
    }

}
