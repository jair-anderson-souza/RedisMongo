/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.util;

import com.mongodb.BasicDBObjectBuilder;
import com.mongodb.DBObject;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoDatabase;
import io.github.jass2125.redis.core.entity.UserPrincipal;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 29/08/2017 21:33:57
 */
public class Mongo {
    
    public MongoDatabase createConnection() {
        MongoClient mongoClient = new MongoClient("localhost", 27017);
        return mongoClient.getDatabase("megasena");
//        return mongoClient;
    }
    
    public static void main(String[] args) {
        UserPrincipal user = new UserPrincipal();
        user.setId(1L);
        user.setEmail("jair");
        user.setPassword("123");
        
        BasicDBObjectBuilder builder = new BasicDBObjectBuilder();
        builder.append("_id", user.getId()).append("_email", user.getEmail()).append("password", user.getPassword());
        DBObject get = builder.get();
        System.out.println(get);
        
        //        Mongo mongo = new Mongo();
        //        MongoDatabase createConnection = mongo.createConnection();
        //        System.out.println(createConnection.getName());
    }
}
