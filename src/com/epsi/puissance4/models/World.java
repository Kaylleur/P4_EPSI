package com.epsi.puissance4.models;


public class World implements Cloneable{

    private static World instance;
    public Space[][] spaces;
    public int width;
    public int height;

    /**
     * checkVictory
     * -> check horizontal
     * -> check vertical
     * -> check diagonal
     */


    private World(int width, int height) {
        this.width = width;
        this.height = height;
        this.spaces = new Space[width][height];
        for (int w = 0; w < width; w++) {
            for (int h = 0; h < height; h++) {
                spaces[w][h] = new Space(w, h);
            }
        }
    }

    public static World getInstance(){
        if(instance==null){
            instance = new World(7,6);
        }
        return instance;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public boolean checkVictory(Space lastSpace){
        if(checkRow(lastSpace) || checkColumn(lastSpace) || checkDiagonal(lastSpace)){
            //System.out.println("victory");
            return true;
        }
        return false;
    }

    private boolean checkRow(Space lastSpace) {
        boolean res = false;
        Player player = lastSpace.getContent().getPlayer();
        int i = 0;
        int y = lastSpace.getY();
        while(!res && i < 4){
            int newX = lastSpace.getX() + (i - 3);
            if(newX > 0){
                int j = 0;
                do{
                    if(!spaces[newX + j][y].isAvailable()){
                        res = player.equals(spaces[newX + j][y].getContent().getPlayer());
                    } else {
                        res = false;
                    }
                    j++;
                }while (res && j<4);
            }
            i++;
        }
        return res;
    }

    private boolean checkColumn(Space lastSpace) {
        boolean res = false;
        Player player = lastSpace.getContent().getPlayer();
        int i = 0;
        int x = lastSpace.getX();
        while(!res && i < 4){
            int newY = lastSpace.getY() - (i + 3);
            if(newY >= 0){
                int j = 0;
                do{
                    if(!spaces[x][newY + j].isAvailable()){
                        res = player.equals(spaces[x][newY + j].getContent().getPlayer());
                    } else {
                        res = false;
                    }
                    j++;
                }while (res && j<4);
            }
            i++;
        }
        return res;
    }

    private boolean checkDiagonal(Space lastSpace) {
        return checkFailingDiagonal(lastSpace) || checkRisingDiagonal(lastSpace);
    }

    public void displayWorld(){
        for (int h = height-1; h >= 0; h--) {
            for (int w = width-1; w >= 0; w--) {
                if(spaces[w][h].isAvailable()){
                    System.out.print(" x ");
                } else {
                    String col = spaces[w][h].getContent().getColor().toString();
                    col = col == "YELLOW" ? "Y": "R";
                    System.out.print(" " + col + " ");
                }
               // System.out.println("w "+ w + "h " + h + " content " + spaces[w][h].getContent());
        }
            System.out.print("\n");
        }
        System.out.println("---------------------------------");
    }

    public Space[][] getSpaces() {
        return spaces;
    }

    public void setSpaces(Space[][] spaces) {
        this.spaces = spaces;
    }

    public Space getNextSpaceAvailable(int x) {
        int y = 0;
        Space currentSpace = World.getInstance().spaces[x][y];
        if (!currentSpace.isAvailable()) {

            while (!currentSpace.isAvailable() && y < height-1) {
                currentSpace = this.getNextSpace(currentSpace);
                y++;
            }

            return currentSpace;
        }
        return currentSpace;
    }

    public Space getNextSpace(Space space){
        return World.getInstance().spaces[space.getX()][space.getY()+1];
    }

    public Space[] getSpacesToPlace(){
        Space[] res = new Space[7];
        for(int y = 0;y<instance.getWidth();y++){
            res[y]=getNextSpaceAvailable(y);
        }
        return res;
    }

    @Override
    protected World clone() throws CloneNotSupportedException {
        return (World) super.clone();
    }

    public static World manualClone(){
        World initWorld = World.getInstance();
        World returnedWorld = new World(7,6);
        returnedWorld.spaces = initWorld.spaces;
        return returnedWorld;
    }

    private boolean isNotOut(int x,int y){
        return (x >= 0 && x <= 6)&&(y >=0 && y <= 5);
    }

    public boolean checkFailingDiagonal(Space initSpace){
        boolean res = false;
        Player player = initSpace.getContent().getPlayer();
        int i = 0;
        while(!res && i < 4){
            int newX = initSpace.getX() + (i - 3);
            int newY = initSpace.getY() - (i - 3);
            System.out.println("verif " + i);
            if(isNotOut(newX,newY)){
                int j = 0;
                do{
                    System.out.println("newX " + (newX+j) );
                    System.out.println("newY " + (newY-j) );
                    if(!spaces[newX + j][newY - j].isAvailable()) {
                        res = player.equals(spaces[newX + j][newY - j].getContent().getPlayer());
                    }
                    j++;
                }while (res && j<4);
            }
            i++;
        }
        return res;
    }

    public boolean checkRisingDiagonal(Space initSpace){
        boolean res = false;
        Player player = initSpace.getContent().getPlayer();
        int i = 0;
        while(!res && i < 4){
            int newX = initSpace.getX() + (i - 3);
            int newY = initSpace.getY() + (i - 3);
            if(newX > 0 && newY > 0){
                int j = 0;
                do{
                    if(!spaces[newX + j][newY + j].isAvailable()) {
                        res = player.equals(spaces[newX + j][newY + j].getContent().getPlayer());
                    }
                    j++;
                }while (res && j<4);
            }
            i++;
        }
        return res;
    }
}
