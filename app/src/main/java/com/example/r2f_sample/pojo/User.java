package com.example.r2f_sample.pojo;


import org.json.simple.JSONObject;

public class User {
    private String fullName;
    private String address1;
    private String address2;
    private String city;
    private String zip;
    private String state;

    public User(JSONObject o) {

            this.fullName = (String) o.get("fullName");
            this.address1 = (String) o.get("address1");
            this.address2 = (String) o.get("address2");
            this.city = (String) o.get("city");
            this.zip = (String) o.get("zip");
            this.state = (String) o.get("state");

    }
    public User(String fullName, String address1, String address2, String city, String state, String zip) {
        this.fullName = fullName;
        this.address1 = address1;
        this.address2 = address2;
        this.city = city;
        this.state = state;
        this.zip = zip;

    }
    public String getFullName() {
        return fullName;
    }

    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public String getAddress1() {
        return address1;
    }

    public void setAddress1(String address1) {
        this.address1 = address1;
    }

    public String getAddress2() {
        return address2;
    }

    public void setAddress2(String address2) {
        this.address2 = address2;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }
}
