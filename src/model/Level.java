package model; 

public class Level{
    
    /**
     * MAX_TREASURE is the size of the array treasures
     */
    public static final int MAX_TREASURE = 50;
    /**
     * MAX_ENEMY is the size of the array enemies
     */
    public static final int MAX_ENEMY = 25;

    /**
     * id is the identification of the level
     */
    private String id;
    /**
     * score2NextLevel is the score that needs the player to pass to the next level
     */
    private int score2NextLevel;
   
    /**
     * difficulty is an object of the enum Difficulty that represents the difficulty of the level
     */
    private Difficulty difficulty;
    /**
     * enemies is an array of objects form the class Enemy
     */
    private Enemy[] enemies;
    /**
     * treasures is an array of objects form the class Treasure
     */
    private Treasure[] treasures;

    /**
     * constructor method of the class Level
     * @param id String, is the identificator of the level
     * @param score2NextLevel int, is the score that the player needs to go to the next level
     */
    public Level(String id, int score2NextLevel){

        this.id = id;
        this.score2NextLevel = score2NextLevel;

        enemies = new Enemy[MAX_ENEMY];
        treasures = new Treasure[MAX_TREASURE];

    }

    /**
     * get method of the attribute id
     * @return attribute id
     */
    public String getId(){
        return id;
    }
    /**
    * get method of the attribute scoreNextLevel
    * @return attribute score2NextLevel
    */
    public int getScore2NextLevel(){
        return score2NextLevel;
    }
    /**
    * get method of the attribute difficulty
    * @return attribute difficulty
    */
    public Difficulty difficulty(){
        return difficulty;
    }

    /**
     * method to count the free spaces in the array treausre
     * pre: treasures[] must be created
     * @return the amount of free spaces in the array
     */
    public int countFreeSpacesTreasure(){
        int freeSpaces = 0;

        for(int i = 0; i<MAX_TREASURE; i++){
            if(treasures[i] == null){
                freeSpaces++;
            }
        }
        return freeSpaces;
    }
    /**
     * method to find a free space in the array treasure
     * pre: treasures[] must be created 
     * @return if the there is no free space returns -1. In the other hand, returns the position of the free space
     * that was found
     */
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
    /**
    * method to find a free space in the array enmies
    * pre: enemies[] must be created 
    * @return if the there is no free space returns -1. In the other hand, returns the position of the free space
    * that was found
    */
    public int findFreeSpaceEnemy(){
        int pos = -1;
        boolean flag = false;
        for(int i = 0; i<MAX_ENEMY&&!flag; i++){
            if(enemies[i] == null){
                pos = i;
                flag = true;
            }
        }

        return pos;
    }
    /**
     * method to add a treasure(s) to the array treasures[] equals to the amount that the user chose
     * pre: treasures[] must be created
     * @param name String, is the name of the treasure
     * @param imageURL String, is the URL for the image of the treasure
     * @param score int, is the score that gives to the playe
     * @param quantity int, is the amount of treasures that the user wants to add to the level
     * @param x int, the coords X in the map
     * @param y int, the coords Y in the map
     * pos: create the amount of treasures in the array treasure[] equals to quantity
     */
    public void addTreasure(String name, String imageURL, int score, int quantity,int x, int y){
        int position = 0;

        if(countFreeSpacesTreasure() >= quantity){
            position = findFreeSpaceTreasure();
            for(int i = 0; i<quantity;i++){
                position = findFreeSpaceTreasure();
                if(position != -1){
                    treasures[position] = new Treasure(name, imageURL, score);
                    treasures[position].addCoordinates(x, y);
                }
            }
        }

    }

    /**
     * method for add an enemy the level
     * @param name String, the name of the enemy
     * @param opType,is the option of the type of the enemy
     * @param scoreThatRemoves int, is the score that removes from the player
     * @param scoreDefeated int, is the score that gives when it is defeated  
     * @param x int, coordinates 
     * @param y
     */
    public void addEnemy(String name, int opType, int scoreThatRemoves, int scoreDefeated,int x, int y){

        int position = findFreeSpaceEnemy();
        
        if(position != -1){
            
            enemies[position] = new Enemy(name, opType, scoreThatRemoves, scoreDefeated);
            enemies[position].addCoordinates(x, y);
        }
    }

    /**
     * 
     * @param name
     * @param type
     * @return
     */
    public boolean enemyExists(String name, EnemyType type){
        boolean exists = false;

        for(int i = 0; i<MAX_ENEMY && !exists; i++){
            if(enemies[i] != null && enemies[i].getName().equals(name) && enemies[i].getType() == type){
                exists = true;
            }
        }
        return exists;

    }
    
    /**
     * Method to string that shows the information of the level
     * @return message
     */
    public String toString(){
        return id + "\n" +
        "Puntaje para el siguiente nivel: " + score2NextLevel;
    }

    /**
     * 
     * @return
     */
    public String showEnemiesAndTreasures(){

        String msg = "";
        String enemyMsg = "";
        String treasureMsg = "";

        for(int i = 0; i<MAX_ENEMY;i++){

            if(enemies[i] != null){

                enemyMsg += enemies[i].getName() + ", "; 
            }

        }

        for(int i = 0;i<MAX_TREASURE;i++){

            if(treasures[i] != null && !treasureMsg.contains(treasures[i].getName())){

                treasureMsg += treasures[i].getName() + ", ";
            }
        }

        msg = "Enemigos: " + enemyMsg + "\n"+ 
        "Tesoros: " + treasureMsg;
        
        return msg;
    }
    
    /**
     * 
     * @param name
     * @return
     */
    public int countTreasure(String name){

        int count = 0;

        for(int i = 0; i<MAX_TREASURE;i++){
            if(treasures[i] != null && treasures[i].getName().equalsIgnoreCase(name)){
                count++;
            }
        }
        return count;
    }
    /**
     * method for count the enemies by given types in this level
     * @param option
     * @return the amount of enemies of a given type
     */
    public int countEnemies(int option){

       

        int count = 0;

        EnemyType type = null;

        switch(option){

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

        for(int i = 0; i<MAX_ENEMY;i++){

            if(enemies[i] != null && enemies[i].getType() == type){
                count++;
            }
        }

         
        
        return count;
    }



}