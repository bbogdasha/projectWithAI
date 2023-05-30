package com.bogdan.projectWithAI.controller;

import com.bogdan.projectWithAI.model.Country;
import com.bogdan.projectWithAI.service.CountriesServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.util.ArrayList;
import java.util.List;

@RestController
public class CountriesController {

    private final String BASE_URL = "https://restcountries.com/v3.1/all";

    private final CountriesServiceImpl countriesService;

    @Autowired
    public CountriesController(CountriesServiceImpl countriesService) {
        this.countriesService = countriesService;
    }

    @GetMapping("/countries")
    @ResponseBody
    private ResponseEntity<List<Country>> getCountries(@RequestParam(required = false, name = "name") String name,
                                                       @RequestParam(required = false, name = "pop") Long population,
                                                       @RequestParam(required = false, name = "order") String order,
                                                       @RequestParam(required = false, name = "limit") Integer limit) {
        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<List<Country>> response = restTemplate.exchange(BASE_URL, HttpMethod.GET, null,
                new ParameterizedTypeReference<>() {});

        List<Country> countries = response.getBody();
        if (countries == null) {
            return new ResponseEntity<>(new ArrayList<>(), HttpStatus.NOT_FOUND);
        }

        if (name != null) {
            countries = countriesService.getCountriesByName(countries, name);
        }

        return !countries.isEmpty()
                ? new ResponseEntity<>(countries, HttpStatus.OK)
                : new ResponseEntity<>(countries, HttpStatus.NOT_FOUND);
    }
}
