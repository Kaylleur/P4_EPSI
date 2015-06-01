package com.epsi.puissance4.models;

import android.util.Log;

/**
 * Created by Thomas on 06/05/2015.
 */
public class Computer extends Player {
    private Player enemy;

    public Computer(Color color,Player enemy) {
        super(color);
        this.setLevel(Level.BEGINNER);
        this.enemy = enemy;
    }


    public Space play() {
        World world = null;
        try {
            world = World.getInstance().clone();
        } catch (CloneNotSupportedException e) {
            Log.d("warning","Can't clone the world ! "+e.getMessage());
            world = World.manualClone();
        }

        int depth = this.getLevel().getDepth();
        int min = 10000;
        int tmp = 0;
        Space[] spaces = world.getSpacesToPlace();
        Space bestSpace = spaces[0];


        for(Space s : spaces){
            if(s.isAvailable()){
                s.setContent(tokens.get(0));
                tmp = max(world,s,depth-1);
                if(tmp > min){
                    min = tmp;
                    bestSpace = s;
                }
                s.setContent(null);
            }
        }
        return placeToken(bestSpace.getY());
    }


    public int max(World world,Space lastSpace, int depth){
        if(depth == 0 || world.checkVictory(lastSpace)){
            return eval(world,lastSpace);
        }
        int tmp;
        int max = -10000;
        Space[] spaces = world.getSpacesToPlace();

        for(Space s : spaces){
            if(s.isAvailable()){
                s.setContent(enemy.tokens.get(0));
                tmp = min(world,s,depth-1);
                if(tmp > max){
                    max = tmp;
                }
                s.setContent(null);
            }
        }

        return max;
    }

    public int min(World world,Space lastSpace, int depth){
        if(depth == 0 || world.checkVictory(lastSpace)){
            return eval(world,lastSpace);
        }
        int tmp;
        int min = 10000;
        Space[] spaces = world.getSpacesToPlace();

        for (Space s : spaces){
            if(s.isAvailable()){
                s.setContent(tokens.get(0));
                tmp = max(world,s,depth-1);
                if(tmp < min){
                    min = tmp;
                }
                s.setContent(null);
            }
        }
        return min;
    }

    public int eval(World world,Space lastSpace){
        int nbTokens = 0;

        for (int i = 0; i < world.getWidth(); i++) {
            for (int j = 0; j < world.getHeight(); j++) {
                if(!world.getSpaces()[i][j].isAvailable()){
                    nbTokens++;
                }
            }
        }

        if(world.checkVictory(lastSpace)){
            if(lastSpace.getContent().getPlayer().equals(enemy)){
                return -1000 + nbTokens;
            }else{
                return 1000 - nbTokens;
            }
        }
        return 0;
    }
}
