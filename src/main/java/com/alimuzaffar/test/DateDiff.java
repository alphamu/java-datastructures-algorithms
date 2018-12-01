package com.alimuzaffar.test;

public class DateDiff {

    public static void main(String [] args) {
        ADate one = new ADate(args[0]);
        ADate two = new ADate(args[1]);

        long diff = one.diff(two);
    }

    static class ADate {
        static ADate peg = new ADate("01/01/1900");
        static long[] MONTH_DAYS = new long[] {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        long year;
        long month;
        long day;

        ADate(String date) {
            String [] split = date.split("/");
            year = Long.valueOf(split[2]);
            month = Long.valueOf(split[1]);
            day = Long.valueOf(split[0]);
        }

        ADate(long year, long month, long day) {
            this.year = year;
            this.month = month;
            this.day = day;
        }

        long diff(ADate other) {
            long daysSincePeg1 = daysSincePeg(this);
            System.out.println("This date " + daysSincePeg1);
            long daysSincePeg2 = daysSincePeg(other);
            System.out.println("Other date " + daysSincePeg2);
            return Math.abs(daysSincePeg1 - daysSincePeg2) - 1; //exclude the start date
        }

        long daysSincePeg(ADate date) {
            // Calculate years in days
            long totalDays = 0;
            // calculate days since start of year
            long daysSinceStartOfYear = date.day - 1; // don't include the current day
            int m = (int) date.month - 1;
            while (m > 0) {
                if (m == 2) {
                     if (isLeapYear(date.year)) {
                        daysSinceStartOfYear += 29;
                     } else {
                         daysSinceStartOfYear += 28;
                     }
                } else {
                    daysSinceStartOfYear += MONTH_DAYS[m];
                }
                m--;
            }
            totalDays = daysSinceStartOfYear;

            // Days since peg
            ADate clone = peg.clone();
            while (clone.year < date.year) {
                if (isLeapYear(clone.year)) {
                    totalDays += 366;
                } else {
                    totalDays += 365;
                }
                clone.year = clone.year + 1;
            }

            return totalDays;
        }

        boolean isLeapYear(long year) {
            if (year % 4 != 0) {
                return false;
            } else if (year % 100 != 0) {
                return true;
            } else if (year % 400 != 0) {
                return false;
            } else {
                return true;
            }
        }

        public ADate clone() {
            return new ADate(year, month, day);
        }
    }
}
