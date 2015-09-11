package com.test.rest.services;

import com.mongodb.*;
import com.test.rest.models.UserModel;
import org.junit.Before;
import org.junit.Test;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by nkostets on 9/8/2015.
 */
public class MongoTest {
    private DB db;
    private MongoClient mongo;
    @Before
    public void setUp() throws Exception {
    }

    @Test
    public void test() {

        mongo = new MongoClient(Arrays.asList(new ServerAddress("localhost", 27017), new ServerAddress("nazar.webhop.me", 27017)));
        db = mongo.getDB("test");
        List<DBObject> list = new ArrayList();
        DBObject user = new BasicDBObject();
        DBObject user2 = new BasicDBObject();
        user.put("name", "Naz");
        user2.put("name", "Lola");

        list.add(user);
        list.add(user2);

        DBObject object = new BasicDBObject();
        object.put("mame", "bar");
        object.put("friends", list);
        db.getCollection("foo3").insert(object);
    }
}
