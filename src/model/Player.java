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
   public Player(String nickname, String name){
      this.nickname = nickname;
      this.name = name;
      score = 10;
      lifes = 5;
      
    }

   public String getNickname(){
     return nickname;
   }

   public String getName(){
     return name;
   }

   public int getScore(){
     return score;
   }

   public int getLifes(){
     return lifes;
   }

   public void setScore(int score){
    this.score = score;
   }

   




}