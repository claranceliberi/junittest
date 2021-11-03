package com.example.demo.service;

public class WeekDaysServiceImpl {
    public String getDayOfWeek(int num){
        String dayofweek = "";

        switch (num){
            case 1 : dayofweek = "sunday";
            break;
            case 2 : dayofweek = "monday";
            break;
            case 3 : dayofweek = "tuesday";
            break;
            case 4 : dayofweek = "wednesday";
            break;
            case 5 : dayofweek = "thursday";
            break;
            case 6 : dayofweek = "friday";
            break;
            case 7: dayofweek = "saturday";
            break;
            default: dayofweek = "Invalid day of week";
            break;
        }

        return dayofweek;
    }
}
