package com.bilgeadam.xox.activities;

import android.content.Intent;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import com.bilgeadam.xox.R;
import com.bilgeadam.xox.animations.Animations;
import com.bilgeadam.xox.game.Logic;

import java.util.Optional;

public class WelcomeActivity extends AppCompatActivity {
    private Animations animations;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        animations = new Animations();

        setContentView(R.layout.activity_welcome);
    }

    public void clickStart(View view){
        long animationLength=1500;

        animations.rotateText(findViewById(R.id.welcome_game), Optional.of(animationLength));
        animations.moveButton(findViewById(R.id.start_game), Optional.of(animationLength), getWindowManager());

        Handler handler = new Handler(Looper.getMainLooper());
        handler.postDelayed(() -> startActivity(new Intent(this, GameActivity.class)) , animationLength);


    }
}
