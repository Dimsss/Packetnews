package com.dabugakov.packetnews.spiders.kommersant;

import com.dabugakov.packetnews.buillders.kommersant.KommersantBuilder;
import com.dabugakov.packetnews.system.Win1251;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.select.Elements;
import org.jsoup.nodes.Element;

import java.io.IOException;


/**
 * Created by DABugakov on 17.11.2015.
 */
public class KommersantSpider {
    private String reference;
    private String startUrl;
    private String searchUrl;

    private KommersantBuilder kommersantBuilder;

    private String dateStart;
    private String dateEnd;

    public void setSearchUrl(String searchUrl) {
        this.searchUrl = searchUrl;
    }

    public void setStartUrl(String startUrl) {
        this.startUrl = startUrl;
    }

    public void setDateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    public void setDateEnd(String dateEnd) {
        this.dateEnd = dateEnd;
    }

    public void setReference(String reference) {
        this.reference = reference;
    }


    public Document getDocument(String url) {
        Document document = null;
        try {
            Thread.sleep(30);
            document = Jsoup.connect(url).timeout(1000).get();
        } catch (IOException | InterruptedException e) {
            e.printStackTrace();
        }
        return document;
    }

    public int setNumberOfPages(Document document) {
        int numberOfPages = 0;
        if (document != null) {
            Elements elements = document.select(".b-pager");
            for (Element element : elements.select("a[href]")) {
                String href = element.attr("href");
                if (Integer.parseInt(href.split("&")[7].split("=")[1]) > numberOfPages) {
                    numberOfPages = Integer.parseInt(href.split("&")[7].split("=")[1]);
                }
            }
        }
        return numberOfPages;
    }

    public String getTextFromPage(Document document) {
        String textFromPage = null;
        Elements elements = document.select(".article_text_wrapper");
        for (Element element : elements) {
            System.out.println(element.text());
            System.out.println();
        }
        return textFromPage;
    }


    public void rootRound() {
        kommersantBuilder = new KommersantBuilder.Builder().kommersantUrl(startUrl).places("").categories("").datestart(dateStart).dateend(dateEnd).sortType("0").regions("").resultsCount("").page("1").searchQuery(Win1251.convertStringToWin1251(reference)).build();
        Document linkOnFirstPage = getDocument(kommersantBuilder.getResultSearchQuery());
        int numberOfPages = setNumberOfPages(linkOnFirstPage);

        if (numberOfPages > 0) {
            for (Integer i = 1; i <= numberOfPages; i++) {
                kommersantBuilder = new KommersantBuilder.Builder().kommersantUrl(startUrl).places("").categories("").datestart(dateStart).dateend(dateEnd).sortType("0").regions("").resultsCount("").page(i.toString()).searchQuery(Win1251.convertStringToWin1251(reference)).build();
                Document linkOnNewsPage = getDocument(kommersantBuilder.getResultSearchQuery());
                Elements elements = linkOnNewsPage.getElementsByClass("b-main-search-results__item");
                for (Element element : elements) {
//                    System.out.println(element.select(".b-main-search-results__src").text());
//                    System.out.println(element.select(".article_name").select("a[href]").attr("href"));
//                    System.out.println(element.select(".article_name").text());

                    String date = element.select(".b-main-search-results__src").text().split(" ")[element.select(".b-main-search-results__src").text().split(" ").length - 1];
                    String header = element.select(".article_name").text();

                    String href = element.select(".article_name").select("a[href]").attr("href");
                    Document linkOnIdNewsPage = getDocument(searchUrl + href);
                    if (linkOnIdNewsPage != null) {
                        System.out.println(getTextFromPage(linkOnIdNewsPage));
                    }

                    break;
                }

                break;
            }
        }


    }


}
