/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.interceptors;

import javax.annotation.Priority;
import javax.interceptor.AroundInvoke;
import javax.interceptor.Interceptor;
import javax.interceptor.InvocationContext;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 29/08/2017 19:15:13
 */

@SecurityAnnotation
@Interceptor
@Priority(Interceptor.Priority.APPLICATION)
public class SecurityInterceptor {

    @AroundInvoke
    public Object verifyAuthentication(InvocationContext context) throws Exception {
        System.out.println("Chamou");
        return context.proceed();
    }
}
