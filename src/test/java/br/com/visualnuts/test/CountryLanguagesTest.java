package br.com.visualnuts.test;

import br.com.visualnuts.test.countrylanguages.Country;
import br.com.visualnuts.test.countrylanguages.CountryLanguages;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;

import static org.springframework.test.util.AssertionErrors.assertEquals;

public class CountryLanguagesTest {

    private List<Country> countries;

    @BeforeEach
    public void setUp() throws IOException {
        String resourceName = "countrys.json";

        ClassLoader classLoader = getClass().getClassLoader();
        File file = new File(classLoader.getResource(resourceName).getFile());
        ObjectMapper objectMapper = new ObjectMapper();
        this.countries = objectMapper.readValue(file, new TypeReference<List<Country>>() {});

    }

    @Test
    public void getCountryNumbersInTheWorld() {

        CountryLanguages countryLanguages = new CountryLanguages(countries);
        long numberOfCountries = countryLanguages.getNumberOfCountriesInTheWorld();

        assertEquals(null, 5l, numberOfCountries);
    }

    @Test
    public void findCountryWithMostOfficialLanguagesWhereTheySpeakDE() {

        CountryLanguages countryLanguages = new CountryLanguages(countries);
        String countryWithMostOfficialLanguages = countryLanguages.findCountryWithMostOfficialLanguages("de");

        assertEquals(null, "BE", countryWithMostOfficialLanguages);
    }

    @Test
    public void countOfficialLanguages() {

        CountryLanguages countryLanguages = new CountryLanguages(countries);
        long officialLanguages = countryLanguages.countOfficialLanguages();
        assertEquals(null, 6l, officialLanguages);

    }

    @Test
    public void findCountryWithMostOfficialLanguages() {

        CountryLanguages countryLanguages = new CountryLanguages(countries);
        String countryWithMostOfficialLanguages = countryLanguages.findCountryWithMostOfficialLanguages();

        assertEquals(null, "BE", countryWithMostOfficialLanguages);
    }

    @Test
    public void findMostCommonOfficialLanguage() {

        CountryLanguages countryLanguages = new CountryLanguages(countries);
        String mostCommonOfficialLanguage = countryLanguages.findMostCommonOfficialLanguage();

        assertEquals(null, "de", mostCommonOfficialLanguage);
    }

}
