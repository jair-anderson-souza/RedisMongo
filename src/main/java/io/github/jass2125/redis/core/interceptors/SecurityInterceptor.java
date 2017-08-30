/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.interceptors;

import io.github.jass2125.redis.core.annotations.UserOnAnnotation;
import io.github.jass2125.redis.core.entity.UserPrincipal;
import io.github.jass2125.redis.core.exceptions.LoginInvalidException;
import javax.annotation.Priority;
import javax.inject.Inject;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 29/08/2017 19:15:13
 */
@Security
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class SecurityInterceptor {

    @Inject
    @UserOnAnnotation
    private UserPrincipal user;

    @AroundInvoke
    public Object verifyAuthentication(InvocationContext context) throws Exception {
        if (user == null) {
            throw new LoginInvalidException("Você não está logado");
        }
        return context.proceed();
    }
}
