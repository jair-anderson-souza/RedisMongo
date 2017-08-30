/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.redis.core.converters;

import io.github.jass2125.redis.core.services.client.ProductService;
import io.github.jass2125.redis.core.entity.Product;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.FacesConverter;
import javax.inject.Inject;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 22:38:54
 */
@FacesConverter(value = "productConverter")
public class ProductConverter implements Converter {

    @Inject
    private ProductService productService;

    @Override
    public Object getAsObject(FacesContext context, UIComponent component, String value) {
        Product product = new Product();
        if (value != null) {
            try {
                Long id = Long.valueOf(value);
                product = productService.searchById(id);
            } catch (Exception ex) {
                Logger.getLogger(ProductConverter.class.getName()).log(Level.SEVERE, null, ex);
            }
        }
        return product;
    }

    @Override
    public String getAsString(FacesContext context, UIComponent component, Object value) {
        String asString = "";
        if (value != null) {
            Product product = (Product) value;
            asString = String.valueOf(product.getId());
        }
        return asString;
    }

}
