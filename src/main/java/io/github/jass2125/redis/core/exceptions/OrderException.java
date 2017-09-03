/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package io.github.jass2125.redis.core.exceptions;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 01/09/2017 10:47:31
 */
public class OrderException extends Exception {

    public OrderException(Exception e, String msg) {
        super(msg, e);
    }

}
