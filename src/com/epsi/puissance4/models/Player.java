package com.epsi.puissance4.models;

import java.util.ArrayList;
import java.util.List;

public class Player {
    public static List<Player> players = new ArrayList<Player>();
    private Integer id;
    private String pseudo;
    private Level level = Level.NO;
    private Color color;
    protected List<Token> tokens = new ArrayList<Token>();

    public Player(Color color) {
        players.add(this);
        this.id = players.size();
        this.pseudo = "Player "+color.name();
        this.color = color;
        initTokens();
    }

    public void initTokens(){
        for (int i=0; i < 21;i++){
            Token token = new Token(this);
            tokens.add(token);
        }
    }

    public Color getColor() {
        return color;
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


    public Space placeToken(int x){
        Space space = World.getInstance().getNextSpaceAvailable(x);
        Token token = new Token(this);

        if(token.getPlayer() == null)
            return null;

        World.getInstance().getSpaces()[x][space.getY()].setContent(token);

        return space;
    }

    public List<Token> getTokens() {
        return tokens;
    }
}
