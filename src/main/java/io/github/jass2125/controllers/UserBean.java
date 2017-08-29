/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.controllers;

import io.github.jass2125.redis.redis.services.client.UserService;
import io.github.jass2125.redis.core.entity.UserPrincipal;
import io.github.jass2125.redis.core.exceptions.LoginInvalidException;
import java.io.Serializable;
import java.util.Map;
import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 00:50:09
 */
@RequestScoped
@Named
public class UserBean implements Serializable {

    @Inject
    private UserService userService;
    @Inject
    private UserPrincipal user;
    @Inject
    private FacesContext context;
    @Inject
    private ExternalContext externalContext;
    @Inject
    private Map<String, Object> sessionMap;

    public UserPrincipal getUser() {
        return user;
    }

    public void setUser(UserPrincipal user) {
        this.user = user;
    }

    public String login() {
        try {
            UserPrincipal loginUser = userService.loginUser(user);
            sessionMap.put("user", loginUser);
            return "home?faces-redirect=true";
        } catch (LoginInvalidException ex) {
            externalContext.getFlash().setKeepMessages(true);
            context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_ERROR, ex.getMessage(), null));
            return "index?faces-redirect=true";
        }
    }

    public String logout() {
        sessionMap.remove(sessionMap.get("user"));
        sessionMap.clear();
        externalContext.getFlash().setKeepMessages(true);
        context.addMessage(null, new FacesMessage(FacesMessage.SEVERITY_INFO, "Você foi deslogado", null));
        return "index?faces-redirect=true";
    }
}
