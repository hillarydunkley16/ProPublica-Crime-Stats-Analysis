/**
 *. Class to represent the characteristics of
 *. one defendant from a dataset
 *
 *  @author CSC 212 class
 *. @version Spring 2022
  compas_scores.csv notes 
  each row has sex, the degree of the crime (f for felony, m for misdemeanor etc.), a description of the crime, a score given by the algorithm, 
 a description of the score (low, mid, high), two year recidivism rate, description of crime post score, and the degree of the post-score crime

 */
public class Defendant implements ProPublica{

  /**
  setting the information about the defendant in each row
  **/
  private String sex; 
  private String race; 
  private String c_charge_degree;
  private String c_charge_desc;
  private int decile_score;
  private String score_text;
  private int two_year_recid; 
  private String r_charge_desc;
  private String r_charge_degree;

  //is the defendant white?
  public boolean isWhite(){
  if (this.race != null && this.race.equals("Caucasian")){
      return true;
    }
    else{
      return false;
    }
  }
  //is the defendant black?
  public boolean isBlack(){
  if (this.race != null && this.race.equals("African-American")){
      return true;
    }
    else{
      return false;
    }
  };
  //has the defendant reoffended? 
  public boolean hasReoffended(){
    if (this.two_year_recid == 1){
      return true;
    }
    else{
      return false;
    }
  }
  //is the defendant categorized as low risk?
  public boolean isLowRisk(){
    if (this.score_text.equals("Low")){
      // System.out.println("true");
      return true;
    }
    else{
      return false;
    }
  }
  //is the defendant categorized as high risk?
  public boolean isHighRisk(){
    if(this.score_text.equals("High")){
      return true;
    }
    else{
      return false;
    }
  }
  /**Adding qualifiers for sex */
  public boolean isMale(){
    if (this.sex != null && this.sex.equals("Male")){
      return true;
    }else{
      return false;
    }
  }

  public boolean isFemale(){
    if (this.sex != null && this.sex.equals("Female")){
      return true;
    }else{
      return false;
    }
  }


  // Ex: Male,African-American,F,Felony Battery w/Prior Convict,3,Low,1,Felony Battery (Dom Strang),(F3)

public Defendant (String sex, String race, String c_charge_degree, String c_charge_desc, int decile_score, String score_text, int two_year_recid, String r_charge_desc, String r_charge_degree){
  this.sex = sex;
  this.race = race;
  this.c_charge_degree = c_charge_degree;
  this.c_charge_desc = c_charge_desc;
  this.decile_score = decile_score;
  this.score_text = score_text;
  this.two_year_recid = two_year_recid;
  this.r_charge_desc = r_charge_desc;
  this.r_charge_degree = r_charge_degree;
  
}
  //getters
  public String getSex(){
     return this.sex;
  }
  public String getRace(){
    return race;
  }
  public String get_c_chargeDegree(){
    return c_charge_degree;
  }
  public String get_c_chargeDescription(){
    return c_charge_desc;
  }
  public Integer getdecileScore(){
    return decile_score;
  }
  public String getscore_Text(){
    return score_text;
  }
  public Integer get_Recid(){
    return two_year_recid;
  }
  public String get_r_charge_Desc(){
    return r_charge_desc;
  }
  public String get_r_charge_Degree(){
    return r_charge_degree;
  }
  //setters
  public String setSex(String defendantSex){
    this.sex = defendantSex;
    return defendantSex;
  }
  public String setRace(String defendantRace){
   this.race = defendantRace;
    return defendantRace;
  }
  public String set_c_chargeDegree(String defendant_chargeDegree){
  this.c_charge_degree = defendant_chargeDegree;
  return defendant_chargeDegree;
  }
  public String set_c_chargeDescription(String defendant_chargeDesc){
    c_charge_desc = defendant_chargeDesc;
    return defendant_chargeDesc;
    }
  public Integer setdecile_Score(int defendant_decileScore){
  this.decile_score = defendant_decileScore;
  return defendant_decileScore;
  }
  public String setscore_Text(String defendant_scoreText){
    this.score_text = defendant_scoreText;
    return defendant_scoreText;
    
    }
  public int set_Recid(Integer defendant_Recid){
    this.two_year_recid = defendant_Recid;
    return defendant_Recid;
    
    }
  public String set_r_charge_Desc(String defendant_charge_Desc){
    this.r_charge_desc = defendant_charge_Desc;
    return defendant_charge_Desc;
    }

