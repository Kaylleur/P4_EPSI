package com.epsi.puissance4.models;

import java.util.ArrayList;
import java.util.List;


public class Space {

    private static List<Space> spaces = new ArrayList<Space>();
    private int x;
    private int y;
    private Token content = null;
    private int id;

    public Space(int x, int y) {
        this.x = x;
        this.y = y;
        this.id = spaces.size();
        spaces.add(this);
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Token getContent() {
        return content;
    }

    public int getId() {
        return id;
    }

    public void setContent(Token content) {
        content = content;
    }

    public boolean isAvailable(){
        return this.getContent() == null;
    }
}
