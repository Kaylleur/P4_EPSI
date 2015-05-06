package com.epsi.puissance4.models;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Thomas on 21/04/2015.
 */
public class Player {
    public static List<Player> players = new ArrayList<Player>();
    private Integer id;
    private String pseudo;
    private Level level = Level.NO;

    public Player() {
        players.add(this);
        this.id = players.size();
        this.pseudo = "Player "+id;
    }

    public Level getLevel() {
        return level;
    }

    public void setLevel(Level level) {
        this.level = level;
    }

    public Integer getId() {
        return id;
    }

    public String getPseudo() {
        return pseudo;
    }
}
