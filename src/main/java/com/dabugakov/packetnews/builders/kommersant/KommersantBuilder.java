package com.dabugakov.packetnews.builders.kommersant;

/**
 * Created by DABugakov on 17.11.2015.
 */
public class KommersantBuilder {

    private String kommersantUrl;
    private String places;
    private String categories;
    private String datestart;
    private String dateend;
    private String sortType;
    private String regions;
    private String resultsCount;
    private String page;
    private String searchQuery;


    public static class Builder {
        private String kommersantUrl ="";
        private String places = "places=";
        private String categories = "categories=";
        private String datestart = "datestart=";
        private String dateend = "dateend=";
        private String sortType = "sort_type=";
        private String regions = "regions=";
        private String resultsCount = "results_count=";
        private String page = "page=";
        private String searchQuery = "search_query=";

        public Builder kommersantUrl(String val){
            kommersantUrl = val;
            return this;
        }

        public Builder places(String val) {
            places += val;
            return this;
        }

        public Builder categories(String val) {
            categories += val;
            return this;
        }

        public Builder datestart(String val) {
            datestart += val;
            return this;
        }

        public Builder dateend(String val) {
            dateend += val;
            return this;
        }

        public Builder sortType(String val) {
            sortType += val;
            return this;
        }

        public Builder regions(String val) {
            regions += val;
            return this;
        }

        public Builder resultsCount(String val) {
            resultsCount += val;
            return this;
        }

        public Builder page(String val) {
            page += val;
            return this;
        }

        public Builder searchQuery(String val) {
            searchQuery += val;
            return this;
        }

        public KommersantBuilder build() {
            return new KommersantBuilder(this);
        }
    }

    private KommersantBuilder(Builder builder) {
        kommersantUrl = builder.kommersantUrl;
        places = builder.places;
        categories = builder.categories;
        datestart = builder.datestart;
        dateend = builder.dateend;
        sortType = builder.sortType;
        regions = builder.regions;
        resultsCount = builder.resultsCount;
        page = builder.page;
        searchQuery = builder.searchQuery;
    }

    public String getResultSearchQuery() {
        return  this.kommersantUrl +
                "Results?" +
                this.places + "&" +
                this.categories + "&" +
                this.datestart + "&" +
                this.dateend + "&" +
                this.sortType + "&" +
                this.regions + "&" +
                this.resultsCount + "&" +
                this.page + "&" +
                this.searchQuery;
    }
}
