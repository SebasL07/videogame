package model;

public class Enemy{

    /**
     * <b>name</b> is the name of the enemy 
     */
    private String name;
    /**
     * <b>type</b> is the type of enemy that is classified in
     */
    private String type;
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
     * @param type String, is the type
     * @param scoreThatRemoves
     * @param scoreDefeated
     * @param coordsX
     * @param coordsY
     */
    public Enemy(String name, String type, int scoreThatRemoves, int scoreDefeated, int coordsX, int coordsY){

        this.name = name;
        this.type = type;
        this.scoreThatRemoves = scoreThatRemoves;
        this.scoreDefeated = scoreDefeated;

        coordinates = new Coordinates(coordsX, coordsY);

    }
}