package model;

public class Treasure{

    /**
     * name is the name of the treasure 
     */
    private String name;
    /**
     * imageURL is an URL that contains the image of the treausure
     */
    private String imageURL;
    /**
     * score is the score that gives to the player when it is picked up by the player
     */
    private int score;

    private Coordinates coordinates;

    /**
     * constructor method from the class Treasure
     * @param name String, is the name of the treasure
     * @param imageURL String, is the URL for the image of the treasure
     * @param score int, is the score that gives to the player
     */
    public Treasure(String name, String imageURL, int score){

        this.name = name;
        this.imageURL = imageURL;
        this.score = score;
    }

    /**
     * Method to add the coordinates of the treasure
     * @param x int, coordinates in X
     * @param y int, coordinates in Y
     */
    public void addCoordinates(int x, int y){

        coordinates = new Coordinates(x, y);
        
    }

    /**
     * Method to get the name of the treasure
     * @return name String
     */
    public String getName(){
        return name;
    }
    /**
     * Method to get the imageUrl
     * @return imageURL String
     */
    public String getImageURL(){
        return imageURL;
    }
    /**
     * Method to get the score that gives
     * @return score int
     */
    public int getScore(){
        return score;
    }
    /**
     * Method to get the coordinates
     * @return coordinates Coordinates
     */
    public Coordinates getCoordinates(){
        return coordinates;
    }
}
