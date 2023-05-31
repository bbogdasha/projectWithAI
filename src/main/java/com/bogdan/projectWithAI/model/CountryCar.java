package com.bogdan.projectWithAI.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryCar {

    private List<String> signs;

    private String side;

    public static class CountryCarBuilder {
        private CountryCar countryCar;

        public CountryCarBuilder() {
            countryCar = new CountryCar();
        }

        public CountryCarBuilder withSigns(List<String> signs) {
            countryCar.signs = signs;
            return this;
        }

        public CountryCarBuilder withSide(String side) {
            countryCar.side = side;
            return this;
        }

        public CountryCar build() {
            return countryCar;
        }
    }
}
