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
}