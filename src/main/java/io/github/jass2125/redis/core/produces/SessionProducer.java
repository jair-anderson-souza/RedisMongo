/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.produces;

import io.github.jass2125.redis.core.entity.UserPrincipal;
import javax.enterprise.inject.Produces;
import javax.faces.context.FacesContext;
import io.github.jass2125.redis.core.annotations.UserSession;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 29/08/2017 22:11:07
 */
public class SessionProducer {

    @Produces
    @UserSession
    private UserPrincipal userPrincipal = (UserPrincipal) FacesContext.getCurrentInstance().getExternalContext().getSessionMap().get("user");
}
