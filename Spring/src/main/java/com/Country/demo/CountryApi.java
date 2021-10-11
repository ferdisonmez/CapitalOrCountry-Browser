package com.Country.demo;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.io.File;
import java.io.IOException;
import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/country")
public class CountryApi {

    @GetMapping("/list")
    public ResponseEntity<?> CountryShow() throws IOException {
        final ObjectMapper objectMapper = new ObjectMapper();
        List<Country> langList = objectMapper.readValue(new File("src/main/resources/static/restcountries.json"), new TypeReference<List<Country>>(){});
        for (int i = 0; i <langList.size(); i++) {
            if(langList.get(i).getCapital()==null ||langList.get(i).getCapital()==" "){
                langList.get(i).setCapital("A");
            }
        }
        return ResponseEntity.ok(langList);
    }

}
