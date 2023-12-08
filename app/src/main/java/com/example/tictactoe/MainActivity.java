package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;

public class MainActivity extends AppCompatActivity {
    String turn;
    String[][] board;
    int count;

    private static final String TAG = "MainActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.e(TAG,  "MainActivity::OnCreate");
    }

    @Override
    protected void onStart() {
        // Call the superclass method first.
        super.onStart();
        Log.e(TAG, "MainActivity::OnStart");
    }

    @Override
    protected void onResume() {
        // users returns to the activity
        super.onResume();
        Log.e(TAG, "MainActivity::OnResume");
    }

    @Override
    protected void onPause() {
        // pause the activity and it is no longer available.
        super.onPause();
        Log.e(TAG, "MainActivity::OnPause");
    }

    @Override
    protected void onRestart() {
        // restarts the activity.
        super.onRestart();
        Log.e(TAG, "MainActivity::OnRestart");
    }

    @Override
    protected void onStop() {
        // the activity is no longer visible.
        super.onStop();
        Log.e(TAG, "MainActivity::OnStop");
    }

    @Override
    protected void onDestroy() {
        // the activity is finishing or being destroyed by the system.
        super.onDestroy();
        Log.e(TAG, "MainActivity::OnDestroy");
    }

    public void onButtonClick(View view) {

    }

    private void onNewGame() {
        board = new String[3][3];
        for (int row=0; row < 3; row++)
            for (int col=0; col < 3; col++)
                board[row][col] = new String();

        turn = "X";
        count = 0;
    }

}
