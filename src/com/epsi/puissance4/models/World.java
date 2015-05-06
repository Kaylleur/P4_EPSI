package com.epsi.puissance4.models;


public class World {

    public static World instance;
    public Space[][] spaces;
    public int width;
    public int height;

    /**
     * checkVictory
     * -> check horizontal
     * -> check vertical
     * -> check diagonal
     */


    private World(int width, int height) {
        this.width = width;
        this.height = height;
        this.spaces = new Space[width][height];
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                spaces[w][h] = new Space(w, h);
            }
        }
    }

    public static World getWorld(){
        if(instance==null){
            //TODO voir pour différentes tailles
            instance = new World(6,7);
        }
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean checkVictory(Space spaceInit){
        boolean res = false;

        return res;
    }

    public void displayWorld(){
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                if(spaces[w][h].getContent() == null){
                    System.out.print(" X ");
                } else {
                    System.out.print(" " + spaces[w][h].getContent().getColor() + " ");
                }
            }
            System.out.print("\n");
        }
        System.out.println("---------------------------------");
    }

    public Space getNextSpaceAvailable(int y){
        Space currentSpace = World.getWorld().spaces[0][y];
        for (int h = 0; h < height; h++) {
            if(currentSpace.getContent() != null){
                currentSpace = this.getNextSpace(currentSpace);
            }
            return currentSpace;
        }
        return null;
    }

    public Space getNextSpace(Space space){
        return World.getWorld().spaces[space.getX()+1][space.getY()];
    }
}
