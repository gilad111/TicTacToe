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
        onNewGame();
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
        for (int i = 0; i < 3; i++) {
            if (board[i][0].equals(board[i][1]) && board[i][1].equals(board[i][2]) && !board[i][0].equals("")) {
                return true; // Row win
            }
            if (board[0][i].equals(board[1][i]) && board[1][i].equals(board[2][i]) && !board[0][i].equals("")) {
                return true; // Column win
            }
        }

        // Check diagonals
        if (board[0][0].equals(board[1][1]) && board[1][1].equals(board[2][2]) && !board[0][0].equals("")) {
            return true; // Diagonal win
        }
        if (board[0][2].equals(board[1][1]) && board[1][1].equals(board[2][0]) && !board[0][2].equals("")) {
            return true; // Diagonal win
        }

        return false; // No win
    }

    private void endGame (String st)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("We have a winner!");
        String msg = "The winner is: " +st;
        if(st.equals("Tie"))
        {
            builder.setTitle("We got a tie");
             msg = "The result is : " +st;
        }

        builder.setMessage(msg);
        builder.setPositiveButton("EXIT", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
// Exit handling
                onDestroy();

            }
        });
        builder.setNegativeButton("Restart", new DialogInterface.OnClickListener() {
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
        Log.e(TAG, "alert");
        int id = view.getId();

        if (id == R.id.btn_00) {
            handleClick(0, 0, R.id.btn_00);
        } else if (id == R.id.btn_01) {
            handleClick(0, 1, R.id.btn_01);
        } else if (id == R.id.btn_02) {
            handleClick(0, 2, R.id.btn_02);
        } else if (id == R.id.btn_10) {
            handleClick(1, 0, R.id.btn_10);
        } else if (id == R.id.btn_11) {
            handleClick(1, 1, R.id.btn_11);
        } else if (id == R.id.btn_12) {
            handleClick(1, 2, R.id.btn_12);
        } else if (id == R.id.btn_20) {
            handleClick(2, 0, R.id.btn_20);
        } else if (id == R.id.btn_21) {
            handleClick(2, 1, R.id.btn_21);
        } else if (id == R.id.btn_22) {
            handleClick(2, 2, R.id.btn_22);
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
