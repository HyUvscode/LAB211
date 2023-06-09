
/**
 * Represents a country with its country code, name, and total area.
 */
public class Country {

    private String countryCode;
    private String countryName;
    private float totalArea;

    /**
     * Default constructor.
     */
    public Country() {
    }

    /**
     * Parameterized constructor.
     *
     * @param countryCode the country code
     * @param countryName the country name
     * @param totalArea the total area of the country
     */
    public Country(String countryCode, String countryName, float totalArea) {
        this.countryCode = countryCode;
        this.countryName = countryName;
        this.totalArea = totalArea;
    }

    /**
     * Gets the country code.
     *
     * @return the country code
     */
    public String getCountryCode() {
        return countryCode;
    }

    /**
     * Sets the country code.
     *
     * @param countryCode the country code to set
     */
    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    /**
     * Gets the country name.
     *
     * @return the country name
     */
    public String getCountryName() {
        return countryName;
    }

    /**
     * Sets the country name.
     *
     * @param countryName the country name to set
     */
    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    /**
     * Gets the total area of the country.
     *
     * @return the total area of the country
     */
    public float getTotalArea() {
        return totalArea;
    }

    /**
     * Sets the total area of the country.
     *
     * @param totalArea the total area to set
     */
    public void setTotalArea(float totalArea) {
        this.totalArea = totalArea;
    }

    /**
     * Displays the country information.
     */
    public void display() {
        System.out.format("%-15s %-15s %-16s", getCountryCode(), getCountryName(), getTotalArea());
    }
}
