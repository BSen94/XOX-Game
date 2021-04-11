package com.bilgeadam.xox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bilgeadam.xox.R;
import com.bilgeadam.xox.data.Score;
import com.bilgeadam.xox.data.ScoreCommunicator;
import com.bilgeadam.xox.fragments.ScoreBoard;

import java.util.List;

public class ScoreActivity extends FragmentActivity {

    private FragmentManager fragmentManager;
    private List<Score> scoreList;

    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        float score = getIntent().getFloatExtra(GameActivity.SCORE_KEY, -1000F);
        String playerName = getIntent().getStringExtra(GameActivity.PLAYER_KEY);
        Log.v(this.getClass().getSimpleName(), String.format("Acquired score is %.4f", score));

        setContentView(R.layout.activity_scoreboard);

        if (score == -1000F || playerName == null){
            findViewById(R.id.score_board).setVisibility(View.GONE);
            Log.v(this.getClass().getSimpleName(), "Scoreboard is removed because there is no score to show");
        } else {
            ScoreCommunicator scoreCommunicator = ScoreCommunicator.getInstance(getApplicationContext());
            scoreCommunicator.save(playerName, score);
            scoreCommunicator.getAllScores(this);

            fragmentManager = getSupportFragmentManager();
            FragmentTransaction transaction = fragmentManager.beginTransaction();
            transaction.add(R.id.score_board, new ScoreBoard());
            transaction.commit();
        }
    }



    public void finishGame(View view){
        finishAffinity();
    }

    public void restartGame(View view){
        Intent intent = new Intent(this, WelcomeActivity.class);
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
        intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(intent);
    }

    public  void setScoreList(List<Score> scoreList){
        this.scoreList = scoreList;
        this.scoreList.forEach(e -> Log.v(this.getClass().getSimpleName(), String.format("Score id:%d, name:%s, score:%f", e.getId(), e.getName(), e.getScore())));
    }
}
