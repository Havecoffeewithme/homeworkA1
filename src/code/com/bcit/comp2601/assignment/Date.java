/**
 * This class has final instance variables, constructor arguments, and accessor methods for int day, int month, and int
 * year.
 * This class implements the Orderable and the Comparable interfaces.
 *
 * @author : Percy Ratheko
 *
 * version 2.0
 */


package com.bcit.comp2601.assignment;

import java.util.List;

public abstract class Date implements Orderable, Comparable<Date>
{
    private final int day;

    private final int month;

    private final int year;

    private static final int CURRENT_YEAR ;
    private static final int INVALID_YEAR ;

    private static final int SATURDAY;
    private static final int SUNDAY ;
    private static final int MONDAY ;
    private static final int TUESDAY ;
    private static final int WEDNESDAY;
    private static final int THURSDAY ;
    private static final int FRIDAY ;



    private static final int  JANUARY;
    private static final int  FEBRUARY;
    private static final int  MARCH ;
    private static final int  APRIL ;
    private static final int  MAY ;
    private static final int  JUNE ;
    private static final int  JULY ;
    private static final int  AUGUST ;
    private static final int  SEPTEMBER ;
    private static final int  OCTOBER ;
    private static final int  NOVEMBER ;
    private static final int  DECEMBER ;

    private static final int THE_EVEN_NUMBER;

    private static final int CENTURY;

    private static final int FOUR_CENTURIES;


