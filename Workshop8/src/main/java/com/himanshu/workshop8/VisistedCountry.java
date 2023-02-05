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

import java.util.Date;

public class VisistedCountry {
    private String name;
    private Date start_date_of_travel;
    private Date end_date_of_travel;

    public VisistedCountry(String name, Date start_date_of_travel, Date end_date_of_travel) {
        this.name = name;
        this.start_date_of_travel = start_date_of_travel;
        this.end_date_of_travel = end_date_of_travel;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Date getStart_date_of_travel() {
        return start_date_of_travel;
    }

    public void setStart_date_of_travel(Date start_date_of_travel) {
        this.start_date_of_travel = start_date_of_travel;
    }

    public Date getEnd_date_of_travel() {
        return end_date_of_travel;
    }

    public void setEnd_date_of_travel(Date end_date_of_travel) {
        this.end_date_of_travel = end_date_of_travel;
    }
}
