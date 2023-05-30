package com.bogdan.projectWithAI.service;

import com.bogdan.projectWithAI.model.Country;

import java.util.List;

public interface CountriesService {

    List<Country> getCountriesByName(List<Country> countries, String name);

    List<Country> getCountriesByPopulation(List<Country> countries, String population);

    List<Country> sortCountriesByOrder(List<Country> countries, String order);

    List<Country> limitCountries(List<Country> countries, String size);
}