  public String set_r_charge_Degree(String defendant_charge_degree){
    this.r_charge_degree = defendant_charge_degree;
    return defendant_charge_degree;
    }
  
  public String compas_scores(String[] s){
    this.sex = s[0];
    System.out.println(this.sex);
    this.c_charge_degree = s[1];
    System.out.println(this.c_charge_degree);
    this.c_charge_desc = s[2];
    System.out.println(this.c_charge_desc);
    this.decile_score = Integer.parseInt(s[3]);
    this.score_text = s[4];
    // this.two_year_recid = Integer.parseInt(s[5]);
    return "";
  }
  
  //second constructor 
  public Defendant(String row)
  {
    if (row.contains("3,4")){
      row = row.replace("3,4","3/4");
    }

    //splitting row into 9 different terms
    String[] splitRow = row.split(",");
    if (row.contains("")){
      row = row.replace("", "NA");
    }
    int size = splitRow.length;
    if (size==9){
      this.sex = splitRow[0]; 
    this.race = splitRow[1];
    this.c_charge_degree = splitRow[2];
    this.c_charge_desc = splitRow[3];
      try {
        this.decile_score = Integer.parseInt(splitRow[4]);
      }
      catch (NumberFormatException e) {
         this.decile_score = 0;
      }
          this.score_text = splitRow[5];
            try {
           this.two_year_recid = Integer.parseInt(splitRow[6]);
      }
      catch (NumberFormatException e) {
         this.two_year_recid = 0;
      }
          this.r_charge_desc = splitRow[7];
          this.r_charge_degree = splitRow[8];
      }
  }
    public boolean reOffended(Integer two_year_recid){
      if (this.two_year_recid == 1){
      return true;
      } 
    else{
      return false;
    } 
    }
    //if statements for recid rate 
      // getters & setters for each attribute
    public String getsex(){
      return this.sex;
    }
    public String getrace(){
      return this.race;
    }
    public String get_c_chargedegree(){
    return c_charge_degree;
  }
    public String get_c_chargedescription(){
    return c_charge_desc;
  }
    public Integer getdecilescore(){
    return decile_score;
  }
    public Integer get_recid(){
    return two_year_recid;
  }
    public String get_r_charge_desc(){
    return r_charge_desc;
  }
    public String get_r_charge_degree(){
    return r_charge_degree;
  }
    public String setsex(String defendantSex){
    this.sex = defendantSex;
    return defendantSex;
  }
    public String setrace(String defendantRace){
      this.race = defendantRace;
      return defendantRace;
    }
    public String set_c_chargedegree(String defendant_chargeDegree){
  this.c_charge_degree = defendant_chargeDegree;
  return defendant_chargeDegree;
  }
  public String set_c_chargedescription(String defendant_chargeDesc){
    c_charge_desc = defendant_chargeDesc;
    return defendant_chargeDesc;
    }
  public Integer setdecile_score(int defendant_decileScore){
  this.decile_score = defendant_decileScore;
  return defendant_decileScore;
  }
  public String setscore_text(String defendant_scoreText){
    this.score_text = defendant_scoreText;
    return defendant_scoreText;
    }
  public int set_recid(Integer defendant_Recid){
    this.two_year_recid = defendant_Recid;
    return defendant_Recid;
    }
  public String set_r_charge_desc(String defendant_charge_desc){
    this.r_charge_desc = defendant_charge_desc;
    return defendant_charge_desc;
    }
  public String set_r_charge_degree(String defendant_charge_degree){
    this.r_charge_degree = defendant_charge_degree;
    return defendant_charge_degree;
    }   

}
    
    
