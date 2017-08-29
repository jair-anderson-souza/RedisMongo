/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.controllers;

import com.google.gson.Gson;
import javax.enterprise.inject.Produces;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 27/08/2017 23:08:32
 */
public class GsonProducer {

    @Produces
    private Gson gson = new Gson();
}
