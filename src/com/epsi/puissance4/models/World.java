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

    public static World getInstance(){
        if(instance==null){
            //TODO voir pour différentes tailles
            instance = new World(7,6);
        }
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean checkVictory(Space lastSpace){
        if(checkRow(lastSpace)|| checkColumn(lastSpace) || checkDiagonal(lastSpace)){
            return true;
        }
        return false;
    }

    private boolean checkRow(Space lastSpace) {
        return false;
    }

    private boolean checkColumn(Space lastSpace) {
        return false;
    }

    private boolean checkDiagonal(Space lastSpace) {
        return false;
    }

    public void displayWorld(){
        for (int h = height-1; h > 0; h--) {
            for (int w = width-1; w > 0 ; w--) {
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

    public Space[][] getSpaces() {
        return spaces;
    }

    public void setSpaces(Space[][] spaces) {
        this.spaces = spaces;
    }

    public Space getSpaceAvailable(int x){
        int y = 0;
        Space currentSpace = World.getInstance().spaces[x][y];

        if (currentSpace.getContent() == null) {
            return currentSpace;
        }

        while(currentSpace.getContent() != null || y < height){
            currentSpace = this.getNextSpace(x, y);
            y++;
        }

        return currentSpace;
    }

    public Space getNextSpace(int x, int y){
        if(World.getInstance().spaces[x][y] !=  null){
          return World.getInstance().spaces[x][y];
        }
        return null;
    }
}
