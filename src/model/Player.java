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
    * initalScore is the initial score of the player. Starts with 10 
    */
   private int initialScore;
   /**
    * lifes is the lifes of the player. Starts with 5
    */
   private int lifes;

    /**
     * constructor method for the class Player
     * @param nickname String, is the nickname of the player
     * @param name String, is the name of the player that owns the nickname
     */
   public Player(String nickname, String name){
        this.nickname = nickname;
        this.name = name;
        initialScore = 10;
        lifes = 5;
   }

   




}