package com.epsi.puissance4.models;

/**
 * Created by Thomas on 21/04/2015.
 */
public enum Level {
    NO(0),BEGINNER(2),INTERMEDIATE(4),ADVANCED(6);

    private int depth;

    Level(int depth) {
        this.depth = depth;
    }

    public int getDepth() {
        return depth;
    }
}
