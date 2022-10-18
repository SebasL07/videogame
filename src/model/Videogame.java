package model;

public class Videogame{
    /**
     * MAX_PLAYER is the size of the array palyers[]
     */
    protected static final int MAX_PLAYER = 20;
    /**
     * MAX_LEVEL is the size of the array levels[]
     */
    protected static final int MAX_LEVEL = 10; 

    /**
     * players is an array of objects type Player
     */
    private Player[] players;
    /**
     * levels is an array of objects type Level
     */
    private Level[] levels;
    /**
     * resolution is the resolution that the will be played
     */
    private Resolution resolution;

    /**
     * Constructor method of the class Videogame
     * @param optionResolution
     */
    public Videogame(int optionResolution){
        players = new Player[MAX_PLAYER];
        levels = new Level[MAX_LEVEL];

        addLevel();

        switch(optionResolution){
            case (1):
            resolution = Resolution.SD;
            break;

            case (2):
            resolution = Resolution.QHD;
            break;

            case (3):
            resolution = Resolution.HD;
            break;

            case (4):
            resolution = Resolution.FHD;
            break;

            case (5):
            resolution = Resolution.QUHD;
            break;

            case (6):
            resolution = Resolution.UHD;
            break;

            case (7):
            resolution = Resolution.UHD_8K;
            break;

        }

    }
    /**
     * Method to get the Level
     * @param i int, is the pos of the level in the array that the user wants to see
     * @return level[i] Level
     */
    public Level getLevel(int i){
        return levels[i];
    }
    
    /**
     * Method to find a free space in the array players
     * @return if free position return its position if any free spaces returns -1
     */
    public int findFreeSpacePlayer(){
        int pos = -1;
        boolean space = false;

        for(int i = 0; i<MAX_PLAYER&&!space; i++){
            if (players[i] == null){
                pos = i;
                space = true;
            }
        }

        return pos;
    }

    /**
     * this method creates an object player and add it into the array players[]
     * @param nickname
     * @param name
     * @return msg String, a confirmation message to verify how it went the registration
     */
    public String addPlayer(String nickname, String name){
        String msg = "No se ha podido registrar al jugador";

        int position = findFreeSpacePlayer();
        
        String id = levels[0].getId();
        int score2NextLevel = levels[0].getScore2NextLevel();

        if(position != -1){
            players[position] = new Player(nickname,name, id, score2NextLevel);
            msg = "Se ha creado exitosamente el jugador\n" + 
            players[position].toString();
        }
        return msg;
    }

    /**
     * This method creates automatically the 10 levels
     * pre : levels[] must be created
     * pos : levels[] full
     */
    public void addLevel(){

        String id = "";
        int score2NextLevel = 50;
        
        
        for(int i = 0; i<MAX_LEVEL; i++){

            id = "Nivel " + (i+1);

            levels[i] = new Level(id, score2NextLevel);

            score2NextLevel += 100;

        }        
        
    }

    /**
     * Method to search a level by a given id
     * @param id
     * @return pos int, the position of the level with that id
     */
    public int searchLevel(String id){
        int positionLevel = -1;
        boolean flag = false;

        for(int i = 0; i<MAX_LEVEL && !flag; i++){
            if(levels[i] != null && levels[i].getId().equals("Nivel "+ id)){
                positionLevel = i;
                flag = true;
            }
        }
        return positionLevel;
    }

    /**
     * method to search a player by a given nickname
     * @param nickname String, is the nickname which the user wants to search
     * @return pos int, the position in the array where is the player
     */
    public int searchPlayer(String nickname){
        int positionPlayer = -1;
        boolean flag = false;

        for(int i = 0; i<MAX_PLAYER && !flag; i++){
            if(players[i] != null && players[i].getNickname().equals(nickname)){
                positionPlayer = i;
                flag = true;
            }
        }
        
        return positionPlayer;
    }
    /**
     * Verify the existence of a player without the nickname gave by the user
     * @param nickname String, is the nickname that is going to be compared to know if the player exists
     * @return exists boolean, returns the existence of a player with the same nickname
     */
    public boolean playerExists(String nickname){
        boolean exists = false;
         

        for(int i = 0; i<MAX_PLAYER&&!exists; i++){
            if(players[i] != null && players[i].getNickname().equals(nickname)){
                exists = true;
            }
        }   
    
        return exists;
    }

