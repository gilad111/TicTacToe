package com.example.tictactoe;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

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

    private boolean isWinner()
    {

    }

    private void endGame (String st)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("More Info");
        String msg = "This is the message body";
        builder.setMessage(msg);
        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
// Exit handling

            }
        });
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
// Cancel handling

            }
        });
        AlertDialog dialog = builder.show();

    }

    private void onTurnEnd() {
        // בדיקה האם יש מנצח - חשוב לבצע לפני הבדיקה אם הלוח מלא
        if (isWinner())
            endGame(turn + " won!");
        else {
            count++;
            // בדיקת מצב לוח מלא (תיקו)
            if (count == 9)
                endGame("Tie");
            else {
                // העברת התור
                turn = (turn.equals("X") ? "O" : "X");
            }
        }
    }

    private void handleClick(int row, int col, int id) {
        if (board[row][col].equals("")) {
            board[row][col] = turn;
            Button btn = findViewById(id);
            btn.setText(turn);
            onTurnEnd();
        }
    }


    public void onButtonClick(View view) {
        switch (view.getId()) {
            case R.id.btn_00:
                handleClick(0, 0, R.id.btn_00);
                break;
            case R.id.btn_01:
                handleClick(0, 1, R.id.btn_01);
                break;
            case R.id.btn_02:
                handleClick(0, 2, R.id.btn_02);
                break;
            case R.id.btn_03:
                handleClick(1, 0, R.id.btn_03);
                break;
            case R.id.btn_04:
                handleClick(1, 1, R.id.btn_04);
                break;
            case R.id.btn_05:
                handleClick(1, 2, R.id.btn_05);
                break;
            case R.id.btn_06:
                handleClick(2, 0, R.id.btn_06);
                break;
            case R.id.btn_07:
                handleClick(2, 1, R.id.btn_07);
                break;
            case R.id.btn_08:
                handleClick(2, 2, R.id.btn_08);
                break;
        }
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
