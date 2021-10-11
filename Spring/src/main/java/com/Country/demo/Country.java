package com.Country.demo;
import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import lombok.Data;

import java.util.List;

@Data
@JsonIgnoreProperties(ignoreUnknown = true)
public class Country {
    String name;
    private List<String> topLevelDomain;
    private String alpha2Code;
    private String alpha3Code;
    private List<String> callingCodes;
    private String capital;
    private List<String> altSpellings;

    private String region;

    private String subregion;

    private Integer population;

    private List<Double> latlng;

    private String demonym;

    private String area;

    private String gini;

    private List<String> timezones;

    private List<String> borders;

    private String nativeName;

    private String numericCode;
    private List<Currency> currencies;
    private List<Language> languages;
    private Translation translations;
    private String flag;
    private List<RegionalBloc> regionalBlocs;
    private String cioc;



}
