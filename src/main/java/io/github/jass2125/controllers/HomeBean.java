/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.controllers;

import io.github.jass2125.redis.core.entity.UserPrincipal;
import java.io.Serializable;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 17:54:16
 */
@Named
@RequestScoped
public class HomeBean implements Serializable {

    @Inject
    private FacesContext context;

    public void seeUser() {
        UserPrincipal user = (UserPrincipal) context.getExternalContext().getSessionMap().get("user");
        System.out.println(user);
    }

}
