package com.nighthawk.spring_portfolio.mvc.calendar;

/** Simple POJO 
 * Used to Interface with APCalendar
 * The toString method(s) prepares object for JSON serialization
 * Note... this is NOT an entity, just an abstraction
 */
class Year {
   private int year;
   private int year2;
   private int month;
   private int day;
   private boolean isLeapYear;
   private int firstDayOfYear;
   private int dayOfYear;
   private int dayOfWeek;
   private int numberOfLeapYears;

   // zero argument constructor
   public Year() {
   }
   
   public int getYear() {
      return year;
   }

   public void setYear(int year) {
      this.year = year;
      this.setIsLeapYear(year);
      this.setFirstDayOfYear(year);
   }

   public int getYear2(){
      return year2;
   }

   public void setYear2(int year2){
      this.year2=year2;
      this.setNumberOfLeapYears(year,year2);
   }

   public int getDate() {
      return year;
   }
   public void setDate(int month, int day, int year) {
      this.month = month;
      this.day = day;
      this.year = year;
      this.setIsLeapYear(year);
      this.setFirstDayOfYear(year);
      this.setDayOfYear(month, day, year);
      this.setDayOfWeek(month, day, year);
   }

   /* isLeapYear getter/setters */
  
   public boolean getIsLeapYear(int year) {
      return APCalendar.isLeapYear(year);
   }

   private void setIsLeapYear(int year) { // this is private to avoid tampering
      this.isLeapYear = APCalendar.isLeapYear(year);
   }

   /* isLeapYearToString formatted to be mapped to JSON */
   public String isLeapYearToString() {
      return ("{ \"year\": " + this.year + ", " + "\"isLeapYear\": " + this.isLeapYear + " }");
   }

   public int getFirstDayOfYear(int year) {
      return APCalendar.firstDayOfYear(year);
   }

   private void setFirstDayOfYear(int year) { // this is private to avoid tampering
      this.firstDayOfYear = APCalendar.firstDayOfYear(year);
   }

   public String firstDayOfYearToString() {
      return ("{ \"year\": " + this.year + ", " + "\"firstDayOfYear\": " + this.firstDayOfYear + " }");
   }

   public int getDayOfYear(int month, int day, int year) {
      return APCalendar.dayOfYear(month, day, year);
   }

   private void setDayOfYear(int month, int day, int year) { // this is private to avoid tampering
      this.dayOfYear = APCalendar.dayOfYear(month, day, year);
   }

   public String dayOfYearToString() {
      return ("{ \"month\": " + this.month + ", " + "\"day\": " + this.day + ", " + "\"year\": " + this.year + ", "
            + "\"dayOfYear\": " + this.dayOfYear + " }");
   }

   public int getNumberOfLeapYears(int year, int year2) {
      return APCalendar.numberOfLeapYears(year, year2);
   }

   private void setNumberOfLeapYears(int year, int year2){ // this is private to avoid tampering
      this.numberOfLeapYears = APCalendar.numberOfLeapYears(year, year2);
   }

   public String numberOfLeapYearsToString() {
      return ("{ \"year1\": " + year + ", " + "\"year2\": " + year2 + ", " + "\"numberOfLeapYears\": "
            + this.numberOfLeapYears + " }");
   }

   public int getDayOfWeek(int month, int day, int year) {
      return APCalendar.dayOfWeek(month, day, year);
   }

   void setDayOfWeek(int month, int day, int year) { // this is private to avoid tampering
      this.dayOfWeek = APCalendar.dayOfWeek(month, day, year);
   }

   public String dayOfWeekToString() {
      return ("{ \"month\": " + this.month + ", " + "\"day\": " + this.day + ", " + "\"year\": " + this.year + ", "
            + "\"dayOfWeek\": " + this.dayOfWeek + " }");
   }


   public static void main(String[] args) {
      Year year = new Year();
      year.setYear(2019);
      year.setDate(1, 1, 2019);
      year.setYear2(2040);
      System.out.println(year.dayOfYearToString());
      System.out.println(year.dayOfWeekToString());
      System.out.println(year.isLeapYearToString());
      System.out.println(year.firstDayOfYearToString());
      System.out.println(year.numberOfLeapYearsToString());
   }

}