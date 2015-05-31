package com.epsi.puissance4.views;

import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;

/**
 * Created by Utilisateur on 31/05/2015.
 */
class TokenView {
    int xc, yc, rayon;
    private Paint paint;

    public TokenView(int x, int y, int rayon ,String strColor) {
        xc = x;
        yc = y;
        this.rayon = rayon;
        paint = new Paint();
        paint.setColor(Color.parseColor(strColor));
    }


    public TokenView(int x, int y, String strColor) {
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
