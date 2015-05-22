package com.epsi.puissance4.models;


public class Token {

    private Color color;
    private Player player;

    public Token(Color color,Player player) {
        this.color = color;
        this.player = player;
    }

    public Color getColor() {
        return color;
    }

    public Player getPlayer() {
        return player;
    }

    public void setColor(Color color) {
        this.color = color;
    }
}
