package model;

public class Treasure{

    private String name;
    private String imageURL;
    private int score;

    private Coordinates coordinates;

    /**
     * constructor method from the class Treasure
     * @param name String, is the name of the treasure
     * @param imageURL String, is the URL for the image of the treasure
     * @param score int, is the score that gives
     */
    public Treasure(String name, String imageURL, int score){

        this.name = name;
        this.imageURL = imageURL;
        this.score = score;
    }

    public void addCoordinates(int x, int y){

        coordinates = new Coordinates(x, y);
        
    }
}
