package com.example.vmware.rest;

import java.util.HashMap;

/**
 * Created with IntelliJ IDEA.
 * User: nikolay.stanev
 * Date: 26.3.2022 г.
 * Time: 21:28
 * To change this template use File | Settings | File Templates.
 */
public class ExchangeRate {

    private boolean success;
    private String base;
    private String date;
    private double result;
    private HashMap<String,Double> rates;

    public ExchangeRate() {
    }

    public ExchangeRate(boolean success, String base, String date, double result) {
        this.success = success;
        this.base = base;
        this.date = date;
        this.result = result;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public double getResult() {
        return result;
    }

    public void setResult(double result) {
        this.result = result;
    }

    public HashMap<String, Double> getRates() {
        return rates;
    }

    public void setRates(HashMap<String, Double> rates) {
        this.rates = rates;
    }

    @Override
    public String toString() {
        return "ExchangeRate{" +
                "success=" + success +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", result=" + result +
                ", rates=" + rates +
                '}';
    }
}
