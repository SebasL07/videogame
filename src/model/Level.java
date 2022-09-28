package model; 

public class Level{

    private String id;
    private int score2NextLevel;
    private Difficulty difficulty;

    /**
     * constructor method of the class Level
     * @param id
     * @param score2NextLevel
     * @param difficulty
     */
    public Level(String id, int score2NextLevel, int optionDifficulty){

        this.id = id;
        this.score2NextLevel = score2NextLevel;
       
        switch(optionDifficulty){
             case (1):
             difficulty = Difficulty.EASY;
             break;
             
             case (2):
             difficulty = Difficulty.MEDIUM;
             break;

             case (3):
             difficulty = Difficulty.HARD;
             break;
        }
    }

}