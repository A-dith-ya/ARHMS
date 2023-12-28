package com.example.arhms.utils.game;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.os.Handler;
import android.view.MotionEvent;
import android.view.SurfaceView;
import com.example.arhms.R;

import java.io.InputStream;
import java.util.Map;

public class GameView extends SurfaceView implements Runnable {

    private Thread gameThread;
    private boolean isPlaying;

    Map<String, Bitmap> spriteMap;
    int dinosaurX = 50;
    int dinosaurY = 550;

    private boolean isDinoWalk1 = true;
    private boolean isDinoJump = false;
    private Handler handler = new Handler();

    public GameView(Context context) {
        super(context);

        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite);
        InputStream jsonInputStream = getResources().openRawResource(R.raw.spritemetadata);
        spriteMap = SpriteSheetExtractor.extractSprites(originalBitmap, jsonInputStream);


        gameThread = new Thread(this);
        gameThread.start();

        setOnTouchListener((v, event) -> {
            if (event.getAction() == MotionEvent.ACTION_DOWN && !isDinoJump) {
                isDinoJump = true;
                jump();
            }
            return true;
        });
    }

    @Override
    public void run() {
        while (isPlaying) {
            draw();

            isDinoWalk1 = !isDinoWalk1;

            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public void pause() {
        isPlaying = false;
        try {
            gameThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public void resume() {
        isPlaying = true;
        gameThread = new Thread(this);
        gameThread.start();
    }

    private void draw() {
        if (getHolder().getSurface().isValid()) {
            Canvas canvas = getHolder().lockCanvas();

            canvas.drawColor(Color.WHITE);

            canvas.drawBitmap(spriteMap.get("ground"), 0, 800, null);

            if(isDinoWalk1)
                canvas.drawBitmap(spriteMap.get("dino_walk_1"), dinosaurX, dinosaurY, null);
            else
                canvas.drawBitmap(spriteMap.get("dino_walk_2"), dinosaurX, dinosaurY, null);

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void jump() {
        dinosaurY -= 200;

        handler.postDelayed(() -> {
            isDinoJump = false;
            dinosaurY += 200;
        }, 500);
    }
}