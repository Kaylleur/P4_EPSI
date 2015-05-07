package com.epsi.puissance4.models;


public class World implements Cloneable{

    private static World instance;
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
        Space currentSpace = World.getInstance().spaces[0][y];
        for (int h = 0; h < height; h++) {
            if(currentSpace.getContent() != null){
                currentSpace = this.getNextSpace(currentSpace);
            }
            return currentSpace;
        }
        return null;
    }

    public Space getNextSpace(Space space){
        return World.getInstance().spaces[space.getX()+1][space.getY()];
    }

    public Space[][] getSpaces() {
        return spaces;
    }

    public Space[] getSpacesToPlace(){
        Space[] res = new Space[7];
        for(int y = 0;y<instance.getWidth();y++){
            res[y]=getNextSpaceAvailable(y);
        }
        return res;
    }

    @Override
    protected World clone() throws CloneNotSupportedException {
        return (World) super.clone();
    }

    public static World manualClone(){
        World initWorld = World.getInstance();
        World returnedWorld = new World(7,6);
        returnedWorld.spaces = initWorld.spaces;
        return returnedWorld;
    }
}