    private static final int[] DAYS_IN_JAN = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26
            ,27,28,29,30,31 };
    private static final int[] DAYS_IN_LEAP_FEB = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24
            ,25,26,27,28 };
    private static final int[] DAYS_IN_FEB = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24
            ,25,26,27,28 };
    private static final int[] DAYS_IN_MAR = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31 };
    private static final int[] DAYS_IN_APR = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,
            26,27,28,29,30};
    private static final int[] DAYS_IN_MAY = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31};
    private static final int[] DAYS_IN_JUN = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,28,29,30};
    private static final int[] DAYS_IN_JUL = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31 };
    private static final int[] DAYS_IN_AUG= {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,27,
            28,29,30,31 };
    private static final int[] DAYS_IN_SEP = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
            27,28,29,30 };
    private static final int[] DAYS_IN_OCT = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31 };
    private static final int[] DAYS_IN_NOV = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
            27,28,29,30 };
    private static final int[] DAYS_IN_DEC = {1, 2, 3,4,5,6,7,8,9,10,11,12,13,14,15,16,17,18,19,20,21,22,23,24,25,26,
            27,28,29,30,31 };


    static
    {

        CURRENT_YEAR = 2022;
        INVALID_YEAR = 0;


        SATURDAY  = 0 ;
        SUNDAY    = 1 ;
        MONDAY    = 2 ;
        TUESDAY   = 3 ;
        WEDNESDAY = 4 ;
        THURSDAY  = 5 ;
        FRIDAY    = 6 ;


        JANUARY    = 1 ;
        FEBRUARY   = 2;
        MARCH      = 3;
        APRIL      = 4;
        MAY        = 5 ;
        JUNE       = 6 ;
        JULY       = 7 ;
        AUGUST     = 8 ;
        SEPTEMBER  = 9 ;
        OCTOBER    = 10 ;
        NOVEMBER   = 11 ;
        DECEMBER   = 12 ;

        CENTURY    = 100;
        THE_EVEN_NUMBER = 4 ;
        FOUR_CENTURIES  = 400;

    }



    /**
     * Constructor
     * @param day   : The day of the date.
     * @param month : The month of the date.
     * @param year  : The year of the date.
     */
    public Date(final int day,
                final int month,
                final int year)
    {
        validateMonthAndDay(month, day);
        validateYear(year);
        this.day = day;
        this.month = month;
        this.year = year;
    }


    /**
     * Validates the year
     *
     * @param year : The year of the date given.
     */
    public static void validateYear(final int year)
    {
        if(year == INVALID_YEAR )
        {
            throw new IllegalArgumentException("invalid year");
        }

    }

    /**
     * Validates the day and month
     *
     * @param month : the month of the given date
     * @param day   : the day of the given date
     */
    public static void validateMonthAndDay(final int month, final  int day)
    {
        if(month < JANUARY || month > DECEMBER)
        {
            throw new IllegalArgumentException("Invalid month");
        }


        boolean isValidDay = false;
        if (month == 1)
        {
            for (int validDay : DAYS_IN_JAN) {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }
        }
        else if(month == 2 )
        {
            for (int validDay : DAYS_IN_FEB) {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }


        else if(month == 3 )
        {
            for (int validDay : DAYS_IN_MAR)
            {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        else if(month == 4 )
        {
            for (int validDay : DAYS_IN_APR)
            {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        else if(month == 5 )
        {
            for (int validDay : DAYS_IN_MAY)
            {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        else if(month == 6 )
        {
            for (int validDay : DAYS_IN_JUN) {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }
        else if(month == 7 )
        {
            for (int validDay : DAYS_IN_JUL)
            {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        else if(month == 8 )
        {
            for (int validDay : DAYS_IN_AUG)
            {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        else if(month == 9 )
        {
            for (int validDay : DAYS_IN_SEP) {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        else if(month == 10 )
        {
            for (int validDay : DAYS_IN_OCT) {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }
        else if(month == 11 )
        {
            for (int validDay : DAYS_IN_NOV) {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        else if(month == 12)
        {
            for (int validDay : DAYS_IN_DEC) {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        else if(month == 3 )
        {
            for (int validDay : DAYS_IN_MAR) {
                if (validDay == day) {
                    isValidDay = true;
                    break;
                }
            }

        }

        if(!isValidDay)
        {
            throw new IllegalArgumentException("Invalid day: " + day + " for month: " + month);
        }


    }

    /**
     * @return : returns the day.
     */
    public int getDay()
    {
        return day;
    }

    /**
     * @return : returns the month
     */
    public int getMonth()
    {
        return month;
    }

    /**
     * @return : returns the year
     */
    public int getYear()
    {
        return year;
    }


    /**
     * @return : returns the formated date.
     */
    public String getYyyyMmDd()
    {
        return String.format("%04d-%02d-%02d", year, month, day);
    }


    /**
     *
     * @return : the previous date
     */
    public Date previous()
    {
        return previous();

    }

    /**
     *
     * @return : returns the next date.
     */
    public Date next()
    {
        return next();

    }


    /**
     *
     * @return : returns the day of the week
     */
    public String getDayOfTheWeek()
    {
        return getDayOfTheWeek();

    }


    /**
     * Determines if the year is a leap year.
     *
     * @param year : the year.
     * @return     : returns true if the given year its a leap year, false if not.
     */
    private boolean isLeapYear(int year)
    {
        if (year % THE_EVEN_NUMBER != 0) return false;
        if (year % CENTURY != 0) return true;
        return year % FOUR_CENTURIES == 0;

    }

    /**
     * gets code of the month
     *
     * @param month : the month.
     * @return      : returns the code of the month.
     */
    private int getCodeForMonth(int month)
    {
        if(month == APRIL || month == JULY)
        {
            return 0;
        }
        else if(month == JANUARY || month == OCTOBER)
        {
            return 1;
        }
        else if(month == MAY)
        {
            return 2;
        }
        else if(month == AUGUST)
        {
            return 3;
        }
        else if(month == FEBRUARY || month == MARCH || month == NOVEMBER)
        {
            return 4;
        }
        else if(month == JUNE)
        {
            return 5;
        }
        else if (month == SEPTEMBER || month == DECEMBER)
        {
            return 6;
        }
        else
        {
            throw new IllegalArgumentException("Invalid month: " + month);
        }

    }


    /**
     * Method for code of the day.
     *
     * @param day : the day of the week
     * @return    : returns the day of the week as a string.
     */
    private static String getDayCode(final int day)
    {
       if(day == SATURDAY)
       {
           return "saturday";

       } else if(day == SUNDAY)
       {
           return "sunday";

       } else if (day == MONDAY)
       {
           return "monday";

       } else if (day == TUESDAY)
       {
           return "tuesday";
       } else if (day == WEDNESDAY)
       {
           return "wednesday";
       } else if (day == THURSDAY)
       {
           return "thursday";
       } else if (day == FRIDAY)
       {
           return "friday";
       }
       else throw new IllegalArgumentException("Invalid day" + day);

    }


    /**
     * The toString Method.
     *
     * @return : returns the value from its own public String getYyyyMmDd() method.
     */
    @Override
    public String toString()
    {
        return getYyyyMmDd();

    }


    /**
     * this method satisfies the requirements from implementing the Comparable interface.
     * Later dates are "larger".
     *
     * @param d the object to be compared.
     * @return : positive number for later dates
     */
    @Override
    public int compareTo(Date d)
    {
        if (this.year != d.year)
        {
            return this.year - d.year;
        }
        if (this.month != d.month)
        {
            return this.month - d.month;
        }
        return this.day - d.day;
    }


}
