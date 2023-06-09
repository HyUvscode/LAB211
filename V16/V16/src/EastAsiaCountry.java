/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 * The EastAsiaCountry class represents a country in East Asia and extends the base Country class.
 * It adds an additional property for country terrain.
 *
 * @author NGMINHAT
 */
public class EastAsiaCountry extends Country {

    private String countryTerrain;

    /**
     * Constructs an EastAsiaCountry object with the specified attributes.
     *
     * @param countryCode the country code
     * @param countryName the country name
     * @param totalArea the total area of the country
     * @param countryTerrain the terrain of the country
     */
    public EastAsiaCountry(String countryCode, String countryName, float totalArea, String countryTerrain) {
        super(countryCode, countryName, totalArea);
        this.countryTerrain = countryTerrain;
    }

    /**
     * Gets the terrain of the country.
     *
     * @return the country terrain
     */
    public String getCountryTerrain() {
        return countryTerrain;
    }

    /**
     * Displays the country information.
     */
    @Override
    public void display() {
        super.display();
        System.out.format("%-15s\n", getCountryTerrain());
        System.out.println();
    }
}
