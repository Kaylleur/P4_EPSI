package com.epsi.puissance4.activities;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import com.epsi.puissance4.R;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.util.Log;
import android.view.MotionEvent;

import java.util.LinkedList;

public class ViewGame extends View implements View.OnTouchListener{

    LinkedList<Token> tokens;

    public ViewGame(Context context, AttributeSet attrs) {
        super(context, attrs);
        tokens = new LinkedList<Token>();
        this.setOnTouchListener(this);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        for(Token c : tokens){
            c.draw(canvas);
        }
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        Log.d("touch event", "Touch event launched");
        int x = (int)event.getX();
        int y = (int)event.getY();
        String strColor;
        if(tokens.size()%2==0){
            strColor="red";
        }else{
            strColor="yellow";
        }
        if(event.getAction()==MotionEvent.ACTION_DOWN){
            tokens.add(new Token(x, y, strColor));
        }
        this.invalidate();
        return true;

    }
}

class Token {
    int xc, yc, rayon;
    private Paint paint;

    public Token(int x, int y, String strColor) {
        xc = x;
        yc = y;
        rayon = 50;
        paint = new Paint();
        paint.setColor(Color.parseColor(strColor));
    }

    public void draw(Canvas canvas) {
        canvas.drawCircle(xc, yc, rayon, paint);
    }
}


