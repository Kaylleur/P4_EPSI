package com.epsi.puissance4.views;

import android.content.Context;
import android.util.AttributeSet;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.graphics.*;

import java.util.LinkedList;

public class TestView extends View {

    Paint paintGrid = new Paint();
    Paint paintTokenJ1= new Paint();
    Paint paintTokenJ2= new Paint();

    DisplayMetrics metrics = this.getContext().getResources().getDisplayMetrics();
    int widthScreen = metrics.widthPixels;
    int heightScreen = metrics.heightPixels;

    int rowNumber = 6;
    int colNumber = 7;

    float cellLength = widthScreen /colNumber;
    float gameHeight = cellLength *rowNumber;
    float gameWidth = cellLength*colNumber;

    LinkedList<TokenView> tokens;


    public TestView(Context context, AttributeSet attrs) {

        super(context, attrs);
        this.initGUI(context);
        tokens = new LinkedList<TokenView>();
    }

    private void initGUI(Context context){
        paintGrid.setColor(Color.WHITE);
        paintGrid.setTextSize(18);
        paintTokenJ1.setColor(Color.RED);
        paintTokenJ2.setColor(Color.YELLOW);


        this.setOnTouchListener(new View.OnTouchListener() {
            public boolean onTouch(View v, MotionEvent event) {

                int x = (int) event.getX();
                int y = (int) event.getY();
                int col = getColumnFromPosition(x);
                int row = getRowFromPosition(y);

                String strColor;
                if (tokens.size() % 2 == 0) {
                    strColor = "red";
                } else {
                    strColor = "yellow";
                }
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    tokens.add(new TokenView(getCellCenterX(col), getCellCenterY(row), (int) cellLength / 3, strColor));
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

    private void drawCircleInGrid(Canvas canvas, int cellNumX, int cellNumY, int side){
        int cx = this.getCellCenterX(cellNumY);
        int cy = this.getCellCenterY(cellNumX);
        Paint paint = this.paintTokenJ1;
        canvas.drawCircle(cx, cy, cellLength /2, paint);
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
        int rowNum = (int) (posY/ cellLength);
        return rowNum;
    }


}