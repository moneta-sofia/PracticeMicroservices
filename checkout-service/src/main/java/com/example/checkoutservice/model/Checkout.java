package com.example.checkoutservice.model;

import java.util.List;

public class Checkout {
    private String id;
    private String url;
    private String totalAmount;
    private List<String> avalibeMetods;


    public Checkout(String id, String url, String totalAmount, List<String> avalibeMetods) {
        this.id = id;
        this.url = url;
        this.totalAmount = totalAmount;
        this.avalibeMetods = avalibeMetods;
    }


    public Checkout(String id) {
        this.id = id;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getTotalAmount() {
        return totalAmount;
    }

    public void setTotalAmount(String totalAmount) {
        this.totalAmount = totalAmount;
    }

    public List<String> getAvalibeMetods() {
        return avalibeMetods;
    }

    public void setAvalibeMetods(List<String> avalibeMetods) {
        this.avalibeMetods = avalibeMetods;
    }
}
