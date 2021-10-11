package com.Country.demo;

import java.util.ArrayList;
import java.util.List;

public class RegionalBloc {
    private String acronym;
    private String name;
    private List<String> otherAcronyms;
    private List<String> otherNames;

    public String getAcronym() {
        return acronym;
    }

    public String getName() {
        return name;
    }

    public List<String> getOtherAcronyms() {
        if (otherAcronyms == null) {
            otherAcronyms = new ArrayList<>();
        }
        return otherAcronyms;
    }

    public List<String> getOtherNames() {
        if (otherNames == null) {
            otherNames = new ArrayList<>();
        }
        return otherNames;
    }
}
