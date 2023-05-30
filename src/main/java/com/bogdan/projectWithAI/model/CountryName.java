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
}
