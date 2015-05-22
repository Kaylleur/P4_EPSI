package com.epsi.puissance4.models;

/**
 * Created by Akronys on 06/05/2015.
 */
public class main {
    public static void main(String[] args) {
        /**
         * joueur 1 placeToken
         * checkVictory
         * if not ok -> laisse la main  à l'autre joueur
         */

        Player player1 = new Player(Color.RED);
        Player player2 = new Player(Color.YELLOW);

        int randomNum;

        for (int i = 0; i < 10; i++) {
            for (Player player : Player.players) {
                randomNum = (int) (Math.random() * ((6 - 0) + 1));
                System.out.println(player.getId());
                player.placeToken(randomNum);
                World.getInstance().displayWorld();
            }
        }
    }
}
