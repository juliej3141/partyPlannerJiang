import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files




public class Party {
  public boolean notdone=true;
  Scanner scan = new Scanner(System.in);
  ArrayList<Person> peopleList = new ArrayList<Person>();
  ArrayList<String> tableList = new ArrayList<String>();
  int pId = 200;
  
  public void printArray() {
    System.out.print(peopleList);
  }
  
  public void load() {
   try {
      File myObj = new File("people.csv");
      Scanner myReader = new Scanner(myObj);
      while (myReader.hasNextLine()) {
        String data = myReader.nextLine();
        String[] arr = data.split(",");  //  ["12", "last", "first", "12"]
                      //Integer.parseInt(arr[0])
        //parse data into varibales, pass to person constructor
         //clName, String cfName, int ccompany, int ctable
        Person p1 = new Person(Integer.parseInt(arr[0]), arr[1], arr[2],Integer.parseInt(arr[3]));
        //System.out.println(p1);
        peopleList.add(p1);
      }
      myReader.close();
    } catch (FileNotFoundException e) {
      System.out.println("An error occurred.");
      e.printStackTrace();
    } 
  }

  public void register() {
    while (peopleList.size() < 100 && notdone) {
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
      String temp = scan.nextLine();
      Person p2 = new Person(pId, last, first, cid);
      peopleList.add(p2);
    }//whle
  }//reg
  
  public void placeTable() {
    int tableNum = 1; //need to make sure only 11 things in tableList
    for (int i = 1; i < 17; i++) {
      for(int j = 0; j < peopleList.size(); j++) {
        if (peopleList.get(j).getCompany() == i) {
          peopleList.get(j)
          tableNum++;
        }
      }
    }
  }
}