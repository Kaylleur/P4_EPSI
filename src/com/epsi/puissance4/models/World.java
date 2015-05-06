package com.epsi.puissance4.models;

/**
 * Created by Thomas on 21/04/2015.
 */
public class World {

    public static World instance;
    public Space[][] spaces;
    public int width;
    public int height;

    private World(int width, int height) {
        this.width = width;
        this.height = height;
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                spaces[w][h] = new Space(w, h);
            }
        }
    }

    public static World get(){
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

    public Space[][] getSpaces() {
        return spaces;
    }
}
