package model; 

public class Coordinates{
    
    /**
     * coordsX is an int that represents the coordinates in X
     */
    private int coordsX;
    /**
     * coordsY is an int that represents the coordinates in Y
     */
    private int coordsY;

    /**
     * constructor method for the class Coordinates
     * @param coordsX
     * @param coordsY
     */
    public Coordinates(int coordsX, int coordsY){

        this.coordsX = coordsX;
        this.coordsY = coordsY;
    }

    /**
     * getter for the atribute coordsX
     * @return coordsX, the coords X
     */
    public int getCoordsX(){
        return coordsX;
    }

     /**
     * getter for the atribute coordsY
     * @return coordsY, the coords in Y 
     */
    public int getCoordsY(){
        return coordsY;
    }

    
    /**
     * toString method of the class Coordinates, shows the information of the class
     * as a String
     * @return a msg with the information of the class
     */
    public String toString(){
        return "Coordenadas: (" + coordsX + ", " + coordsY + ")";
    }


}