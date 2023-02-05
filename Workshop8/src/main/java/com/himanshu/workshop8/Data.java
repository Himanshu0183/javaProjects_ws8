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

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class Data {
    private ArrayList<Country> countries;
    private ArrayList<VisistedCountry> visistedCountries;
    private ArrayList<VisitedCity> visitedCities;

    public Data() {
        countries =  new ArrayList<>();
        visistedCountries =  new ArrayList<>();
        visitedCities =  new ArrayList<>();
    }

    public void pupulateCountries(String filename) {
        String line = "";
        BufferedReader br = null;
        try {
            br = new BufferedReader(new FileReader(filename));
            while ((line = br.readLine()) != null) {
                String[] record = line.split(",");
                Country country =  new Country(record[0], record[1]);
                if(record.length > 2){
                    for (int i = 2; i < record.length; i++) {
                        country.addCity(record[i]);
                    }
                }

                countries.add(country);
            }
            br.close();

        } catch (IOException e) {
            e.printStackTrace();
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("\tTask completed...");
        }
    }



    public ArrayList<Country> getCountries() {
        return countries;
    }
}

