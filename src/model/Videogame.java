package model;

public class Videogame{

    protected static final int MAX_PLAYER = 20;
    protected static final int MAX_LEVEL = 10; 

    private Player[] players;
    private Level[] levels;
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
     * @return
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
     * @param nickname
     * @return
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
     * @param nickname
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
     * @param id
     * @param name
     * @param imageURL
     * @param score
     * @param quantity
     * @return
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
     * @param id
     * @param name
     * @param opType
     * @param scoreThatRemoves
     * @param scoreDefeated
     * @return
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
     * @param nickname
     * @param score
     * @return
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
     * @param id
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

    public int countTreasuresInLevels(String name){

        int count = 0;

        for(int i = 0; i<MAX_LEVEL; i++){
            count += levels[i].countTreasure(name);
        }
        return count;
        
    }

    public int countEnemiesInLevels(int option){

        
        int count = 0;

        for(int i = 0; i<MAX_LEVEL; i++){
            count += levels[i].countEnemies(option);
        }

        return count;
    }

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