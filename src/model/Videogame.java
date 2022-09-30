package model;
import java.util.random.*;;

public class Videogame{

    protected static final int MAX_PLAYER = 20;
    protected static final int MAX_LEVEL = 10; 

    private Player[] players;
    private Level[] levels;
    private Resolution resolution;

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
            msg = "Se ha creado exitosamente el jugador";
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

    public String addTreasure2Level(String id,String name, String imageURL, int score, int quantity){
        String msg = "No se pudo realizar el registro";

        int position = searchLevel(id);

        if(position != -1){

            levels[position].addTreasure(name, imageURL, score, quantity);

            msg = "Se ha realizado con exito el regsitro";

        }

        return msg;
    }

    public void addCoordinates2Treasure(){
        int x = 0;
        int y = 0;
        switch(resolution){
            case SD:
            break;

            case QHD:
            break;

            case HD:
            break;

            case FHD:
            break;

            case QUHD:
            break;

            case UHD:
            break;

            case UHD_8K:
            break;

        }
    }

    
}