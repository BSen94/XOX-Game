package com.bilgeadam.xox.activities;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import androidx.annotation.Nullable;
import androidx.fragment.app.FragmentActivity;

import java.lang.reflect.Method;

public class ScoreActivity extends FragmentActivity {
    @Override
    protected void onCreate(@Nullable  Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        startActivity(new Intent(this, WelcomeActivity.class));
    }
}
