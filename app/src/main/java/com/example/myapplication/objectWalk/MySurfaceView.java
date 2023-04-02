package com.example.myapplication.objectWalk;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

public class MySurfaceView extends SurfaceView implements SurfaceHolder.Callback, Runnable {
    private SurfaceHolder surfaceHolder;
    private Thread thread;
    private boolean isRunning;

    private Paint paint;
    private float x, y;
    private float dx, dy;

    public MySurfaceView(Context context) {
        super(context);
        surfaceHolder = getHolder();
        surfaceHolder.addCallback(this);

        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);

        x = getWidth() / 2;
        y = getHeight() / 2;
        dx = 5;
        dy = 5;
    }

    @Override
    public void surfaceCreated(SurfaceHolder holder) {
        isRunning = true;
        thread = new Thread(this);
        thread.start();
    }

    @Override
    public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {
        // do nothing
    }

    @Override
    public void surfaceDestroyed(SurfaceHolder holder) {
        isRunning = false;
        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void run() {
        while (isRunning) {
            Canvas canvas = surfaceHolder.lockCanvas();
            if (canvas != null) {
                update();
                draw(canvas);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }
    }

    private void update() {
        x += dx;
        y += dy;

        if (x < 0 || x > getWidth()) {
            dx = -dx;
        }
        if (y < 0 || y > getHeight()) {
            dy = -dy;
        }
    }

    public void draw(Canvas canvas) {
        super.draw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawCircle(x, y, 50, paint);
    }
}
