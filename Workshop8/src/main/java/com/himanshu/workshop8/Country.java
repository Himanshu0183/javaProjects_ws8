/**********************************************
 Workshop 8
 Course: JAC 444 - Summer 2022
 Last Name: Himanshu
 First Name: Himanshu
 ID: 146109202
 Section: ZBB
 This assignment represents my own work in accordance with Seneca Academic Policy.
 Signature  Himanshu
 Date: 08/01/2022
 **********************************************/

package com.himanshu.workshop8;

import java.util.ArrayList;

public class Country {
    private String name;
    private String slogan;
    ArrayList <String> cities;

    public Country(String name, String slogan) {
        this.name = name;
        this.slogan = slogan;
        cities = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public ArrayList<String> getCities() {
        return cities;
    }

    public void addCity(String cityName) {
        this.cities.add(cityName);
    }

    @Override
    public String toString() {
        return "Country{" +
                "name='" + name + '\'' +
                ", slogan='" + slogan + '\'' +
                ", cities=" + cities +
                '}';
    }
}
