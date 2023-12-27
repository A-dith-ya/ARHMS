package com.example.arhms.utils.game;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.SurfaceView;
import com.example.arhms.R;

import java.io.InputStream;
import java.util.List;

public class GameView extends SurfaceView implements Runnable {

    private Thread gameThread;
    private boolean isPlaying;

    public GameView(Context context) {
        super(context);

        Bitmap originalBitmap = BitmapFactory.decodeResource(context.getResources(), R.drawable.sprite);
        InputStream jsonInputStream = getResources().openRawResource(R.raw.spritemetadata);
        List<Bitmap> sprites = SpriteSheetExtractor.extractSprites(originalBitmap, jsonInputStream);

        gameThread = new Thread(this);
        gameThread.start();
    }

    @Override
    public void run() {
        while (isPlaying) {
            draw();
            try {
                Thread.sleep(16);
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

            getHolder().unlockCanvasAndPost(canvas);
        }
    }
}