package com.videos.luisdalopez56.dibujos05;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    Grafico grafico;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);


        grafico = new Grafico(this);
        setContentView(grafico);
    }

    public class Grafico extends View {

        int x = 50, y = 50;
        String posicionDedo = "posicion";
        Paint pincel;
        Path ruta = new Path();

        public Grafico(Context context) {
            super(context);
            pincel = new Paint();
            pincel.setColor(Color.RED);
            pincel.setStyle(Paint.Style.STROKE);
            pincel.setTextSize(5);
            pincel.setAntiAlias(true);
        }

        @Override
        protected void onDraw(Canvas canvas) {
            super.onDraw(canvas);

            canvas.drawPath(ruta, pincel);
        }

        @Override
        public boolean onTouchEvent(MotionEvent event) {
            if (event.getAction() == MotionEvent.ACTION_DOWN) {
                posicionDedo = "abajo";
            }
            if (event.getAction() == MotionEvent.ACTION_MOVE) {
                posicionDedo = "movido";
            }

            if (posicionDedo == "abajo") {
                ruta.moveTo(x, y);
            }
            if (posicionDedo == "movido") {
                ruta.lineTo(x, y);
            }

            x = (int) event.getX();
            y = (int) event.getY();
            invalidate();
            return true;
        }
    }


}


