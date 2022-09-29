package model; 

public class Level{

    public static final int MAX_TREASURE = 50;
    public static final int MAX_ENEMY = 25;

    private String id;
    private int score2NextLevel;
    private Difficulty difficulty;

    private Enemy[] enemies;
    private Treasure[] treasures;

    /**
     * constructor method of the class Level
     * @param id
     * @param score2NextLevel
     * @param difficulty
     */
    public Level(String id, int score2NextLevel){

        this.id = id;
        this.score2NextLevel = score2NextLevel;

        enemies = new Enemy[MAX_ENEMY];
        treasures = new Treasure[MAX_TREASURE];

    }

    public String getId(){
        return id;
    }
    

    public void addEnemy(String name, int opType, int scoreThatRemoves, int scoreDefeated, int coordsX, int coordsY){

        
    }

    public void addTreasure(String name, String imageURL, int score, int quantity){

        
    }



    

}