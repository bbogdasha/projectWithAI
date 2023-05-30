package com.bogdan.projectWithAI.service;

import com.bogdan.projectWithAI.exception.CountriesParameterValidateException;
import com.bogdan.projectWithAI.model.Country;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

@Service
public class CountriesServiceImpl implements CountriesService {

    @Override
    public List<Country> getCountriesByName(List<Country> countries, String name) {
        Pattern pattern = Pattern.compile("^[a-zA-Z]{1,36}$");
        Matcher matcher = pattern.matcher(name);

        if (!matcher.matches()) {
            throw new CountriesParameterValidateException("Invalid name format. Only letters are allowed.");
        }

        return countries.stream()
                .filter(n -> n.getName().getCommon().toLowerCase().contains(name.toLowerCase()))
                .toList();
    }
}
