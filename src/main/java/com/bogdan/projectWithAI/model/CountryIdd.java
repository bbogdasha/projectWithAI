package com.bogdan.projectWithAI.model;

import lombok.Getter;
import lombok.Setter;

import java.util.List;

@Getter
@Setter
public class CountryIdd {

    private String root;

    private List<String> suffixes;
}