    /**
     * Method to add a treasure to a level
     * @param id String, is the id of the level where is going to be placed the treasure 
     * @param name String, is the name of the treasure
     * @param imageURL String, is the URl of the image of the treasure
     * @param score int, is the score that gives to th player 
     * @param quantity int, is the the quantity of players that is going to be saved
     * @return msg String, showing the result of the registration
     */
    public String addTreasure2Level(String id,String name, String imageURL, int score, int quantity){
        String msg = "No se pudo realizar el registro";

        int position = searchLevel(id);

        if(position != -1){

            int x = 0;
            int y = 0;

            switch(resolution){
                case SD:
                x = (int)(Math.random()*680);
                y = (int)(Math.random()*480); 
                break;
    
                case QHD:
                x = (int)(Math.random()*960);
                y = (int)(Math.random()*540); 
                break;
    
                case HD:
                x = (int)(Math.random()*1280);
                y = (int)(Math.random()*720); 
                break;
    
                case FHD:
                x = (int)(Math.random()*1920);
                y = (int)(Math.random()*1080); 
                break;
    
                case QUHD:
                x = (int)(Math.random()*2560);
                y = (int)(Math.random()*1440); 
                break;
    
                case UHD:
                x = (int)(Math.random()*3840);
                y = (int)(Math.random()*1260); 
                break;
    
                case UHD_8K:
                x = (int)(Math.random()*7680);
                y = (int)(Math.random()*4320); 
                break;
    
            }

            levels[position].addTreasure(name, imageURL, score, quantity,x,y);

            msg = "Se ha realizado con exito el regsitro";

        }

        return msg;
    }


    /**
     * Method to add an enemy to a level
     * @param id String, is the id of the level where is going to be placed the treasure
     * @param name String, is the name of the enemy
     * @param opType int, is the option to choose the type of the monster
     * @param scoreThatRemoves int, score that removes from when it attacks it
     * @param scoreDefeated int, score that gives to the player when is defeated
     * @return msg String, showing the restult of the registrtation
     */
    public String addEnemy2Level(String id, String name, int opType, int scoreThatRemoves, int scoreDefeated){
        String msg = "No se ha podido realizar el registro";

        int position = searchLevel(id);

        if(position != -1){

            int x = 0;
            int y = 0;

            switch(resolution){
                case SD:
                x = (int)(Math.random()*680);
                y = (int)(Math.random()*480); 
                break;
    
                case QHD:
                x = (int)(Math.random()*960);
                y = (int)(Math.random()*540); 
                break;
    
                case HD:
                x = (int)(Math.random()*1280);
                y = (int)(Math.random()*720); 
                break;
    
                case FHD:
                x = (int)(Math.random()*1920);
                y = (int)(Math.random()*1080); 
                break;
    
                case QUHD:
                x = (int)(Math.random()*2560);
                y = (int)(Math.random()*1440); 
                break;
    
                case UHD:
                x = (int)(Math.random()*3840);
                y = (int)(Math.random()*1260); 
                break;
    
                case UHD_8K:
                x = (int)(Math.random()*7680);
                y = (int)(Math.random()*4320); 
                break;
            }
           levels[position].addEnemy(name, opType, scoreThatRemoves, scoreDefeated,x,y);

           msg = "Se ha realizado el registro de manera exitosa";
        }
        return msg;
    }

    /**
     * Method tho modify the score of a player
     * @param nickname String, is the nickname of the player that is going to be modified
     * @param score int, is the new score
     * @return msg String, showing how it went the modification
     */
    public String modifyScoreInPlayer(String nickname, int score){
        String msg = "No se ha podido modificar el puntaje del jugador";
        int position = searchPlayer(nickname);
        
        if(position != -1){
            players[position].setScore(score);

            msg = "Se realizo el cambio de manera exitosa";
        } else{
            msg += ". No existe " + nickname + " en el videojuego";
        }
        return msg;
    }

    /**
     * Method to increase the level of a player
     * @param nickname String, is the nickname of the player 
     * @return msg String, showing how it went the increment of the level
     */
    public String increaseLevel(String nickname){
        String msg = "No se puede aumentar el nivel del jugador";

        int position = searchPlayer(nickname);

        if(position != -1){

            if(players[position].getScore() >= players[position].getMyLevel().getScore2NextLevel()){

                players[position].setMyLevel(levels[Integer.parseInt(players[position].getMyLevel().getId().charAt(6) + "")]);

                msg = "\nEl jugador " + nickname + " ha subido de nivel!!!\n\n" + 
                players[position].toString();

            }else if(players[position].getScore() < players[position].getMyLevel().getScore2NextLevel()){

                msg = "Al jugador " + nickname + " le faltan " + (players[position].getMyLevel().getScore2NextLevel()-players[position].getScore()) + " puntos para el siguiente nivel";
            }
        }

        return msg;
    }

