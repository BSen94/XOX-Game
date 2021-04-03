package com.bilgeadam.xox.fragments;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import com.bilgeadam.xox.R;
import com.bilgeadam.xox.activities.GameActivity;
import com.bilgeadam.xox.game.Logic;


public class GameInfo extends Fragment {

    private TextView currentPlayer, currentTurn;
    public Logic gameLogic;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View gameInfoView = inflater.inflate(R.layout.fragment_game_info, container, false);


       gameLogic=(Logic) getArguments().getSerializable(GameActivity.GAME_KEY);


        currentPlayer=gameInfoView.findViewById(R.id.current_player);
        currentPlayer.setText(String.format(getString(R.string.current_player),gameLogic.getCurrentPlayer()));


        currentTurn = gameInfoView.findViewById(R.id.current_turn);
        currentTurn.setText(String.format(getString(R.string.current_turn), gameLogic.getCurrentPlayer().getCurrentTurn()));

        return gameInfoView;
    }
}
