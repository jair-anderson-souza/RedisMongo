/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.exceptions;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 02:57:27
 */
public class LoginInvalidException extends Exception {

    public LoginInvalidException(Exception e, String msg) {
        super(msg, e);
    }

    public LoginInvalidException(String msg) {
        super(msg);
    }

}