    /**
     * Method for show the enemies and treasures in a level given by the user
     * @param id  String, is the id of the level that the user wants to see the information
     * @return a msg with the information 
     */
    public String showEnemiesAndTreasuresInLevel(String id){

        String msg = "";
        
        int pos =  searchLevel(id);

        if(pos != -1){

            msg = levels[pos].showEnemiesAndTreasures();
        }

        return msg;
    }
    /**
     * Method to count an specific treasure in the levels
     * pre: levels[] must be initialized
     * @param name String, name of teh treasure is going to be count
     * @return count int, the total of that specific treasure found
     */
    public int countTreasuresInLevels(String name){

        int count = 0;

        for(int i = 0; i<MAX_LEVEL; i++){
            count += levels[i].countTreasure(name);
        }
        return count;
        
    }
    /**
    * Method to count an specific type of enemy in the levels
    * pre: levels[] must be initialized
    * @param int option, option of the type of enemy that is going to be count
    * @return count int, the total of that specific type of monster found
    */
    public int countEnemiesInLevels(int option){


        int count = 0;

        for(int i = 0; i<MAX_LEVEL; i++){
            count += levels[i].countEnemies(option);
        }

        return count;
    }
    /**
     * Method to show the top 5 players in the game
     * @return msg String, a list of the nicknames of the top 5 players
     */
    public String top5Players(){
        String msg = "";

        int topOne = 0;
        String top1Player = "";
        
        for(int i = 0; i<MAX_PLAYER; i++){

            if(players[i] != null && players[i].getScore() > topOne){
                topOne = players[i].getScore();
                top1Player = players[i].getNickname();
            }
        }

        int topTwo = 0;
        String top2Player = "";

        for(int i = 0; i<MAX_PLAYER; i++){

            if(players[i] != null && players[i].getScore() < topOne){
                topTwo = players[i].getScore();
                top2Player = players[i].getNickname();
            }
        }

        int topThree = 0;
        String top3Player = "";

        for(int i = 0; i<MAX_PLAYER; i++){

            if(players[i] != null && players[i].getScore() < topTwo){
                topThree = players[i].getScore();
                top3Player = players[i].getNickname();
            }
        }

        int topFour = 0;
        String top4Player = "";

        for(int i = 0; i<MAX_PLAYER; i++){

            if(players[i] != null && players[i].getScore() < topThree){
                topFour = players[i].getScore();
                top4Player = players[i].getNickname();
            }
        }

        String top5Player = "";

        for(int i = 0; i<MAX_PLAYER; i++){

            if(players[i] != null && players[i].getScore() < topFour){
                top5Player = players[i].getNickname();
            }
        }

        msg = "1. " + top1Player + "\n" +
        "2. " + top2Player + "\n" + 
        "3. " + top3Player + "\n" + 
        "4. " + top4Player + "\n" +
        "5. " + top5Player + "\n";
        
        return msg;

    } 
    /**
     * Method to find the enemy that give the greater amount of score when it is defeated
     * @return msg String, show the name of the enemy and where it si placed 
     */
    public String searchEnemyGreaterScore(){

        String msg = "No hay enemigos creados aun";

        Enemy enemy = levels[0].searchEnemyGreaterScore();
        int pos = 0;

        for(int i = 0;i<MAX_LEVEL;i++){
            if(enemy != null && enemy.getScoreDefeated() < levels[i].searchEnemyGreaterScore().getScoreDefeated()){
                enemy = levels[i].searchEnemyGreaterScore();
                pos = i;
            }
        }

        if(enemy != null){
            msg = "El enemigo que mayor puntaje otorga es " + enemy.getName() + " y esta ubicado en el " + levels[pos].getId();
        }
       
        return msg;
    }
    /**
     * Method to count the amount of consonants in the names of the enemies
     * @return msg String, show the amount of consonants in the names of teh enemies    
     */
    public String countConsonants(){

        String msg = "";
        int count = 0;

        for(int i = 0;i<MAX_LEVEL;i++){
            count += levels[i].countConsonantsEnemy();
        }

        msg = "La cantidad de consonantes en los nombres de los enemigos es " + count;
        
        return msg;
    }


    
   

    
}