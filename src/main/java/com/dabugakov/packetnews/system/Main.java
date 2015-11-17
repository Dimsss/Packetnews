package com.dabugakov.packetnews.system;

import com.dabugakov.packetnews.buillders.kommersant.KommersantBuilder;
import com.dabugakov.packetnews.spiders.kommersant.KommersantSpider;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;


import java.io.IOException;

/**
 * Created by DABugakov on 17.11.2015.
 */
public class Main {

    public static void main(String... args) throws IOException {
        KommersantSpider kommersantSpider = new KommersantSpider();
        kommersantSpider.setDateStart("17.10.2015");
        kommersantSpider.setDateEnd("17.11.2015");
        kommersantSpider.setStartUrl("http://www.kommersant.ru/Search/");
        kommersantSpider.setSearchUrl("http://www.kommersant.ru");
        kommersantSpider.setReference("Газпром");
        kommersantSpider.rootRound();
    }

}
