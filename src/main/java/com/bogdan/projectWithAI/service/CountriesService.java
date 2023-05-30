package com.bogdan.projectWithAI.service;

import com.bogdan.projectWithAI.model.Country;

import java.util.List;

public interface CountriesService {

    List<Country> getCountriesByName(List<Country> countries, String name);
}
