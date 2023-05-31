package com.bogdan.projectWithAI.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;
import java.util.Map;

@Getter
@Setter
public class Country {

    private CountryName name;

    private List<String> tld;

    private String cca2;

    private String ccn3;

    private String cca3;

    private String cioc;

    private boolean independent;

    private String status;

    private boolean unMember;

    private Map<String, Map<String, String>> currencies;

    private CountryIdd idd;

    private List<String> capital;

    private List<String> altSpellings;

    private String region;

    private String subregion;

    private Map<String, String> languages;

    private Map<String, Map<String, String>> translations;

    private List<Double> latlng;

    private boolean landlocked;

    private List<String> borders;

    private double area;

    private Map<String, Map<String, String>> demonyms;

    private String flag;

    private Map<String, String> maps;

    private Long population;

    private Map<String, Double> gini;

    private String fifa;

    private CountryCar car;

    private List<String> timezones;

    private List<String> continents;

    private Map<String, String> flags;

    private Map<String, String> coatOfArms;

    private String startOfWeek;

    private Map<String, List<Double>> capitalInfo;

    private Map<String, String> postalCode;

    public static class CountryBuilder {
        private Country country;

        public CountryBuilder() {
            country = new Country();
        }

        public CountryBuilder withName(CountryName name) {
            country.name = name;
            return this;
        }

        public CountryBuilder withTld(List<String> tld) {
            country.tld = tld;
            return this;
        }

        public CountryBuilder withCca2(String cca2) {
            country.cca2 = cca2;
            return this;
        }

        public CountryBuilder withCcn3(String ccn3) {
            country.ccn3 = ccn3;
            return this;
        }

        public CountryBuilder withCca3(String cca3) {
            country.cca3 = cca3;
            return this;
        }

        public CountryBuilder withCioc(String cioc) {
            country.cioc = cioc;
            return this;
        }

        public CountryBuilder withIndependent(boolean independent) {
            country.independent = independent;
            return this;
        }

        public CountryBuilder withStatus(String status) {
            country.status = status;
            return this;
        }

        public CountryBuilder withUnMember(boolean unMember) {
            country.unMember = unMember;
            return this;
        }

        public CountryBuilder withCurrencies(Map<String, Map<String, String>> currencies) {
            country.currencies = currencies;
            return this;
        }

        public CountryBuilder withIdd(CountryIdd idd) {
            country.idd = idd;
            return this;
        }

        public CountryBuilder withCapital(List<String> capital) {
            country.capital = capital;
            return this;
        }

        public CountryBuilder withAltSpellings(List<String> altSpellings) {
            country.altSpellings = altSpellings;
            return this;
        }

        public CountryBuilder withRegion(String region) {
            country.region = region;
            return this;
        }

        public CountryBuilder withSubregion(String subregion) {
            country.subregion = subregion;
            return this;
        }

        public CountryBuilder withLanguages(Map<String, String> languages) {
            country.languages = languages;
            return this;
        }

        public CountryBuilder withTranslations(Map<String, Map<String, String>> translations) {
            country.translations = translations;
            return this;
        }

        public CountryBuilder withLatlng(List<Double> latlng) {
            country.latlng = latlng;
            return this;
        }

        public CountryBuilder withLandlocked(boolean landlocked) {
            country.landlocked = landlocked;
            return this;
        }

        public CountryBuilder withBorders(List<String> borders) {
            country.borders = borders;
            return this;
        }

        public CountryBuilder withArea(double area) {
            country.area = area;
            return this;
        }

        public CountryBuilder withDemonyms(Map<String, Map<String, String>> demonyms) {
            country.demonyms = demonyms;
            return this;
        }

        public CountryBuilder withFlag(String flag) {
            country.flag = flag;
            return this;
        }

        public CountryBuilder withMaps(Map<String, String> maps) {
            country.maps = maps;
            return this;
        }

        public CountryBuilder withPopulation(Long population) {
            country.population = population;
            return this;
        }

        public CountryBuilder withGini(Map<String, Double> gini) {
            country.gini = gini;
            return this;
        }

        public CountryBuilder withFifa(String fifa) {
            country.fifa = fifa;
            return this;
        }

        public CountryBuilder withCar(CountryCar car) {
            country.car = car;
            return this;
        }

        public CountryBuilder withTimezones(List<String> timezones) {
            country.timezones = timezones;
            return this;
        }

        public CountryBuilder withContinents(List<String> continents) {
            country.continents = continents;
            return this;
        }

        public CountryBuilder withFlags(Map<String, String> flags) {
            country.flags = flags;
            return this;
        }

        public CountryBuilder withCoatOfArms(Map<String, String> coatOfArms) {
            country.coatOfArms = coatOfArms;
            return this;
        }

        public CountryBuilder withStartOfWeek(String startOfWeek) {
            country.startOfWeek = startOfWeek;
            return this;
        }

        public CountryBuilder withCapitalInfo(Map<String, List<Double>> capitalInfo) {
            country.capitalInfo = capitalInfo;
            return this;
        }

        public CountryBuilder withPostalCode(Map<String, String> postalCode) {
            country.postalCode = postalCode;
            return this;
        }

        public Country build() {
            return country;
        }
    }
}