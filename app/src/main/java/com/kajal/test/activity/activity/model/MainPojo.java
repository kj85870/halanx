package com.kajal.test.activity.activity.model;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class MainPojo {
    private Integer count;
    private String  next;
    private String previous;
    @SerializedName("results")
    private ArrayList<ResultHouse> resultHouses;

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }

    public String getNext() {
        return next;
    }

    public void setNext(String next) {
        this.next = next;
    }

    public String getPrevious() {
        return previous;
    }

    public void setPrevious(String previous) {
        this.previous = previous;
    }

    public ArrayList<ResultHouse> getResultHouses() {
        return resultHouses;
    }

    public void setResultHouses(ArrayList<ResultHouse> resultHouses) {
        this.resultHouses = resultHouses;
    }
}
