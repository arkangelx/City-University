package com.informatics.finals.objects;

import android.os.Bundle;

public class Event {

    private String title = "";
    private String  description = "";
    private String 	link = "";
    private String  category = "";
    private String  location  = "";
    private String dateStart = "";
    private String dateEnd = "";
    private String datePartStart ="";
    private String timePartStart ="";
    private String datePartEnd = "";
    private String timePartEnd = "";

    public String get_Title() {
        return this.title;
    }

    public void set_Title(String title) {
        this.title = title;
    }

    public String get_Description() {
        return this.description;
    }

    public void set_Description(String description) {
        this.description = description;
    }

    public String get_Link() {
        return this.link;
    }

    public void set_Link(String link) {
        this.link = link;
    }

    public String get_Category() {
        return this.category;
    }

    public void set_Category(String category) {
        this.category = category;
    }

    public String get_Location() {
        return this.location;
    }

    public void set_Location(String location) {
        this.location = location;
    }

    public String get_DateStart() {
        return this.dateStart;
    }

  
    public void set_DateStart(String dateStart) {
        this.dateStart = dateStart;
    }

    

    public void set_DatePartStart(String datePartStart) {
        this.datePartStart = dateStart.substring(0, 7);
    }

    public String get_DateEnd() {
        return this.dateEnd;
    }

    public String get_DatePartStart() {
        return this.dateEnd;
    }

    public void set_DatePartEnd(String datePartEnd) {
        this.datePartEnd = datePartEnd;
    }
   
    public void set_DateEnd(String dateEnd) {
        this.dateEnd =  this.dateEnd.substring(0,7);
    }

    public String get_TimePartStart() {
        return this.timePartStart;
    }

    public void set_TimePartStart(String timePartStart) {
        this.timePartStart = this.datePartStart.substring(9,12);
    }
    
    
    public String get_TimePartEnd() {
        return this.timePartEnd;
    }

    public void set_TimePartEnd(String timePartEnd) {
        this.timePartEnd = this.timePartEnd.substring(9,12);
    }


    @Override
    public String toString() {
        return "";
    }


    public Bundle toBundle() {
        Bundle b = new Bundle();
       
        b.putString("title", this.title);
        b.putString("description", this.description);
        b.putString("link", this.link);
        b.putString("category", this.category);
        b.putString("location", this.location);
         b.putString("datePartStart", this.datePartStart);
         b.putString("datePartEnd", this.datePartEnd);
         b.putString("timePartStart", this.timePartStart);
         b.putString("timePartEnd", this.timePartEnd);
        

        return b;
    }

    public static Event fromBundle(Bundle b) {
        Event event = new Event();
        event.set_Title(b.getString("title"));
        event.set_Description(b.getString("description"));
        event.set_Link(b.getString("link"));
        event.set_Category(b.getString("category"));
        event.set_Location(b.getString("location"));
        event.set_DatePartStart(b.getString("datePartStart"));
        event.set_DatePartEnd(b.getString("datePartEnd"));
        event.set_TimePartStart(b.getString("timePartStart"));
        event.set_TimePartEnd(b.getString("timePartEnd"));

        return event;
    }
}
