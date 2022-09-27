package model; 

public class Level{

    private String id;
    private int score2NextLevel;
    private String difficulty;

    /**
     * constructor method of the class Level
     * @param id
     * @param score2NextLevel
     * @param difficulty
     */
    public Level(String id, int score2NextLevel, String difficulty){

        this.id = id;
        this.score2NextLevel = score2NextLevel;
        this.difficulty = difficulty;
    }

}