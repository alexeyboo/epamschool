package travelcompany.country.domain;

import travelcompany.city.domain.City;
import travelcompany.common.business.domain.BaseDomain;

import java.util.List;

public class Country extends BaseDomain <Long> {
    private String name;
    private String language;
    private List<City> cities;

    public Country() {}

    public Country(String name, String language) {
        this.name = name;
        this.language = language;
    }

    public void setCities(List<City> cities) {
        this.cities = cities;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<City> getCities() {
        return cities;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLanguage() {
        return language;
    }

    public void setLanguage(String language) {
        this.language = language;
    }

    @Override
    public String toString() {
        return "\nCountry\n" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'' +
                ", \ncities:\n" + getCitiesAsStr();
    }

    private String getCitiesAsStr() {
        StringBuilder stringBuilder = new StringBuilder();
        for (City city : cities) {
            stringBuilder.append(city.toString()).append("\n");
        }
        return stringBuilder.toString();
    }
    public String getAsStrWithoutCities() {
        return "id=" + id +
                ", name='" + name + '\'' +
                ", language='" + language + '\'';
    }
}
