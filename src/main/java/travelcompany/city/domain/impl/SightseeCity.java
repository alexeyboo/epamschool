package travelcompany.city.domain.impl;

import travelcompany.city.domain.*;
import travelcompany.city.domain.typesofcities.Sightseeable;

public class SightseeCity extends City implements Sightseeable {
    private int numOfSights;

    public int getNumOfSights() {
        return numOfSights;
    }

    public void setNumOfSights(int numOfSights) {
        this.numOfSights = numOfSights;
    }

    @Override
    protected void initDiscriminator() {
        discriminator = CityDiscriminator.SIGHTSEE;
    }

    @Override
    public String toString() {
        return super.toString() +
                ", numOfSights=" + numOfSights + '\'';
    }
}
