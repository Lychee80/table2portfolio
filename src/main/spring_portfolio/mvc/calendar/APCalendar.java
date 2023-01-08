package com.nighthawk.spring_portfolio.mvc.calendar;

// Prototype Implementation

public class APCalendar {

    /** Returns true if year is a leap year and false otherwise.
     * isLeapYear(2019) returns False
     * isLeapYear(2016) returns True
     */          
    public static boolean isLeapYear(int year) {
        if(year%4==0){
            if(year%100==0){
                if(year%400==0){
                    return true;
                }else {
                    return false;
                }
            }else {
                return true;
            }
        }else {
            return false;
        }
        
        }
        
    /** Returns the value representing the day of the week 
     * 0 denotes Sunday, 
     * 1 denotes Monday, ..., 
     * 6 denotes Saturday. 
     * firstDayOfYear(2019) returns 2 for Tuesday.
    */
    static int firstDayOfYear(int year) {

        int leap;
        int regular;
        int totalDays; 
        int day; 
        year = (year - 1) - 1899; //1899 is a sunday

        leap = year / 4;

        regular = year - leap;

        totalDays = (regular * 365) + (leap * 366) + 1;

        day = (totalDays % 7);

        return day;
    }


    /** Returns n, where month, day, and year specify the nth day of the year.
     * This method accounts for whether year is a leap year. 
     * dayOfYear(1, 1, 2019) return 1
     * dayOfYear(3, 1, 2017) returns 60, since 2017 is not a leap year
     * dayOfYear(3, 1, 2016) returns 61, since 2016 is a leap year. 
    */ 
    static int dayOfYear(int month, int day, int year) {
        int x=0;
        if(isLeapYear(year)==true){
            switch(month){
                case 1:
                    x= day;
                    break;
                case 2:
                    x=  31+ day;
                    break;
                case 3:
                    x=  31+ 29+ day;
                    break;
                case 4:
                    x=  31+ 29+ 31+ day;
                    break;
                case 5:
                    x=  31+ 29+ 31+ 30+ day;
                    break;
                case 6:
                    x=  31+ 29+ 31+ 30+ 31+ day;
                    break;
                case 7:
                    x=  31+ 29+ 31+ 30+ 31+ 30+ day;
                    break;
                case 8:
                    x=  31+ 29+ 31+ 30+ 31+ 30+31+ day;
                    break;
                case 9:
                    x=  31+ 29+ 31+ 30+ 31+ 30+31+ 31+ day;
                    break;
                case 10:
                    x=  31+ 29+ 31+ 30+ 31+ 30+31+ 31+30+  day;
                    break;
                case 11:
                    x=  31+ 29+ 31+ 30+ 31+ 30+31+ 31+30+ 31+day;
                    break;
                case 12:
                    x=  31+ 29+ 31+ 30+ 31+ 30+31+ 31+30+ 31+30 +day;
                    break;
            }
        }else{
            switch(month){
                case 1:
                    x= day;
                    break;
                case 2:
                    x= 31+ day;
                    break;
                case 3:
                    x=  31+ 28+ day;
                    break;
                case 4:
                    x=  31+ 28+ 31+ day;
                    break;
                case 5:
                    x=  31+ 28+ 31+ 30+ day;
                    break;
                case 6:
                    x=  31+ 28+ 31+ 30+ 31+ day;
                    break;
                case 7:
                    x=  31+ 28+ 31+ 30+ 31+ 30+ day;
                    break;
                case 8:
                    x=  31+ 28+ 31+ 30+ 31+ 30+31+ day;
                    break;
                case 9:
                    x=  31+ 28+ 31+ 30+ 31+ 30+31+ 31+ day;
                    break;
                case 10:
                    x=  31+ 28+ 31+ 30+ 31+ 30+31+ 31+30+  day;
                    break;
                case 11:
                    x=  31+ 28+ 31+ 30+ 31+ 30+31+ 31+30+ 31+day;
                    break;
                case 12:
                    x=  31+ 28+ 31+ 30+ 31+ 30+31+ 31+30+ 31+30 +day;
                    break;
        }
    }
        return x;
        }

    /** Returns the number of leap years between year1 and year2, inclusive.
     * Precondition: 0 <= year1 <= year2
    */ 
    public static int numberOfLeapYears(int year1, int year2) {
         // to be implemented in part (a)

         int x= 0;
            for(int i=year1; i<year2; i++ ){
                if(i%4==0){
                    if(i%100==0){
                        if(i%400==0){
                            x++;
                        }else {
                           x=x+0;
                        }
                    }else {
                        x++;
                    }
                }else {
                    x=x+0;
                }
            }
            return x;
        }

    /** Returns the value representing the day of the week for the given date
     * Precondition: The date represented by month, day, year is a valid date.
    */
    public static int dayOfWeek(int month, int day, int year) { 
        int lastTwoDigits= (year/100) *100 - year;
        int secondStep= lastTwoDigits/4 +lastTwoDigits;
        int yearCode= secondStep%7;
        int monthCode=0;
        switch(month){
            case 1:
                monthCode=0;
            case 2:
                monthCode= 3;
            case 3:
                monthCode= 3;
            case 4:
                monthCode= 6;
            case 5:
                monthCode= 1;
            case 6:
                monthCode= 4;
            case 7:
                monthCode= 6;
            case 8:
                monthCode= 2;
            case 9:
                monthCode= 5;
            case 10:
                monthCode= 0;
            case 11:
                monthCode= 3;
            case 12:
                monthCode= 5;
    }
        int centuryCode=0;
            if(year/100==17){
                centuryCode=4;
            }else if(year/100==18){
                centuryCode=2;
            }else if(year/100==19){
                centuryCode=0;
            }else if(year/100==20){
                centuryCode=6;
            }else if(year/100==21){
                centuryCode=4;
            }else if(year/100==22){
                centuryCode=2;
            }else if(year/100==23){
                centuryCode=0;
            }
         int leapYearCode= 0;   
         if(isLeapYear(year)==true){
            leapYearCode++;
         }
        return (yearCode + monthCode+centuryCode + day -leapYearCode)%7;
        }

    /** Tester method */
    public static void main(String[] args) {
        // Private access modifiers
        System.out.println("firstDayOfYear: " + APCalendar.firstDayOfYear(2019));
        System.out.println("dayOfYear: " + APCalendar.dayOfYear(1, 30, 2019));

        // Public access modifiers
        System.out.println("isLeapYear: " + APCalendar.isLeapYear(2022));
        System.out.println("numberOfLeapYears: " + APCalendar.numberOfLeapYears(2000, 2022));
        System.out.println("dayOfWeek: " + APCalendar.dayOfWeek(1, 30, 2022));
    }

}

