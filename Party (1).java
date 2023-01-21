import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Party {
  public boolean notdone=true; 
  Scanner scan = new Scanner(System.in);
  ArrayList<Person> peopleList = new ArrayList<Person>(); //put ppl in people.txt into arraylist
  String[][] chart = new String[11][11]; //chart of seats and tables
  int pId = 200; 
  String[] compNames = {"", "Wal-Mart", "Kroger", "Amazon", "Lowes", "Best Western", "KMart", "Fusian", "Heinz", "Gucci", "Prada", "Nike", "Dodge", "Maserati", "Razor","AMD", "Razer"}; //for display tables
  
  public void printArray() {
    System.out.print(peopleList);
  }

  /*
load = loads people from people.txt into peopleList, makes each person in people.txt their own array w/ [person id, last name, first name, company num]
  */
  public void load() { 
   try {
      File myObj = new File("people.txt");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] arr = data.split(",");  //  ["12", "last", "first", "12"]
                      //Integer.parseInt(arr[0])
        //parse data into varibales, pass to person constructor
         //clName, String cfName, int ccompany, int ctable
        Person p1 = new Person(Integer.parseInt(arr[0]), arr[1], arr[2],Integer.parseInt(arr[3])); //each person become array
        //System.out.println(p1.toString() + "      " + p1.getfName() + p1.getlName());
        //System.out.println(p1);
        peopleList.add(p1);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }

  /*
registers person entered by user, asks for persons first name, last name, and company number, stops if user enters quit, checks if there are already 10 people per company and tells user not possible if user tries to add person to company w/ 10 ppl
  */
  public void register() {
    boolean tf = true; 
    while (peopleList.size() < 100 && notdone && tf) { //if less than 100 ppl in attendence and no quit and less than= 10 ppl in each comp
      System.out.print("welcome! would you like to register? If yes, please enter your last name. If not, type quit\n\n");
      String last = scan.nextLine(); //ask mr twyford, cler buffer
      if (last.equals("quit")) {
        notdone=false;
        break;
      }
      pId++;
      System.out.print("Enter first name\n\n");
      String first = scan.nextLine();
      System.out.print("Enter company ID\n");
      System.out.print("01,Wal-Mart\n02,Kroger\n03,Amazon\n04,Lowes\n05,Best Western\n06,KMart\n07,Fusian\n08,Heinz\n09,Gucci\n10,Prada\n11,Nike\n12,Dodge\n13,Maserati\n14,Razor\n15,AMD\n16,Razer\n\n");
      int cid = scan.nextInt();
      String temp = scan.nextLine(); //buffer
      int counter = 0; 
      for (int i = 0; i < peopleList.size(); i++) { //count number of ppl in entered company add, if 10, cant add person
        if (peopleList.get(i).getCompany() == cid) {
          counter++;
          if (counter >= 10) {
            System.out.print("There are already 10 people in this company\n");
            tf = false;
          }//if 10 close
          else {
            Person p2 = new Person(pId, last, first, cid);
            peopleList.add(p2); //add new person
          }//elsw close
        }//if cid = cid of person
      }//loop through peopel
    }//whle
  }//reg

  /*
places people at tables and seats, loop through company numbers and peopleList
gets company id of person at index j
if company num of person at index j = i then add that person into chart at position of table num and seat num
only increment seat num once table num finishes looping through 10 times
  */
  public void placeTable() {
    int tableNum = 1; 
    int seatNum = 1;
    for (int i = 1; i < 17; i++) {
      for(int j = 0; j < peopleList.size(); j++) {
        if (peopleList.get(j).getCompany() == i) { //if person is at company i
          //peopleList.get(j).setTable(tableNum);
          //peopleList.get(j).setSeat(seatNum);
          chart[tableNum][seatNum] = peopleList.get(j).getfName() + " " + peopleList.get(j).getlName() + " (" + compNames[peopleList.get(j).getCompany()] + ")"; //add person first and last name at index j into chart at index tablenum and seat num
          tableNum++; //tablenum increases w/ each loop through peopleList
          if (tableNum == 11) {
            tableNum = 1; //resests tablenum to 1 after assign someone tablenum 10 bc there's only 10 tables
            seatNum++; //only change seat num after looping through 10 times so each person @ same seatnum but dif table num
          }//close if table num
        }//close iff ppl
      }//close for j
    }//close for i
  }//close place tble

  /*
prints tables and each person at table
gets person at position in the chart and prints their name and seat number
loops through each table and does this
  */
  public void displayTables(){
    for(int i = 1; i < 11; i++){ //under one table print each person
      System.out.println("Table " + i + ": "); //print out table num
      for (int j = 1; j < 11; j++){
        System.out.println(chart[i][j] + " -> Seat " + j); //print person at seat at table
      }
      System.out.println();
    }
  }

  /*
loops through companies and prints their name
loops through chart and if company id of person matches company name at index i of compNames array print name of person and their table  and seat num
  */
  public void displayCompanies(){
    for (int i = 1; i < 17; i++){
      System.out.println(compNames[i] + ": "); //prints com names at index i in compnames array list
      for (int j = 1; j < 11; j++){
        for (int k = 1; k < 11; k++){
          if (chart[j][k] != null){ //if position isnt empty bc theres nothing at index 0 in chart
            String[] arr = chart[j][k].split(" "); //split ppl array in chart position
            if (arr.length == 4){ //if comp name is 2 words(best western)
              arr[2] = arr[2] + " " + arr[3]; //combine comp first word and comp 2nd word
            }
            if (arr[2].substring(1, arr[2].length()-1).equals(compNames[i])){
              System.out.println(arr[0] + " " + arr[1] + "(Table " + j + ", Seat " + k + ")"); //if arr2 is company name print person name and tbale num and seat num
            }
          }
        }
      }
      System.out.println();
    }
  }

  /*
finds person user is searching for by asking first and last name of person
loops through chart and if first and last name of person user is searching for matches up with someone in chart then print person info
if cant find person then print person not found
  */
  public void search() {
    Scanner scan = new Scanner(System.in);
    System.out.println("Enter first name of person you want to search for: ");
    String fName = scan.nextLine(); //gets first name
    System.out.println("Enter last name of person you want to search for: ");
    String lName = scan.nextLine(); //gets last name
    boolean found = false;
    for(int i = 1; i < 11; i++){
      for (int j = 1; j < 11; j++){ //searching through chart
        if (chart[i][j] != null ){ //if theres smth in chart 
          String[] arr = chart[i][j].split(" ");
          if (arr[0].equals(fName) && arr[1].equals(lName)){ //if name of person in chart matches entered name
          found = true;
          System.out.println(fName + " " + lName + " sits at table " + i + ", seat " + j + " and works at " + arr[2].substring(1, arr[2].length()-1)); //print person and table and comp and seat
          }
        }
        
      }
      
      //System.out.println();
    }
    if (found == false){ //name of person not in chart
        System.out.println("Person not found");
    }   
    //Once know who searching for
    //Loop over chart
    // get chart[i][j] -> chart[i][j].split(" ") -> [0] first name, [1] last name [2] company
    // i -> table num j -> seat num
  }

  
}
//table number corresponds to index in tableList, loop through each person when they are assigned a table num and add table number at index of tableList