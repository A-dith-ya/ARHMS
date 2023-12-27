package com.example.arhms.fragments;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import com.example.arhms.R;
import com.example.arhms.utils.game.GameView;

public class RexRunActivity extends AppCompatActivity {

    private GameView gameView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rex_run);

        gameView = new GameView(this);
        setContentView(gameView);
    }

    @Override
    protected void onPause() {
        super.onPause();
        gameView.pause();
    }

    @Override
    protected void onResume() {
        super.onResume();
        gameView.resume();
    }
}