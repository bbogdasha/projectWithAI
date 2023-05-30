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
    public List<Country> getCountriesByPopulation(List<Country> countries, String population) {
        boolean isValid = Pattern.matches("^[0-9]{1,4}$", population);

        if (!isValid) {
            throw new CountriesParameterValidateException("Invalid 'population' format. Only numbers are allowed (max: 9999).");
        }

        return countries.stream()
                .filter(pop -> pop.getPopulation() < Long.parseLong(population) * 1000000)
                .toList();
    }

    @Override
    public List<Country> sortCountriesByOrder(List<Country> countries, String order) {
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

    @Override
    public List<Country> limitCountries(List<Country> countries, String size) {
        boolean isValid = Pattern.matches("^[0-9]{1,4}$", size);

        if (!isValid) {
            throw new CountriesParameterValidateException("Invalid 'size' format. Only numbers are allowed (max: 9999).");
        }

        int dataSize = countries.size();
        int endIndex = Math.min(Integer.parseInt(size), dataSize);

        return countries.subList(0, endIndex);
    }
}
