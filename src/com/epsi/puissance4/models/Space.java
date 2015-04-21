package com.epsi.puissance4.models;

import java.util.List;

/**
 * Created by Thomas on 21/04/2015.
 */
public class Space {

    private static List<Space> spaces;
    private int x;
    private int y;
    private Object Content = null;
    private int id;

    public Space(int x, int y) {
        spaces.add(this);
        this.x = x;
        this.y = y;
        this.id = spaces.size();
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }

    public Object getContent() {
        return Content;
    }

    public int getId() {
        return id;
    }

    public void setContent(Object content) {
        Content = content;
    }
}
