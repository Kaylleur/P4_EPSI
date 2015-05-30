package com.epsi.puissance4.models;


import java.util.List;

public class main {
    public static void main(String[] args) {
        /**
         * joueur 1 placeToken
         * checkVictory
         * if not ok -> laisse la main  à l'autre joueur
         */

        Player player1 = new Player(Color.RED);
        Player player2 = new Player(Color.YELLOW);

        List<Player> players = Player.players;

        int randomNum;

        for (int i = 0; i < 15; i++) {
            System.out.println("TOUR N° :" + (i+1));
            for (Player player : players) {
                randomNum = (int) (Math.random() * ((6 - 0)));
                Space space = player.placeToken(randomNum);
                if(space != null)
                {
                    World.getInstance().displayWorld();
                    World.getInstance().checkVictory(space);
                }
            }
        }
    }
}
