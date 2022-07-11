package com.benjaminell.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.benjaminell.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ActivityMainBinding binding;

    private TextView turnText;
    private TextView winText;

    private ConstraintLayout gameBox;
    private ConstraintLayout winScreen;
    private ConstraintLayout mainMenu;
    private ConstraintLayout aboutMenu;

    private Grid grid = new Grid();
    private GameLogic gameLogic = new GameLogic();
    private AILogic ai = new AILogic();

    private boolean aiOnFlag = false;
    private boolean playerTurnFlag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        gameBox = binding.GameBox;
        winScreen = binding.WinScreen;
        mainMenu = binding.MainMenu;
        aboutMenu = binding.AboutMenu;

        mainMenu.setVisibility(View.VISIBLE);
        gameBox.setVisibility(View.GONE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);

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

    public void playBtn(View view) {
        mainMenu.setVisibility(View.GONE);
        gameBox.setVisibility(View.VISIBLE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
    }

    public void playAIBtn(View view) {
        mainMenu.setVisibility(View.GONE);
        gameBox.setVisibility(View.VISIBLE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
        aiOnFlag = true;
    }

    public void aboutBtn(View view) {
        mainMenu.setVisibility(View.GONE);
        gameBox.setVisibility(View.GONE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.VISIBLE);
    }

    public void aboutBackBtn(View view) {
        mainMenu.setVisibility(View.VISIBLE);
        gameBox.setVisibility(View.GONE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
    }

    private void hasWon() {
        String hasWon = gameLogic.checkWin(grid);
        if (hasWon == "X") {
            gameBox.setVisibility(View.GONE);
            winText.setText(hasWon + " Wins");
            winScreen.setVisibility(View.VISIBLE);
        } else if (hasWon == "O") {
            gameBox.setVisibility(View.GONE);
            winText.setText(hasWon + " Wins");
            winScreen.setVisibility(View.VISIBLE);
        }
    }

    private void hasDrawn() {
        if (gameLogic.checkDraw(grid) == true) {
            gameBox.setVisibility(View.GONE);
            winText.setText("Draw");
            winScreen.setVisibility(View.VISIBLE);
        }
    }

    public void resetBtn(View view) {
        grid.resetGrid();
        playerTurnFlag = true;
    }

    public void winOkBtn(View view) {
        playerTurnFlag = true;
        grid.resetGrid();
        winText.setText("");
        winScreen.setVisibility(View.GONE);
        mainMenu.setVisibility(View.VISIBLE);
    }

    public void moves(ArrayList<Button> line,int square){
        if (aiOnFlag == false) {
            if (line.get(square).getText() == "") {
                if (playerTurnFlag == true) {
                    line.get(square).setText("X");
                    playerTurnFlag = false;
                    turnText.setText("Turn: O");
                } else {
                    line.get(square).setText("O");
                    playerTurnFlag = true;
                    turnText.setText("Turn: X");
                }
            }
        } else {
            if (line.get(square).getText() == "") {
                if (playerTurnFlag == true) {
                    line.get(square).setText("X");
                    playerTurnFlag = false;
                    turnText.setText("Turn: O");
                }
                ai.aiMakeMove(grid);
                playerTurnFlag = true;
            }
        }
        hasWon();
        hasDrawn();
    }
    public void tile1Clicked(View view) {
        moves(grid.row1, 0);
    }

    public void tile2Clicked(View view) {
        moves(grid.row1, 1);
    }

    public void tile3Clicked(View view) {
        moves(grid.row1, 2);
    }

    public void tile4Clicked(View view) {
        moves(grid.row2, 0);
    }

    public void tile5Clicked(View view) {
        moves(grid.row2, 1);
    }

    public void tile6Clicked(View view) {
        moves(grid.row2, 2);
    }

    public void tile7Clicked(View view) {
        moves(grid.row3, 0);
    }

    public void tile8Clicked(View view) {
        moves(grid.row3, 1);
    }

    public void tile9Clicked(View view) {
        moves(grid.row3, 2);
    }
}