/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.util;

import io.github.jass2125.redis.core.exceptions.CryptographyException;
import io.github.jass2125.redis.core.exceptions.EncodingException;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 20:52:55
 */
public interface PasswordEncriptor {

//    private MessageDigest instance;

    public String encryptPassword(String password) throws CryptographyException, EncodingException;

    public boolean comparatePassword(String passwordUser, String passwordForm) throws EncodingException, CryptographyException;

//    private void createMessageDigest() throws CryptographyException;

//    private byte[] encoding(String password) throws EncodingException;

}
