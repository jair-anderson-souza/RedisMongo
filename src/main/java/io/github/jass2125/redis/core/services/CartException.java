/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.redis.core.services;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 23:24:05
 */
public class CartException extends Exception {

    public CartException(Exception e, String msg) {
        super(msg, e);
    }

    public CartException(String msg) {
        super(msg);
    }

}
