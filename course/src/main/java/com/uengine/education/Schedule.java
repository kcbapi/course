package com.uengine.education;

import java.util.Date;

/**
 * Created by uengine on 2018. 11. 21..
 */
public class Schedule {

    String instructorName;
    Date date;
    String description;

    public String getInstructorName() {
        return instructorName;
    }

    public void setInstructorName(String instructorName) {
        this.instructorName = instructorName;
    }

    public Date getDate() {
        return date;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
