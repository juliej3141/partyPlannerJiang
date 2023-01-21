/**
author: Julie Jiang
date: 1/20/22
name: party
purpose: arrange attendees at 10 tables, each seating 10 people, with no more than one person from each company.  
Up to 16 companies may be in attendance, 
manage the seating arrangement, user has to be able to search for attendee w/ their table num, comp name, and seat num, 
user can register person and see the table arrangments and people in each company
*/

//create 2d array with person number from people array, company number, table number

public class Person {
  int id;
  private String lName;
  private String fName;
  private int company;
  private int table;
  private int seat;

  
  public Person(int id, String clName, String cfName, int ccompany) {
    this.id = id;
    lName = clName;
    fName = cfName;
    company = ccompany;
  }

  public int getid() { //gets id of person
    return id;
  }

  public String getlName() { //gets last name of person
    return lName;
  }

  public String getfName() { //gets first name of person
    return fName;
  }

  public int getCompany() { //gets comp of person
    return company;
  }

  public int getTable() { //gets table of person
    return table;
  }

  public void setTable(int tableNum) { //gives person a table
    table = tableNum;
    
  }

  public int getSeat() { //gets seat of person
    return seat;
  }

  public void setSeat(int seatNum) { //gives person a seat
    seat = seatNum;
  }
  
  public String toString() {
    return id + " " + fName + " " + lName + " " + company;
  }
}
