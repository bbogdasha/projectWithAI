package com.bogdan.projectWithAI.service;

import com.bogdan.projectWithAI.exception.CountriesParameterValidateException;
import com.bogdan.projectWithAI.model.Country;
import org.springframework.stereotype.Service;

import java.util.Comparator;
import java.util.List;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

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

    @Override
    public List<Country> sortCountryByOrder(List<Country> countries, String order) {
        if (!order.equals("asc") && !order.equals("desc")) {
            throw new CountriesParameterValidateException("Invalid 'order' format. Only 'asc' or 'desc' are allowed.");
        }

        Comparator<Country> comparator = Comparator.comparing(c -> c.getName().getCommon());

        if (order.equals("desc")) {
            comparator = comparator.reversed();
        }

        return countries.stream()
                .sorted(comparator)
                .collect(Collectors.toList());
    }
}
