import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList; 
import java.util.Arrays;
import java.io.*;
import java.io.FileWriter;

 /**
  What counts as recidivism? CheckList: 
  1. read in compas-scores.csv (check)
  2. convert each line to a comma seperated array(check)
  3. add each line to a arraylist(check)
  4. iterate through arraylist(check)
  5. if the 8th value (indexed as 7th) is in the non-violent group of offenses, the 7th (indexed as 6th) value in the subarray in the 2d array will be changed from 1 to 0 (doesn't count as recidivism)
  else the value will be unchanged. check
  6. write values to csv file 
  7. do proPublica() on csv 
*/
public class DefendantGroup{
   ArrayList<Defendant> group = new ArrayList<Defendant>();
  //add defendant to the arraylist group
  public DefendantGroup(String filename){
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
    addDefendant(d);
  }
  file.close();
  }  
  //add one defendant object to the collection
  public ArrayList<Defendant> addDefendant(Defendant d){
    group.add(d);
    return group;
  }
  //return the i_th Defendant stored
  public Defendant getDefendant(int i){
    return group.get(i); 
  }
  //delete the i_th Defendant stored
  public ArrayList<Defendant> removeDefendant(int i){
    group.remove(i);
    return group;

  }
  //return the total number of defendants stored in the collection
  public int Size(){
    return group.size();
  }

public void proPublica(){
  // variables to count particular categories
// note that medium and high risk are counted here as high
int wly = 0; // White, low risk, has reoffended
int wln = 0; // White, low risk, has not reoffended
int bly = 0; // Black, low risk, has reoffended
int bln = 0; // Black, low risk, has not reoffended
int why = 0; // White, high risk, has reoffended
int whn = 0; // White, high risk, has not reoffended
int bhy = 0; // Black, high risk, has reoffended
int bhn = 0; // Black, high risk, has not reoffended
/**Further analysis based on sex*/
int mly = 0; //male, low risk, has reoffended
int mln = 0; //male, low risk , has not reoffended
int fly = 0; //female, low risk, has reoffended
int fln = 0; //female low risk, has not reoffended
int mhy = 0; //male, high risk, has reoffended
int mhn = 0; //male,  high risk, has not reoffended
int fhy = 0; //female, high risk, has reoffended
int fhn = 0; //female, high risk, has not reoffended
// loop to count sums
for (int i = 0; i < Size(); i++) {
  Defendant d = getDefendant(i);
  if (d.isWhite()&&d.isLowRisk()&&d.hasReoffended()) {
    wly++;
  } else if (d.isWhite()&&d.isLowRisk()&&!d.hasReoffended()) {
    wln++;
  } else if (d.isBlack()&&d.isLowRisk()&&d.hasReoffended()) {
    bly++;
  } else if (d.isBlack()&&d.isLowRisk()&&!d.hasReoffended()) {
    bln++;
  } else if (d.isWhite()&&!d.isLowRisk()&&d.hasReoffended()) {
    why++;
  } else if (d.isWhite()&&!d.isLowRisk()&&!d.hasReoffended()) {
    whn++;
  } else if (d.isBlack()&&!d.isLowRisk()&&d.hasReoffended()) {
    bhy++;
  } else if (d.isBlack()&&!d.isLowRisk()&&!d.hasReoffended()) {
    bhn++;
  } //adding for sex
  else if (d.isMale() && d.isLowRisk() && d.hasReoffended()){
    mly++;
  }else if (d.isMale() && d.isLowRisk() && !d.hasReoffended()){
    mln++;
  }else if (d.isFemale() && d.isLowRisk() && d.hasReoffended()){
    wly++;
  }else if (d.isFemale() && d.isLowRisk() && !d.hasReoffended()){
    wln++;
  }else if (d.isMale() && !d.isLowRisk() && d.hasReoffended()){
    mhy++;
  }else if (d.isMale() && !d.isLowRisk() && !d.hasReoffended()){
    mhn++;
  }else if (d.isFemale() && !d.isLowRisk() && d.hasReoffended()){
    fhy++;
  }else if (d.isFemale() && !d.isLowRisk() && !d.hasReoffended()){
    fhn++;
  }
}
//float num2 = (Float) bhn*100.0/(bhn+bln);
// print the results
System.out.println("White, high risk, didn't reoffend: "+whn*100.0/(whn+wln)+" %");
System.out.println("Black, high risk, didn't reoffend: "+bhn*100.0/(bhn+bln) + "%");
System.out.println("White, low risk, did reoffend: "+wly*100.0/(wly+why)+" %");
System.out.println("Black, low risk, did reoffend: "+bly*100.0/(bly+bhy)+" %");
System.out.println("Analysis based off of sex: ");
System.out.println("Male, high risk, didn't reoffend: " + mhn*100.0/(mhn+mln)+" %");
System.out.println("Female, high risk, didn't reoffend: " + fhn*100.0/(fhn+fln)+" %" );
System.out.println("Male, low risk, did reoffend: " + mly*100.0/(mly+mhy)+" %" );
System.out.println("Female, low risk, did reoffend: " + fly*100.0/(fly+fhy)+" %" );
}



