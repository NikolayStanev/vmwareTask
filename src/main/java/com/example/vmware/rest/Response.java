package com.example.vmware.rest;

import org.geonames.ToponymSearchResult;

import java.math.BigDecimal;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 17:13
 * To change this template use File | Settings | File Templates.
 */
public class Response {

    private BigDecimal travelCount;
    private BigDecimal budgetLeftover;
    private Map<String,String> moneyRequiredPerCountry;

    public Response(BigDecimal travelCount, BigDecimal budgetLeftover, Map<String,String> moneyRequiredPerCountry) {
        this.travelCount = travelCount;
        this.budgetLeftover = budgetLeftover;
        this.moneyRequiredPerCountry = moneyRequiredPerCountry;
    }

    public BigDecimal getTravelCount() {
        return travelCount;
    }

    public void setTravelCount(BigDecimal travelCount) {
        this.travelCount = travelCount;
    }

    public BigDecimal getBudgetLeftover() {
        return budgetLeftover;
    }

    public void setBudgetLeftover(BigDecimal budgetLeftover) {
        this.budgetLeftover = budgetLeftover;
    }

    public Map<String,String> getMoneyRequiredPerCountry() {
        return moneyRequiredPerCountry;
    }

    public void setMoneyRequiredPerCountry(Map<String,String> moneyRequiredPerCountry) {
        this.moneyRequiredPerCountry = moneyRequiredPerCountry;
    }
}
