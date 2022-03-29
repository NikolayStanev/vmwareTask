package com.example.vmware.rest;

import java.math.BigDecimal;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 17:06
 * To change this template use File | Settings | File Templates.
 */
public class Request {

    private String country;
    private BigDecimal budget;
    private BigDecimal totalBudget;
    private String currency;


    public Request() {
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public BigDecimal getBudget() {
        return budget;
    }

    public void setBudget(BigDecimal budget) {
        this.budget = budget;
    }

    public BigDecimal getTotalBudget() {
        return totalBudget;
    }

    public void setTotalBudget(BigDecimal totalBudget) {
        this.totalBudget = totalBudget;
    }

    public String getCurrency() {
        return currency;
    }

    public void setCurrency(String currency) {
        this.currency = currency;
    }

    @Override
    public String toString() {
        return "Request{" +
                "country='" + country + '\'' +
                ", budget=" + budget +
                ", totalBudget=" + totalBudget +
                ", currency='" + currency + '\'' +
                '}';
    }
}
