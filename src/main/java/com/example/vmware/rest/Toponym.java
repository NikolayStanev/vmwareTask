package com.example.vmware.rest;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 23:16
 * To change this template use File | Settings | File Templates.
 */
public class Toponym {

    //I had to rebuild this class even tho I have it in the jar
    // because it was not full(wrong attribute names). Object mapper could not map correctly.

    private String lng;
    private int geonameId;
    private String toponymName;
    private String countryId;
    private String fcl;
    private int population;
    private String countryCode;
    private String name;
    private String fclName;
    private String countryName;
    private String fcodeName;
    private String adminCode1;
    private String adminName1;
    private String lat;
    private String fcode;
    private String capital;
    private String continent;
    private String languages;
    private String south;
    private String isoAlpha3;
    private double north;
    private String fipsCode;
    private double east;
    private String isoNumeric;
    private String areaInSqKm;
    private double west;
    private String postalCodeFormat;
    private String continentName;
    private String currencyCode;

    public Toponym() {
    }

    public String getLng() {
        return lng;
    }

    public void setLng(String lng) {
        this.lng = lng;
    }

    public int getGeonameId() {
        return geonameId;
    }

    public void setGeonameId(int geonameId) {
        this.geonameId = geonameId;
    }

    public String getToponymName() {
        return toponymName;
    }

    public void setToponymName(String toponymName) {
        this.toponymName = toponymName;
    }

    public String getCountryId() {
        return countryId;
    }

    public void setCountryId(String countryId) {
        this.countryId = countryId;
    }

    public String getFcl() {
        return fcl;
    }

    public void setFcl(String fcl) {
        this.fcl = fcl;
    }

    public int getPopulation() {
        return population;
    }

    public void setPopulation(int population) {
        this.population = population;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFclName() {
        return fclName;
    }

    public void setFclName(String fclName) {
        this.fclName = fclName;
    }

    public String getFcodeName() {
        return fcodeName;
    }

    public void setFcodeName(String fcodeName) {
        this.fcodeName = fcodeName;
    }

    public String getAdminCode1() {
        return adminCode1;
    }

    public void setAdminCode1(String adminCode1) {
        this.adminCode1 = adminCode1;
    }

    public String getAdminName1() {
        return adminName1;
    }

    public void setAdminName1(String adminName1) {
        this.adminName1 = adminName1;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getFcode() {
        return fcode;
    }

    public void setFcode(String fcode) {
        this.fcode = fcode;
    }

    public String getCountryName() {
        return countryName;
    }

    public void setCountryName(String countryName) {
        this.countryName = countryName;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getContinent() {
        return continent;
    }

    public void setContinent(String continent) {
        this.continent = continent;
    }

    public String getLanguages() {
        return languages;
    }

    public void setLanguages(String languages) {
        this.languages = languages;
    }

    public String getSouth() {
        return south;
    }

    public void setSouth(String south) {
        this.south = south;
    }

    public String getIsoAlpha3() {
        return isoAlpha3;
    }

    public void setIsoAlpha3(String isoAlpha3) {
        this.isoAlpha3 = isoAlpha3;
    }

    public double getNorth() {
        return north;
    }

    public void setNorth(double north) {
        this.north = north;
    }

    public String getFipsCode() {
        return fipsCode;
    }

    public void setFipsCode(String fipsCode) {
        this.fipsCode = fipsCode;
    }

    public double getEast() {
        return east;
    }

    public void setEast(double east) {
        this.east = east;
    }

    public String getIsoNumeric() {
        return isoNumeric;
    }

    public void setIsoNumeric(String isoNumeric) {
        this.isoNumeric = isoNumeric;
    }

    public String getAreaInSqKm() {
        return areaInSqKm;
    }

    public void setAreaInSqKm(String areaInSqKm) {
        this.areaInSqKm = areaInSqKm;
    }

    public double getWest() {
        return west;
    }

    public void setWest(double west) {
        this.west = west;
    }

    public String getPostalCodeFormat() {
        return postalCodeFormat;
    }

    public void setPostalCodeFormat(String postalCodeFormat) {
        this.postalCodeFormat = postalCodeFormat;
    }

    public String getContinentName() {
        return continentName;
    }

    public void setContinentName(String continentName) {
        this.continentName = continentName;
    }

    public String getCurrencyCode() {
        return currencyCode;
    }

    public void setCurrencyCode(String currencyCode) {
        this.currencyCode = currencyCode;
    }

    @Override
    public String toString() {
        return "Toponym{" +
                "lng='" + lng + '\'' +
                ", geonameId=" + geonameId +
                ", toponymName='" + toponymName + '\'' +
                ", countryId='" + countryId + '\'' +
                ", fcl='" + fcl + '\'' +
                ", population=" + population +
                ", countryCode='" + countryCode + '\'' +
                ", name='" + name + '\'' +
                ", fclName='" + fclName + '\'' +
                ", countryName='" + countryName + '\'' +
                ", fcodeName='" + fcodeName + '\'' +
                ", adminCode1='" + adminCode1 + '\'' +
                ", adminName1='" + adminName1 + '\'' +
                ", lat='" + lat + '\'' +
                ", fcode='" + fcode + '\'' +
                ", capital='" + capital + '\'' +
                ", continent='" + continent + '\'' +
                ", languages='" + languages + '\'' +
                ", south='" + south + '\'' +
                ", isoAlpha3='" + isoAlpha3 + '\'' +
                ", north=" + north +
                ", fipsCode='" + fipsCode + '\'' +
                ", east=" + east +
                ", isoNumeric='" + isoNumeric + '\'' +
                ", areaInSqKm='" + areaInSqKm + '\'' +
                ", west=" + west +
                ", postalCodeFormat='" + postalCodeFormat + '\'' +
                ", continentName='" + continentName + '\'' +
                ", currencyCode='" + currencyCode + '\'' +
                '}';
    }
}
