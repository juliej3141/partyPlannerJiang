//create 2d array with person number from people array, company number, table number

public class Person {
  int id;
  private String lName;
  private String fName;
  private int company;
  private int table;
int seat;

  
  public Person(int id, String clName, String cfName, int ccompany, int ctable) {
    this.id = id;
    lName = clName;
    fName = cfName;
    company = ccompany;
    table = ctable;
  }

  public String getlName() {
    return lName;
  }

  public String getfName() {
    return fName;
  }

  public int getCompany() {
    return company;
  }

  public int getTable() {
    return table;
  }
  
  public String toString() {
    return id + " " + fName + " " + lName + " " + company;
  }
}