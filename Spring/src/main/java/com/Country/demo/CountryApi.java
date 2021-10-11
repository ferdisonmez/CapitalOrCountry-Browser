package com.Country.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200",maxAge = 3600)
@RequestMapping("/country")
public class CountryApi {

    @GetMapping("/lıst")
    public ResponseEntity<?> CountryShow() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Country> langList = objectMapper.readValue(new File("src/main/resources/static/restcountries.json"), new TypeReference<List<Country>>(){});
        langList.forEach(x -> System.out.println(x.toString()));
        return ResponseEntity.ok(langList);
    }

}
