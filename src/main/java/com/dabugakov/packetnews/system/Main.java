package com.dabugakov.packetnews.system;

import com.dabugakov.packetnews.spiders.kommersant.KommersantSpider;
import com.mongodb.MongoClient;


import java.io.IOException;
import java.util.List;


/**
 * Created by DABugakov on 17.11.2015.
 */
public class Main {

    public static void main(String... args) throws IOException {
        MongoClient mongoClient = new MongoClient("localhost",27017);
        List<String> dbs = mongoClient.getDatabaseNames();
        for(String s:dbs){
            System.out.println(s);
        }




//        KommersantSpider kommersantSpider = new KommersantSpider();
//        kommersantSpider.setDateStart("17.10.2015");
//        kommersantSpider.setDateEnd("17.11.2015");
//        kommersantSpider.setStartUrl("http://www.kommersant.ru/Search/");
//        kommersantSpider.setSearchUrl("http://www.kommersant.ru");
//        kommersantSpider.setReference("Газпром");
//        kommersantSpider.rootRound();
    }

}