//what counts as recidivism?? filtering r_charge_desc by severity. filtering out


public static void readData(){
    int count = 0;
    Scanner file = null;
    ArrayList<String[]> content = new ArrayList<String[]>();
  try {
    file = new Scanner(new File("compas-scores.csv"));
    while (file.hasNextLine()) {
    String line = file.nextLine();
    // Defendant d = new Defendant(line);
    //editing for empty values
    if (line.contains(",,")){
      line = line.replace(",,", "NA");
    }
    String[] row = line.split(",");
    content.add(row);
    count++;
    }
  } catch (FileNotFoundException e) {
    System.err.println("Cannot locate file.");
    System.exit(-1);
  }
  file.close();
    ArrayList<String> nonViolent = new ArrayList<String>();
  nonViolent.add("Operating W/O Valid License");
  nonViolent.add("Possess Cannabis/20 Grams Or Less");
  nonViolent.add("Driving License Suspended");
  nonViolent.add("Resist/Obstruct W/O Violence");
  nonViolent.add("Petit Theft");
  nonViolent.add("Expired DL More Than 6 Months");
  nonViolent.add("Fail To Obey Police Officer");
  nonViolent.add("Fraudulent Use of Credit Card");
  nonViolent.add("Prowling/Loitering");
  nonViolent.add("Possess Drug Paraphernalia");
  nonViolent.add("Criminal Mischief");
  try{
    File csvFile = new File("analysis-compas-scores.csv");
    FileWriter fileWriter = new FileWriter(csvFile);
    for (String[] row : content){
      StringBuilder sentence = new StringBuilder();
      String s = Arrays.toString(row);
      for (int i = 0; i < nonViolent.size(); i++){
        if (s.contains(nonViolent.get(i)) == true){
          s = s.replace("1", "0");
          sentence.append(s);
          sentence.append("\n");
          fileWriter.write(sentence.toString());
        }
      }
      //checking to see if line IS NOT in arraylist without adding it 8 times to the file was difficult so I opted for the janky approach.
      if (s.contains("Operating W/O Valid License") == false && s.contains("Possess Cannabis/20 Grams Or Less") == false && s.contains("Driving License Suspended") == false && s.contains("Resist/Obstruct W/O Violence") == false && s.contains("Petit Theft") == false && s.contains("Expired DL More Than 6 Months") == false && s.contains("Fail To Obey Police Officer")== false && s.contains("Fraudulent Use of Credit Card") == false && s.contains("Prowling/Loitering") == false && s.contains("Possess Drug Paraphernalia") == false && s.contains("Criminal Mischief") == false){
        sentence.append(s);
        sentence.append("\n");
        fileWriter.write(sentence.toString());
      }
    }
  fileWriter.close();
  }catch (IOException e){
    System.err.println("Cannot write to csv.");
    System.exit(-1);
  }
}
  
}
