package com.epsi.puissance4.views;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.view.MotionEvent;
import android.view.View;
import com.epsi.puissance4.activities.SoloActivity;
import com.epsi.puissance4.models.*;

import java.util.LinkedList;

public class GameView extends View {

    Paint paintGrid = new Paint();
    DisplayMetrics metrics = this.getContext().getResources().getDisplayMetrics();
    int widthScreen = metrics.widthPixels;
    int heightScreen=metrics.heightPixels;
    int rowNumber = 6;
    int colNumber = 7;
    float cellLength = widthScreen /colNumber;
    float gameHeight = cellLength *rowNumber;
    LinkedList<TokenView> tokens;
    private SoloActivity activity;

    public GameView(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.initGUI(context);
        tokens = new LinkedList<TokenView>();

    }

    public SoloActivity getActivity() {
        return activity;
    }

    public void setActivity(SoloActivity activity) {
        this.activity = activity;
    }

    private void initGUI(Context context){
        paintGrid.setColor(Color.WHITE);
        paintGrid.setTextSize(18);

        this.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int) event.getX();
                int y = (int) event.getY();
                int col = getColumnFromPosition(x);
                int row = getRowFromPosition(y);

                String strColor;
                Player p;
                if (tokens.size() % 2 == 0) {
                    p = Player.players.get(0);
                    strColor = p.getTokens().get(0).getColor().name();
                } else {
                    p = Player.players.get(1);
                    strColor = p.getTokens().get(0).getColor().name();
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    Space s;
                    if(p.getClass().equals(Computer.class)){
                        s = ((Computer) p).play();
                    }else{
                        s = p.placeToken(col);
                    }

                    tokens.add(new TokenView(getCellCenterX(s.getX()), getCellCenterY(s.getY()), (int) cellLength / 3, strColor));
                    if(World.getInstance().checkVictory(s)){
                        activity.popupWIn(p);
                    }
                    if(p.getLevel().equals(Level.NO) && !Player.players.get(1).getLevel().equals(Level.NO)){
                        this.onTouch(v, event);
                    }
                }
                return true;
            }
        });
    }

    @Override protected void onDraw(Canvas canvas) {
        drawGrid(canvas);
        for(TokenView c : tokens){
            c.draw(canvas);}
         invalidate();
    }

    private void drawGrid(Canvas canvas){
        //draw verticals lines
        for(int i=1;i < colNumber; i++ ){
            canvas.drawLine(cellLength *i,0, cellLength *i, gameHeight,paintGrid);
        }
        //draw horizontals lines
        for(int j=rowNumber;j >=0; j-- ){
            canvas.drawLine(0,gameHeight/rowNumber*j, widthScreen,gameHeight/rowNumber*j,paintGrid);
        }
    }

    private int getCellCenterX(int cellNumX){
        int cx = (int) (cellNumX* cellLength + cellLength /2);
        return cx;
    }

    private int getCellCenterY(int cellNumY){
        int cy = (int) (cellNumY* cellLength + cellLength /2);
        return cy;
    }

    private int getColumnFromPosition(int posX){
        int colNum = (int) (posX/ cellLength);
        return colNum;
    }
    private int getRowFromPosition(int posY){
        int rowNum = (int) ((heightScreen-gameHeight-posY)/ cellLength);
        return rowNum;
    }

}
