package com.bogdan.projectWithAI.model;

import lombok.Getter;
import lombok.Setter;

import java.util.Map;

@Getter
@Setter
public class CountryName {

    private String common;

    private String official;

    private Map<String, Map<String, String>> nativeName;

    public static class CountryNameBuilder {
        private CountryName countryName;

        public CountryNameBuilder() {
            countryName = new CountryName();
        }

        public CountryNameBuilder withCommon(String common) {
            countryName.common = common;
            return this;
        }

        public CountryNameBuilder withOfficial(String official) {
            countryName.official = official;
            return this;
        }

        public CountryNameBuilder withNativeName(Map<String, Map<String, String>> nativeName) {
            countryName.nativeName = nativeName;
            return this;
        }

        public CountryName build() {
            return countryName;
        }
    }
}
