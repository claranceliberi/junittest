package com.example.demo.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import org.junit.Test;

public class WeekDaysServiceImplTest {

    @Test
    public void dayOfWeek_invalid(){
        WeekDaysServiceImpl weekDaysService = new WeekDaysServiceImpl();
        assertEquals("Invalid day of week",weekDaysService.getDayOfWeek(9));
    }

    @Test
    public void dayOfWeek_monday(){
        WeekDaysServiceImpl weekDaysService = new WeekDaysServiceImpl();
        assertEquals("monday",weekDaysService.getDayOfWeek(2));
    }
}

