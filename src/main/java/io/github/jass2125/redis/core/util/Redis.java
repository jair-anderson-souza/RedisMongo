package io.github.jass2125.redis.core.util;

import java.util.Set;
import redis.clients.jedis.Jedis;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @since Aug 25, 2017 03:47:54 PM
 */
public class Redis {

    private Jedis jedis;
    private String localhost;
    private int port;

    public Redis() {
        this.localhost = "localhost";
        this.port = 6379;
        this.jedis = new Jedis(localhost, port);
    }

    public Set<String> getKeys(String key) {
        return this.jedis.keys(key);
    }

    public String get(String key) {
        String obj = this.jedis.get(key);
        return obj;
    }

    public Jedis getJedis() {
        return jedis;
    }

    public void saveWithExpire(String sessionId, int expireTime, String cart) {
        this.jedis.setex(sessionId, expireTime, cart);
    }

}
