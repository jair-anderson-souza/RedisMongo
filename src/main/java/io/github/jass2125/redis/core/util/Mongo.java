/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package io.github.jass2125.redis.core.util;

import io.github.jass2125.redis.core.exceptions.OrderException;
import com.mongodb.MongoClient;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoDatabase;
import javax.inject.Inject;
import org.bson.Document;

/**
 *
 * @author <a href="mailto:jair_anderson_bs@hotmail.com">Anderson Souza</a>
 * @author 29/08/2017 21:33:57
 */
public class Mongo {

    @Inject
    private MongoClient mongoClient;
    @Inject
    private MongoDatabase mongoDatabase;
    @Inject
    private MongoCollection<Document> mongoCollection;

    public void save(String json) throws OrderException {
        try {
            Document doc = new Document();
            doc.append("order", json);
            mongoCollection.insertOne(doc);
        } catch (Exception e) {
            throw new OrderException(e, "Não foi possível salvar o cart");
        }
    }

}
