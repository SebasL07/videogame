package model;

public class Enemy{

    /**
     * <b>name</b> is the name of the enemy 
     */
    private String name;
    /**
     * <b>type</b> is the type of enemy that is classified in
     */
    private EnemyType type;
    /**
     * <b>scoreThatRemoves</b> is the score that is removed form the player when the enemy hits it
     */
    private int scoreThatRemoves;
    /**
     * <b>scoreDefeated</b> is the score that gives the enemy to the player when it's defeated
     */
    private int scoreDefeated;

    /**
     * coordinates is the coordinates where the enemy is located in the level
     */
    private Coordinates coordinates;


    /**
     * constructor method from the class enemy
     * @param name String, is the name of the enemy 
     * @param opType int, is the type of enemy that the user choose
     * @param scoreThatRemoves int, is the score that removes from the player when it his the player 
     * @param scoreDefeated int, is the score that gives to the player when it is defeated 
     * @param coordsX, the coords X in the map
     * @param coordsY, the coords Y in the map
     */
    public Enemy(String name, int opType, int scoreThatRemoves, int scoreDefeated){

        this.name = name;
        this.scoreThatRemoves = scoreThatRemoves;
        this.scoreDefeated = scoreDefeated;

        switch(opType){

            case (1):
            type = EnemyType.OGRE;
            break;

            case (2):
            type = EnemyType.ABSTRACT;
            break;

            case (3):
            type = EnemyType.BOSS;
            break;

            case (4):
            type = EnemyType.MAGICIAN;
        }

       

    }

    /**
     * get method of the atributte name
     * @return attribute name
     */
    public String getName(){
        return name;
    }
    /**
     * get method of the atributte scoreThatRemoves
     * @return attribute scoreThatRemoves
     */
    public int getScoreThatRemoves(){
        return scoreThatRemoves;
    }
    /**
     * get method of the attribute 
     * @return attribute scoreDefeated
     */
    public int getScoreDefeated(){
        return scoreDefeated;
    }
    /**
     * get method of the attribute type
     * @return attribute type
     */
    public EnemyType getType(){
        return type;
    }
    /**
     * get method of the attribute coordinates
     * @return attribute coordinates
     */
    public Coordinates getCoordinates(){
        return coordinates;
    }

    /**
     * method to add the coordinates of the enemy in the map
     * @param x int, coords in X
     * @param y int, coords in Y 
     * pos: object coordinates created
     */
    public void addCoordinates(int x, int y){

        coordinates = new Coordinates(x, y);
        
   
    }
}