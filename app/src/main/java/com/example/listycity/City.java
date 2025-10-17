package com.example.listycity;

/**
 * This is a class that defines a City.
 */
public class City implements Comparable<City> {
    private String city;
    private String province;

    /**
     * Creates a new city object
     * @param city the name of the city
     * @param province the province the city belongs to
     */
    public City(String city, String province) {
        this.city = city;
        this.province = province;
    }

    /**
     * Gets the city name
     * @return the city name
     */
    public String getCity() {
        return city;
    }

    /**
     * Gets the province name
     * @return the province name
     */
    public String getProvinceName() {
        return province;
    }

    @Override
    /** This method compares cities based on their name
     * @return comparison result
     */
    public int compareTo(City o) {
        return this.city.compareTo(o.getCity());
    }

    @Override
    public boolean equals(Object obj) {
        if (!(obj instanceof City)) return false;
        City other = (City) obj;
        return this.city.equals(other.city) && this.province.equals(other.province);
    }

    @Override
    public int hashCode() {
        return (city + province).hashCode();
    }
}
