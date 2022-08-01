package br.com.visualnuts.test.countrylanguages;

import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.function.Function;
import java.util.stream.Collectors;

public class CountryLanguages {

    private List<Country> countries;

    public CountryLanguages(List<Country> countries) {
        this.countries = countries;
    }

    public long getNumberOfCountriesInTheWorld()  {

        return countries
                .stream()
                .map(Country::getCountry)
                .distinct()
                .count();
    }

    public String findCountryWithMostOfficialLanguages(String language) {
        this.countries = countries
                .stream()
                .filter(country -> country.getLanguages().contains(language))
                .collect(Collectors.toList());

        return findCountryWithMostOfficialLanguages();
    }

    public String findCountryWithMostOfficialLanguages() {

        int maxOfficialLanguages = 0;
        String countryWithMostOfficialLanguages = "";


        for (Country country: countries) {

            int quantityOfLanguages = country.getLanguages().size();
            if ( quantityOfLanguages > maxOfficialLanguages) {
                maxOfficialLanguages = quantityOfLanguages;
                countryWithMostOfficialLanguages = country.getCountry();
            }

        }

        return countryWithMostOfficialLanguages;

    }

    public long countOfficialLanguages() {
        return this.countries
                .stream()
                .map(Country::getLanguages)
                .flatMap(Collection::stream)
                .distinct()
                .count();

    }

    public String findMostCommonOfficialLanguage() {
        Map<String, Long> map = this.countries
                .stream()
                .map(Country::getLanguages)
                .flatMap(Collection::stream)
                .collect(
                        Collectors.groupingBy(
                                Function.identity(), Collectors.counting()
                        )
                );

        Map.Entry<String, Long> maxEntry = null;

        for (Map.Entry<String, Long> entry : map.entrySet()){
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0){
                maxEntry = entry;
            }
        }

        return maxEntry.getKey();

    }

}
