package com.bogdan.projectWithAI.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryIdd {

    private String root;

    private List<String> suffixes;

    public static class CountryIddBuilder {
        private CountryIdd countryIdd;

        public CountryIddBuilder() {
            countryIdd = new CountryIdd();
        }

        public CountryIddBuilder withRoot(String root) {
            countryIdd.root = root;
            return this;
        }

        public CountryIddBuilder withSuffixes(List<String> suffixes) {
            countryIdd.suffixes = suffixes;
            return this;
        }

        public CountryIdd build() {
            return countryIdd;
        }
    }
}
