package com.bilgeadam.xox.activities;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;
import com.bilgeadam.xox.R;
import com.bilgeadam.xox.fragments.GameBoard;
import com.bilgeadam.xox.fragments.GameInfo;
import com.bilgeadam.xox.game.Logic;

public class GameActivity extends FragmentActivity {
    public static final String GAME_KEY = "logic";

    private Logic gameLogic;
    private FragmentManager fragmentManager;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        gameLogic = new Logic();

        //Create bundle to deliver object to fragments

        Bundle bundle = new Bundle();
        bundle.putSerializable(GAME_KEY,gameLogic);

        // Declare Game Info
        Fragment gameInfo = new GameInfo();
        gameInfo.setArguments(bundle);

        Fragment gameBoard= new GameBoard();

        //Initialize fragments via manager
        fragmentManager = getSupportFragmentManager();
        FragmentTransaction transaction = fragmentManager.beginTransaction();
        transaction.add(R.id.game_info_frame, gameInfo);
        transaction.add(R.id.game_board_frame, gameBoard);
        transaction.commit();


        setContentView(R.layout.activity_game);
    }

    public void clickImage(View view){
        Log.i(this.getClass().getSimpleName(), String.format("Image tag: %s",view.getTag()));

        int index= Integer.parseInt((String) view.getTag());

        gameLogic.processTurn(index / 10 -1,index % 10 - 1);
    }
}
