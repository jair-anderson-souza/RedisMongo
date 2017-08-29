/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redisexample.core.cors;

import java.io.IOException;
import javax.ws.rs.container.ContainerRequestContext;
import javax.ws.rs.container.ContainerResponseContext;
import javax.ws.rs.container.ContainerResponseFilter;
import javax.ws.rs.container.PreMatching;
import javax.ws.rs.ext.Provider;

/**
 *
 * @author Kaique Candido kaiqueoliveira.ci@gmail.com
 */
@Provider
@PreMatching
public class CorsFilter implements ContainerResponseFilter {

    @Override
    public void filter(ContainerRequestContext requestCtx, ContainerResponseContext responseCtx) throws IOException {
        System.out.println("|Entrou");
        responseCtx.getHeaders().add("Access-Control-Allow-Origin", "*");
        responseCtx.getHeaders().add("Access-Control-Allow-Headers", "origin, content-type, accept, authorization, SigningKey, pessoaType");
        responseCtx.getHeaders().add("Access-Control-Expose-Headers", "origin, content-type, accept, authorization, SigningKey, pessoaType");
        responseCtx.getHeaders().add("Access-Control-Allow-Credentials", "true");
        responseCtx.getHeaders().add("Access-Control-Allow-Methods", "GET, POST, PUT, DELETE, OPTIONS, HEAD");
        responseCtx.getHeaders().add("Access-Control-Max-Age", "1209600");
    }

}
