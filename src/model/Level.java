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

    public int getScore2NextLevel(){
        return score2NextLevel;
    }

    public Difficulty difficulty(){
        return difficulty;
    }
    

    public void addEnemy(String name, int opType, int scoreThatRemoves, int scoreDefeated, int coordsX, int coordsY){

        
    }

    public int countFreeSpacesTreasure(){
        int freeSpaces = 0;

        for(int i = 0; i<MAX_TREASURE; i++){
            if(treasures[i] == null){
                freeSpaces++;
            }
        }
        return freeSpaces;
    }

    public int findFreeSpaceTreasure(){
        int pos = -1;
        boolean flag = false;
        for(int i = 0; i<MAX_TREASURE&&!flag; i++){
            if(treasures[i] == null){
                pos = i;
                flag = true;
            }
        }

        return pos;
    }

    public void addTreasure(String name, String imageURL, int score, int quantity){
        int position = 0;

        if(countFreeSpacesTreasure() >= quantity){
            position = findFreeSpaceTreasure();
            for(int i = 0; i<quantity;i++){
                position = findFreeSpaceTreasure();
                if(position != -1){
                    treasures[position] = new Treasure(name, imageURL, score);
                }
            }
        }

    }



    

}