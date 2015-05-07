package com.epsi.puissance4.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Player> players = new ArrayList<Player>();
    private Integer id;
    private String pseudo;
    private Level level = Level.NO;
    protected List<Token> tokens = new ArrayList<Token>();

    public Player(Color color) {
        players.add(this);
        this.id = players.size();
        this.pseudo = "Player "+id;
        initTokens(color);
    }

    public void initTokens(Color color){
        for (int i=0; i < 21;i++){
            Token token = new Token(color,this);
            tokens.add(token);
        }
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

    public void placeToken(int y){
        Space space = World.getInstance().getNextSpaceAvailable(y);
        Token token = tokens.get(tokens.size()-1);
        space.setContent(token);
        tokens.remove(token);
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
