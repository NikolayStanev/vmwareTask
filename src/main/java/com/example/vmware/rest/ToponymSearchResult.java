package com.example.vmware.rest;

import org.geonames.Style;

import java.util.ArrayList;
import java.util.List;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 23:07
 * To change this template use File | Settings | File Templates.
 */
public class ToponymSearchResult {

    //I had to rebuild this class even tho I have it in the jar
    // because it was not full(wrong attribute names). Object mapper could not map correctly.

    List<Toponym> geonames = new ArrayList<Toponym>();

    int totalResultsCount;

    Style style;

    public ToponymSearchResult() {
    }

    public List<Toponym> getGeonames() {
        return geonames;
    }

    public void setGeonames(List<Toponym> geonames) {
        this.geonames = geonames;
    }

    public int getTotalResultsCount() {
        return totalResultsCount;
    }

    public void setTotalResultsCount(int totalResultsCount) {
        this.totalResultsCount = totalResultsCount;
    }

    public Style getStyle() {
        return style;
    }

    public void setStyle(Style style) {
        this.style = style;
    }

    @Override
    public String toString() {
        return "ToponymSearchResult{" +
                "geonames=" + geonames +
                ", totalResultsCount=" + totalResultsCount +
                ", style=" + style +
                '}';
    }
}
