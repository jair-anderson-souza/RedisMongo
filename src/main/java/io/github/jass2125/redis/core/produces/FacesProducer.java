/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.produces;

import java.util.Map;
import javax.enterprise.inject.Produces;
import javax.faces.context.ExternalContext;
import javax.faces.context.FacesContext;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 17:47:25
 */
public class FacesProducer {

    @Produces
    private FacesContext context = FacesContext.getCurrentInstance();

    @Produces
    private Map<String, Object> sessionMap = FacesContext.getCurrentInstance().getExternalContext().getSessionMap();
    
    @Produces
    private ExternalContext externalContext = FacesContext.getCurrentInstance().getExternalContext();

}
