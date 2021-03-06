package travelcompany.city.domain;

import travelcompany.common.business.domain.BaseDomain;
import travelcompany.country.domain.Country;

public abstract class City extends BaseDomain <Long>{
    protected String name;
    protected int population;
    protected boolean isCapital;
    protected Climate climate;
    protected CityDiscriminator discriminator;
    protected Long countryId;

    public Long getCountryId() {
        return countryId;
    }

    public void setCountryId(Long countryId) {
        this.countryId = countryId;
    }

    public City() {
        initDiscriminator();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public boolean getIsCapital() {
        return isCapital;
    }

    public void setIsCapital(boolean isCapital) {
        this.isCapital = isCapital;
    }

    public Climate getClimate() {
        return climate;
    }

    public void setClimate(Climate climate) {
        this.climate = climate;
    }

    public CityDiscriminator getDiscriminator() {
        return discriminator;
    }

    @Override
    public String toString() {
        return discriminator +
                "id=" + id +
                ", name='" + name + '\'' +
                ", isCapital=" + isCapital +
                ", population=" + population +
                ", climate=" + climate;
    }

    protected abstract void initDiscriminator();
}
