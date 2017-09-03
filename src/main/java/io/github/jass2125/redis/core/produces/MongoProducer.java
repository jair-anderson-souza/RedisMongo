/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.produces;

import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.enterprise.inject.Produces;
import org.bson.Document;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 30/08/2017 11:50:39
 */
public class MongoProducer {

    @Produces
    private MongoClient MongoClient = new MongoClient("localhost", 27017);
    @Produces
    private MongoDatabase mongoDatabase = MongoClient.getDatabase("test");
    @Produces
    private MongoCollection<Document> mongoCollection = mongoDatabase.getCollection("orders");
}
