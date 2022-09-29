package model;

public class Videogame{

    protected static final int MAX_PLAYER = 20;
    protected static final int MAX_LEVEL = 10; 

    private Player[] players;
    private Level[] levels;
    private Resolution resolution;

    public Videogame(int optionResolution){
        players = new Player[MAX_PLAYER];
        levels = new Level[MAX_LEVEL];

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

    public int findFreeSpaceLevel(){
        int pos = -1;
        boolean space = false;

        for(int i = 0; i<MAX_LEVEL&&!space; i++){
            if (levels[i] == null){
                pos = i;
                space = true;
            }
        }

        return pos;
    }

    public String addPlayer(String nickname, String name){
        String msg = "No se ha podido registrar al jugador";

        int position = findFreeSpacePlayer();

        if(position != -1){
            players[position] = new Player(nickname,name);
            msg = "Se ha creado exitosamente el jugador";
        }
        return msg;
    }

    public String addLevel(String id, int score2NextLevel, int optionDifficulty){
        String msg = "No se ha podido registrar el nivel";

        int position = findFreeSpaceLevel();

        if(position != -1){
            levels[position] = new Level(id, score2NextLevel, optionDifficulty);
        }
        return msg;
    }

    
}