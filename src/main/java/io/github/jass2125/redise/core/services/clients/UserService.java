/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redise.core.services.clients;

import io.github.jass2125.redisexample.core.entity.UserPrincipal;
import io.github.jass2125.redisexample.core.exceptions.LoginInvalidException;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 */
public interface UserService {

    public UserPrincipal loginUser(UserPrincipal user) throws LoginInvalidException;

    public UserPrincipal searchById(Long id);
}
