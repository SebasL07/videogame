package model;

public class Player{

    /** 
    * nickname is the nickname that the player choose to be called in the videogame
    */
   private String nickname;
   /**
    * name is the name of the player that owns the account wiht the nickname
    */
   private String name; 
   /**
    * score is the initial score of the player. Starts with 10 
    */
   private int score;
   /**
    * lifes is the lifes of the player. Starts with 5
    */
   private int lifes;

   private Level myLevel;

    /**
     * constructor method for the class Player
     * @param nickname String, is the nickname of the player
     * @param name String, is the name of the player that owns the nickname
     */
   public Player(String nickname, String name, String id, int score2NextLevel){
      this.nickname = nickname;
      this.name = name;
      score = 10;
      lifes = 5;
      
      myLevel = new Level(id, score2NextLevel);
    }
  
    /**
     * Method to get the nickanme
     * @return nickname String
     */
   public String getNickname(){
     return nickname;
   }

   /**
    * Method to get the nickanme
    * @return nickname String
    */
  public String getName(){
   return name;
   }
   /**
    * Method to get the score
    * @return score int
    */
   public int getScore(){
     return score;
   }
   /**
    * Method ti get the lifes
    * @return lifes int
    */
    public int getLifes(){
     return lifes;
   }
   /**
    * Method to set the score
    * @param score int, the new score
    */
   public void setScore(int score){
    this.score = score;

  }
  /**
   * Method to get the Level(obj) where is the player
   * @return myLevel Level
   */
  public Level getMyLevel(){
    return myLevel;
  }

  /**
   * Method to set the attribute myLevel
   * @param newLevel Level, is the new where is going to be the player
   */
  public void setMyLevel(Level newLevel){
    myLevel = newLevel;
  }
  /**
   * Method toString to show the information of the player
   */
  public String toString(){

    return "Informacion del jugador" + "\n" + 
    "Nombre: " + name + "\n" +
    "Nickname: " + nickname + "\n" + 
    "Puntaje: " + score + "\n" + 
    "Lifes: " + lifes + "\n" +
    myLevel.toString();
  }
  

   




}