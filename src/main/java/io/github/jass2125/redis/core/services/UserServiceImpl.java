/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.services;

import io.github.jass2125.redis.core.exceptions.CryptographyException;
import io.github.jass2125.redis.core.exceptions.EncodingException;
import io.github.jass2125.redis.core.util.PasswordEncriptor;
import io.github.jass2125.redis.redis.services.client.UserService;
import io.github.jass2125.redis.core.dao.UserDao;
import io.github.jass2125.redis.core.entity.UserPrincipal;
import io.github.jass2125.redis.core.exceptions.LoginInvalidException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;

/**
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 4, 2017 10:33:04 AM
 */
public class UserServiceImpl implements UserService {

    @Inject
    private UserDao dao;
    @Inject
    private PasswordEncriptor encriptor;

    @Override
    public UserPrincipal loginUser(UserPrincipal user) throws LoginInvalidException {
        try {
            String encryptedPassword = encriptor.encryptPassword(user.getPassword());
            return dao.searchByEmailAndPassword(user.getEmail(), encryptedPassword);
        } catch (CryptographyException | EncodingException e) {
            Logger.getLogger(UserServiceImpl.class.getName()).log(Level.SEVERE, e.getMessage(), e);
            throw new LoginInvalidException(e, e.getMessage());
        }
    }

    @Override
    public UserPrincipal searchById(Long id) {
        return dao.searchById(id);
    }

}
