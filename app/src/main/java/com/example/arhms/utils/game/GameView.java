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

    private Map<String, Bitmap> spriteMap;
    private int dinosaurX = 200;
    private int dinosaurY = 550;
    private int obstacleX = 1000;

    private boolean isMovingSprite = true;
    private boolean isDinoJump = false;
    private boolean isSpawn = true;
    private boolean isFlyingDino = false;
    private boolean isCactusSmall = false;
    private boolean isCactusBig = false;
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
            collisionDetection();
            moveObstacle();
            draw();

            isMovingSprite = !isMovingSprite;

            try {
                Thread.sleep(150);
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

            if(isMovingSprite)
                canvas.drawBitmap(spriteMap.get("dino_walk_1"), dinosaurX, dinosaurY, null);
            else
                canvas.drawBitmap(spriteMap.get("dino_walk_2"), dinosaurX, dinosaurY, null);

            if (isSpawn) {
                isSpawn = false;
                int randomObstacle = (int) (Math.random() * 3);
                switch (randomObstacle) {
                    case 0:
                        isCactusSmall = true;
                        break;
                    case 1:
                        isCactusBig = true;
                        break;
                    case 2:
                        isFlyingDino = true;
                        break;
                }
            }

            if (isCactusSmall)
                canvas.drawBitmap(spriteMap.get("cactus_small"), obstacleX, 620, null);
            else if (isCactusBig)
                canvas.drawBitmap(spriteMap.get("cactus_big"), obstacleX, 540, null);
            else if (isFlyingDino) {
                if (isMovingSprite)
                    canvas.drawBitmap(spriteMap.get("flying_dino_1"), obstacleX, 520, null);
                else
                    canvas.drawBitmap(spriteMap.get("flying_dino_2"), obstacleX, 500, null);
            }

            getHolder().unlockCanvasAndPost(canvas);
        }
    }

    private void jump() {
        dinosaurY -= 250;

        handler.postDelayed(() -> {
            isDinoJump = false;
            dinosaurY += 250;
        }, 1250);
    }

    private void moveObstacle() {
        obstacleX -= 50;
        if (obstacleX < 0) {
            isSpawn = true;
            isCactusBig = false;
            isCactusSmall = false;
            isFlyingDino = false;
            obstacleX = 1000;
        }
    }

    private void collisionDetection() {
        int obstacleWidth = 125;
        int dinoWidth = 250;

        int dinoHeight = 300;
        int obstacleHeight = 300;
        int obstacleY = 500;

        if (dinosaurX < obstacleX + obstacleWidth &&
                dinosaurX + dinoWidth > obstacleX &&
                dinosaurY + dinoHeight >= obstacleY + obstacleHeight) {
            pause();
        }
    }
}