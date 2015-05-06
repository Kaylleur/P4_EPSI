package com.epsi.puissance4.models;

/**
 * Created by Thomas on 06/05/2015.
 */
public class Computer extends Player {
    public Computer() {
        this.setLevel(Level.BEGINNER);
    }


    public void play(){
        int depth = this.getLevel().getDepth();
        int max = -10000;
        int tmp = 0;
        Space bestSpace;

        World world = World.get();

        for(int i = 0;i<world.getWidth();i++){
            for(int j = 0;j<world.getHeight();j++){
                Space s = world.getSpaces()[i][j];
                if(s.isAvailable()){
//                    tmp = Min(world,depth-1);
                    if(tmp > max){
                        max = tmp;
                        bestSpace = s;
                    }

                }
            }
        }
//        bestSpace.setContent(get);
    }
}
