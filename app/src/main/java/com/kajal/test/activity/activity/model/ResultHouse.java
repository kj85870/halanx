package com.kajal.test.activity.activity.model;

import java.util.ArrayList;

public class ResultHouse {
    private Integer id;
    private String name;
    private ArrayList<Address> addresses;
    private String description;
    private String furnish_type;
    private String house_size;
    private String cover_pic_url;
    private Integer rent_from;
    private Integer security_deposit_from;
    private Integer available_flat_count;
    private Integer available_room_count;
    private Integer available_bed_count;
    private String accomodation_allowed_str;
    private String house_type;
    private String available_from;
    private Boolean favorited;


    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<Address> getAddresses() {
        return addresses;
    }

    public void setAddresses(ArrayList<Address> addresses) {
        this.addresses = addresses;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getFurnish_type() {
        return furnish_type;
    }

    public void setFurnish_type(String furnish_type) {
        this.furnish_type = furnish_type;
    }

    public String getHouse_size() {
        return house_size;
    }

    public void setHouse_size(String house_size) {
        this.house_size = house_size;
    }

    public String getCover_pic_url() {
        return cover_pic_url;
    }

    public void setCover_pic_url(String cover_pic_url) {
        this.cover_pic_url = cover_pic_url;
    }

    public Integer getRent_from() {
        return rent_from;
    }

    public void setRent_from(Integer rent_from) {
        this.rent_from = rent_from;
    }

    public Integer getSecurity_deposit_from() {
        return security_deposit_from;
    }

    public void setSecurity_deposit_from(Integer security_deposit_from) {
        this.security_deposit_from = security_deposit_from;
    }

    public Integer getAvailable_flat_count() {
        return available_flat_count;
    }

    public void setAvailable_flat_count(Integer available_flat_count) {
        this.available_flat_count = available_flat_count;
    }

    public Integer getAvailable_room_count() {
        return available_room_count;
    }

    public void setAvailable_room_count(Integer available_room_count) {
        this.available_room_count = available_room_count;
    }

    public Integer getAvailable_bed_count() {
        return available_bed_count;
    }

    public void setAvailable_bed_count(Integer available_bed_count) {
        this.available_bed_count = available_bed_count;
    }

    public String getAccomodation_allowed_str() {
        return accomodation_allowed_str;
    }

    public void setAccomodation_allowed_str(String accomodation_allowed_str) {
        this.accomodation_allowed_str = accomodation_allowed_str;
    }

    public String getHouse_type() {
        return house_type;
    }

    public void setHouse_type(String house_type) {
        this.house_type = house_type;
    }

    public String getAvailable_from() {
        return available_from;
    }

    public void setAvailable_from(String available_from) {
        this.available_from = available_from;
    }

    public Boolean getFavorited() {
        return favorited;
    }

    public void setFavorited(Boolean favorited) {
        this.favorited = favorited;
    }
}
