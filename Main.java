/* YOU WILL NEED TO MODIFY THIS FILE */
import java.util.Scanner;
import java.util.ArrayList;
import java.io.*;
import java.util.*;
//import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.File;
/*
add necessary comments
use .equals for strings
*/
public class Main {
  
  public static void main(String[] args) {
    testConstructor();
    testSetters();
    testBools();
    testStringArrConstructor();
    analyze();
    testFileReader();
    // analyze();
  }
  
  public static void testConstructor() {
    Defendant d = new Defendant("Male", "Other","F","Aggravated Assault w/Firearm",1,"Low",0,"","");
    TestCode.beginTest("Constructor");
    TestCode.subTest("Sex", d.getSex()=="Male");
    TestCode.subTest("Race", d.getRace()=="Other");
    TestCode.subTest("Charge Degree", d.get_c_chargeDegree()== "F");
    TestCode.subTest("Charge Description", d.get_c_chargeDescription()=="Aggravated Assault w/Firearm");
    TestCode.subTest("Decile Score", d.getdecileScore()== 1);
    TestCode.subTest("Score Text", d.getscore_Text()== "Low");
    TestCode.subTest("Two Year Recid Rate", d.get_Recid()==0);
    TestCode.subTest("R charge Degree", d.get_r_charge_Degree()=="");
    TestCode.subTest("R charge description", d.get_r_charge_Desc()=="");
  TestCode.concludeTest();
    /* construct an object */
    /* Defendant d = new Defendant(...) */
  }

  public static void testBools() {
    Defendant d = new Defendant("Male", "Other","F","Aggravated Assault w/Firearm",1,"Low",0,"","");
    // d.isWhite();
    // d.isBlack();
    // d.hasReoffended();
    // d.isLowRisk();
    // d.isHighRisk();
    TestCode.beginTest("Bools");
    TestCode.subTest("is white", d.isWhite()== false);
    TestCode.subTest("is black", d.isBlack()==false);
    TestCode.subTest("has reoffended", d.hasReoffended() == false);
    TestCode.subTest("is low risk", d.isLowRisk() == true);
    TestCode.subTest("is high risk", d.isHighRisk() == false);
    TestCode.concludeTest();
    
    /* Test the isWhite(), isBlack(), hasReoffended(), isLowRisk(), and isHighRisk() methods */
  }
  public static void testSetters(){
    Defendant d = new Defendant("Male", "Other","F","Aggravated Assault w/Firearm",1,"Low",0,"","");
    d.setSex("Female");
    d.setRace("Caucasian");
    d.set_c_chargeDegree("M");
    d.set_c_chargeDescription("Aggravated Assault");
    d.setdecile_Score(5);
    d.setscore_Text("Mid");
    d.set_Recid(1);
    d.set_r_charge_Degree("M");
    d.set_r_charge_Desc("Public Indecency");
    
    TestCode.beginTest("Setters");
    TestCode.subTest("setSex", d.setSex("Female")=="Female");
    TestCode.subTest("setRace", d.setRace("Caucasian")== "Caucasian");
    TestCode.subTest("setChargeDegree", d.set_c_chargeDegree("M")=="M");
    TestCode.subTest("setDecileScore", d.set_c_chargeDegree("M")== "M");
    TestCode.subTest("setscore_Text", d.setdecile_Score(1) == 1);
    TestCode.subTest("set score Text", d.setscore_Text("Mid")=="Mid");
    TestCode.subTest("set Recid", d.set_Recid(1)==1);
    TestCode.subTest("set recid charge degree", d.set_r_charge_Degree("M")=="M");
    TestCode.subTest("set recid charge description", d.set_r_charge_Desc("Public Indecency") == "Public Indecency");
    TestCode.concludeTest();
  }

  public static void testStringArrConstructor() {
    String[] row1 = new String[] {"Male", "Other", "F", "Aggravated Assault w/Firearm", "1", "Low", "0", "", ""};
    String stringrow1 = String.join(",", row1);
    Defendant d = new Defendant(stringrow1); 
    //System.out.println(d);
    TestCode.beginTest("String Constructor");
    TestCode.subTest("Sex", d.setsex("Male")=="Male");
    TestCode.subTest("Race", d.setrace("Other")=="Other");
    TestCode.subTest("Charge Degree", d.set_c_chargedegree("F")=="F");
    TestCode.subTest("Charge Description", d.set_c_chargedescription("Aggravated Assault w/Firearm")=="Aggravated Assault w/Firearm");
    TestCode.subTest("Decile Score", d.setdecile_score(1)==1);
    TestCode.subTest("Score Text", d.setscore_text("Low")=="Low");
    TestCode.subTest("Recid Rate", d.set_recid(0) == 0);
    TestCode.subTest("recid charge degree", d.set_r_charge_degree("")== "");
    TestCode.subTest("recid charge description", d.set_r_charge_desc("")=="");
    //TestCode.subTest("Charge Degree", String[])
    TestCode.concludeTest();
    /* more code to write for testing */
  }

  public static void testAdding() {
    /* more code to write for testing */
  }
  public static void testFileReader(){
    /*fix this 
         |
         V
              */
    Scanner file = null;
  try {
    file = new Scanner(new File("compas-scores.csv"));
  } catch (FileNotFoundException e) {
    System.err.println("Cannot locate file.");
    System.exit(-1);
  }
  while (file.hasNextLine()) {
    String line = file.nextLine();
    Defendant d = new Defendant(line);
     //System.out.println(line);
  }
  file.close();
  }
  public static void analyze(){
    DefendantGroup new_group = new DefendantGroup("compas_scores.csv");
    new_group.proPublica();
    System.out.println("analysis of data, changing the definition of recidivism.");
    DefendantGroup new_group_two_year_recid = new DefendantGroup("analysis-compas-scores.csv");
    new_group_two_year_recid.proPublica();
  }
  //adapts the code above to make it construct a new defendant objecct out of each line of the csv file. good place to use .toString() method.
}
