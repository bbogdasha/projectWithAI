package com.bogdan.projectWithAI.service;

import com.bogdan.projectWithAI.exception.CountriesParameterValidateException;
import com.bogdan.projectWithAI.model.Country;
import com.bogdan.projectWithAI.model.CountryName;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.mockito.InjectMocks;
import org.mockito.junit.jupiter.MockitoExtension;

import java.util.ArrayList;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
public class CountriesServiceTest {

    @InjectMocks
    private CountriesServiceImpl countriesService;

    private List<Country> countries;

    @BeforeEach
    public void init() {
        CountryName cName1 = new CountryName.CountryNameBuilder().withCommon("USA").build();
        CountryName cName2 = new CountryName.CountryNameBuilder().withCommon("Canada").build();
        CountryName cName3 = new CountryName.CountryNameBuilder().withCommon("Germany").build();

        Country country1 = new Country.CountryBuilder()
                .withName(cName1)
                .withPopulation(11000000L)
                .build();
        Country country2 = new Country.CountryBuilder()
                .withName(cName2)
                .withPopulation(5000000L)
                .build();
        Country country3 = new Country.CountryBuilder()
                .withName(cName3)
                .withPopulation(8000000L)
                .build();

        countries = new ArrayList<>();
        countries.add(country1);
        countries.add(country2);
        countries.add(country3);
    }

    @ParameterizedTest
    @CsvSource({"an, 2", "spp, 0"})
    public void testGetCountriesByName_ValidName(String name, int expectedSize) {
        List<Country> result = countriesService.getCountriesByName(countries, name);

        assertEquals(expectedSize, result.size());
        assertTrue(result.stream().allMatch(country ->
                country.getName().getCommon().toLowerCase().contains(name.toLowerCase())));
    }

    @ParameterizedTest
    @CsvSource({"123, Invalid 'name' format. Only letters are allowed.",
                "\"\", Invalid 'name' format. Only letters are allowed."})
    public void testGetCountriesByName_InvalidInputs(String name, String expectedErrorMessage) {
        Exception exception = assertThrows(CountriesParameterValidateException.class, () ->
                countriesService.getCountriesByName(countries, name));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"2, 0", "6, 1", "12, 3"})
    public void testGetCountriesByPopulation_ValidPopulation(String population, int expectedSize) {
        List<Country> result = countriesService.getCountriesByPopulation(countries, population);

        assertEquals(expectedSize, result.size());
        assertTrue(result.stream().allMatch(country ->
                country.getPopulation() < Long.parseLong(population) * 1000000));
    }

    @ParameterizedTest
    @CsvSource({"abc, Invalid 'population' format. Only numbers are allowed (max: 9999).",
                "10000, Invalid 'population' format. Only numbers are allowed (max: 9999).",
                "123456, Invalid 'population' format. Only numbers are allowed (max: 9999)."})
    public void testGetCountriesByPopulation_InvalidPopulation(String population, String expectedErrorMessage) {
        Exception exception = assertThrows(CountriesParameterValidateException.class, () ->
                countriesService.getCountriesByPopulation(countries, population));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"asc, true", "desc, true"})
    public void testSortCountriesByOrder_ValidOrder(String order, boolean isSorted) {
        List<Country> result = countriesService.sortCountriesByOrder(countries, order);

        boolean check = isSorted(result, order);

        assertEquals(isSorted, check);
    }

    @ParameterizedTest
    @CsvSource({"invalid, Invalid 'order' format. Only 'asc' or 'desc' are allowed.",
                "123, Invalid 'order' format. Only 'asc' or 'desc' are allowed.",
                "abc, Invalid 'order' format. Only 'asc' or 'desc' are allowed."})
    public void testSortCountriesByOrder_InvalidOrder(String order, String expectedErrorMessage) {
        Exception exception = assertThrows(CountriesParameterValidateException.class, () ->
                countriesService.sortCountriesByOrder(countries, order));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    @ParameterizedTest
    @CsvSource({"1, 1", "2, 2", "3, 3", "123, 3"})
    public void testLimitCountries_ValidSize(String size, String expected) {
        List<Country> result = countriesService.limitCountries(countries, size);

        assertEquals(Integer.parseInt(expected), result.size());
        assertTrue(countries.containsAll(result));
    }

    @ParameterizedTest
    @CsvSource({"invalid, Invalid 'size' format. Only numbers are allowed (max: 9999).",
                "abc, Invalid 'size' format. Only numbers are allowed (max: 9999)."})
    public void testLimitCountries_InvalidSize(String size, String expectedErrorMessage) {
        Exception exception = assertThrows(CountriesParameterValidateException.class, () ->
                countriesService.limitCountries(countries, size));
        assertEquals(expectedErrorMessage, exception.getMessage());
    }

    private boolean isSorted(List<Country> countries, String order) {
        if (order.equals("asc")) {
            for (int i = 0; i < countries.size() - 1; i++) {
                if (countries.get(i).getName().getCommon().compareTo(countries.get(i + 1).getName().getCommon()) > 0) {
                    return false;
                }
            }
        } else if (order.equals("desc")) {
            for (int i = 0; i < countries.size() - 1; i++) {
                if (countries.get(i).getName().getCommon().compareTo(countries.get(i + 1).getName().getCommon()) < 0) {
                    return false;
                }
            }
        }
        return true;
    }
}
