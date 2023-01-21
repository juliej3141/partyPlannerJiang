import java.util.*;
import java.io.File;  // Import the File class
import java.io.FileNotFoundException;  // Import this class to handle errors
import java.util.Scanner; // Import the Scanner class to read text files

public class Main {
  public static void main(String[] args) {
   Party p1 = new Party();
    p1.load();
    p1.placeTable();
    System.out.print("Welcome! To register someone, enter 1. To see the table arrangements, enter 2. To see the employees in each company, enter 3. To search for a person, enter 4."); //asks user what they want to do
    int enterNum = scan.nextInt();
    if (enterNum == 1) {
      p1.register();
    }
    else if (enterNum == 2) {
      p1.displayTables();
    }
    else if (enterNum == 3) {
     p1.displayCompanies(); 
    }
    else if (enterNum == 4) {
     p1.search(); 
    }
  }
}