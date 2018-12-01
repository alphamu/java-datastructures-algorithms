package com.alimuzaffar.test;

import org.junit.Test;
import org.junit.Assert;

import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;

@SuppressWarnings("Duplicates")
public class TestDateDiff {
    @Test
    public void testNextDay() {
        DateDiff.ADate one = new DateDiff.ADate(2018, 1, 1);
        DateDiff.ADate two = new DateDiff.ADate(2018, 1, 2);
        Assert.assertEquals(0, one.diff(two));
    }

    @Test
    public void testYearChange() {
        DateDiff.ADate one = new DateDiff.ADate(2017, 12, 30);
        DateDiff.ADate two = new DateDiff.ADate(2018, 1, 1);
        Assert.assertEquals(1, one.diff(two));
    }

    @Test
    public void testSameYearDiffMonth() {
        DateDiff.ADate one = new DateDiff.ADate(2018, 1, 29);
        DateDiff.ADate two = new DateDiff.ADate(2018, 2, 1);
        Assert.assertEquals(2, one.diff(two));
    }

    @Test
    public void testYearChangeSeveralMonths() {
        DateDiff.ADate one = new DateDiff.ADate(2018, 5, 5);
        DateDiff.ADate two = new DateDiff.ADate(2017, 4, 5);
        Assert.assertEquals(394, one.diff(two));
    }

    @Test
    public void testMyAge() {
        DateDiff.ADate one = new DateDiff.ADate(1980, 7, 13);
        DateDiff.ADate two = new DateDiff.ADate(2018, 12, 1);
        Assert.assertEquals(14019, one.diff(two));
    }

}
