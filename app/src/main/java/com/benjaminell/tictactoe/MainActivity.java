package com.benjaminell.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;
import java.util.Arrays;

import com.benjaminell.tictactoe.databinding.ActivityMainBinding;

public class MainActivity extends Activity {
    private ActivityMainBinding binding;

    private TextView turnText;
    private TextView winText;
    private ConstraintLayout gameBox;
    private ConstraintLayout winScreen;

    private Grid grid = new Grid();
    private GameLogic gameLogic = new GameLogic();

    private boolean aiOn = false;
    private boolean playerTurn = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gameBox = binding.GameBox;
        winScreen = binding.WinScreen;

        gameBox.setVisibility(View.VISIBLE);
        winScreen.setVisibility(View.INVISIBLE);

        turnText = binding.turnText;
        winText = binding.winText;

        grid.initRow1(binding.tile1, binding.tile2, binding.tile3);
        grid.initRow2(binding.tile4, binding.tile5, binding.tile6);
        grid.initRow3(binding.tile7, binding.tile8, binding.tile9);

        grid.initColumn1(binding.tile1, binding.tile4, binding.tile7);
        grid.initColumn2(binding.tile2, binding.tile5, binding.tile8);
        grid.initColumn3(binding.tile3, binding.tile6, binding.tile9);

        grid.initDiagonalLeftRight(binding.tile1, binding.tile5, binding.tile9);
        grid.initDiagonalRightLeft(binding.tile3, binding.tile5, binding.tile7);

        grid.constructGrid();

        turnText.setText("Turn: X");
    }

    private void hasWon() {
        String hasWon = gameLogic.checkWin(grid);
        if (hasWon == "X") {
            gameBox.setVisibility(View.INVISIBLE);
            winText.setText(hasWon + " Wins");
            winScreen.setVisibility(View.VISIBLE);
        } else if (hasWon == "O") {
            gameBox.setVisibility(View.INVISIBLE);
            winText.setText(hasWon + " Wins");
            winScreen.setVisibility(View.VISIBLE);
        }
    }
    private void hasDrawn(){
        if(gameLogic.checkDraw(grid) == true){
            gameBox.setVisibility(View.INVISIBLE);
            winText.setText("Draw");
            winScreen.setVisibility(View.VISIBLE);
        }
    }
    public void resetBtn(View view) {
        grid.resetGrid();
        playerTurn = true;
    }
    public void winOkBtn(View view){
        grid.resetGrid();
        winText.setText("");
        winScreen.setVisibility(View.INVISIBLE);
        gameBox.setVisibility(View.VISIBLE);
    }
    public void tile1Clicked(View view) {
        if (aiOn == false) {
            if (grid.row1.get(0).getText() == "") {
                if (playerTurn == true) {
                    grid.row1.get(0).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row1.get(0).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }

    public void tile2Clicked(View view) {
        if (aiOn == false) {
            if (grid.row1.get(1).getText() == "") {
                if (playerTurn == true) {
                    grid.row1.get(1).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row1.get(1).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }

    public void tile3Clicked(View view) {
        if (aiOn == false) {
            if (grid.row1.get(2).getText() == "") {
                if (playerTurn == true) {
                    grid.row1.get(2).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row1.get(2).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }

    public void tile4Clicked(View view) {
        if (aiOn == false) {
            if (grid.row2.get(0).getText() == "") {
                if (playerTurn == true) {
                    grid.row2.get(0).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row2.get(0).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }

    public void tile5Clicked(View view) {
        if (aiOn == false) {
            if (grid.row2.get(1).getText() == "") {
                if (playerTurn == true) {
                    grid.row2.get(1).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row2.get(1).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }

    public void tile6Clicked(View view) {
        if (aiOn == false) {
            if (grid.row2.get(2).getText() == "") {
                if (playerTurn == true) {
                    grid.row2.get(2).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row2.get(2).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }

    public void tile7Clicked(View view) {
        if (aiOn == false) {
            if (grid.row3.get(0).getText() == "") {
                if (playerTurn == true) {
                    grid.row3.get(0).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row3.get(0).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }

    public void tile8Clicked(View view) {
        if (aiOn == false) {
            if (grid.row3.get(1).getText() == "") {
                if (playerTurn == true) {
                    grid.row3.get(1).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row3.get(1).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }

    public void tile9Clicked(View view) {
        if (aiOn == false) {
            if (grid.row3.get(2).getText() == "") {
                if (playerTurn == true) {
                    grid.row3.get(2).setText("X");
                    playerTurn = false;
                    turnText.setText("Turn: O");
                } else {
                    grid.row3.get(2).setText("O");
                    playerTurn = true;
                    turnText.setText("Turn: X");
                }
            }
        }
        hasWon();
        hasDrawn();
    }
}