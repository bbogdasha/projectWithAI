package com.bogdan.projectWithAI.service;

import com.bogdan.projectWithAI.exception.CountriesParameterValidateException;
import com.bogdan.projectWithAI.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Pattern;

@Service
public class CountriesServiceImpl implements CountriesService {

    @Override
    public List<Country> getCountriesByName(List<Country> countries, String name) {
        boolean isValid = Pattern.matches("^[a-zA-Z]{1,36}$", name);

        if (!isValid) {
            throw new CountriesParameterValidateException("Invalid 'name' format. Only letters are allowed.");
        }

        return countries.stream()
                .filter(n -> n.getName().getCommon().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }

    @Override
    public List<Country> getCountryByPopulation(List<Country> countries, Long population) {
        boolean isValid = Pattern.matches("^[0-9]{1,4}$", population.toString());

        if (!isValid) {
            throw new CountriesParameterValidateException("Invalid 'population' format. Only numbers are allowed (max: 9999).");
        }

        return countries.stream()
                .filter(pop -> pop.getPopulation() < population * 1000000)
                .toList();
    }
}
