package com.benjaminell.tictactoe;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Switch;
import android.widget.TextView;

import androidx.constraintlayout.widget.ConstraintLayout;

import com.benjaminell.tictactoe.databinding.ActivityMainBinding;

import java.util.ArrayList;

public class MainActivity extends Activity {
    private ActivityMainBinding binding;

    private TextView turnText;
    private TextView winText;

    private Switch winRuleSwitch;
    private Switch blockPlayerRuleSwitch;
    private Switch setUpWinRuleSwitch;

    private ConstraintLayout gameBox;
    private ConstraintLayout winScreen;
    private ConstraintLayout mainMenu;
    private ConstraintLayout aboutMenu;
    private  ConstraintLayout aiSettingsMenu;

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
        aiSettingsMenu = binding.AISettingsMenu;

        winRuleSwitch = binding.winRuleSwitch;
        blockPlayerRuleSwitch = binding.blockPlayerRuleSwitch;
        setUpWinRuleSwitch = binding.setUpWinRuleSwitch;

        mainMenu.setVisibility(View.VISIBLE);
        gameBox.setVisibility(View.GONE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
        aiSettingsMenu.setVisibility(View.GONE);

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

    public void playBtn(View view) {//Handles what happens when the play button is clicked.
        mainMenu.setVisibility(View.GONE);
        gameBox.setVisibility(View.VISIBLE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
        aiSettingsMenu.setVisibility(View.GONE);
        aiOnFlag = false;
    }

    public void playAIBtn(View view) {//Handles what happens when the play AI button is clicked.
        mainMenu.setVisibility(View.GONE);
        gameBox.setVisibility(View.VISIBLE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
        aiSettingsMenu.setVisibility(View.GONE);
        aiOnFlag = true;
    }

    public void aboutBtn(View view) {//Handles what happens when the about button is clicked.
        mainMenu.setVisibility(View.GONE);
        gameBox.setVisibility(View.GONE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.VISIBLE);
        aiSettingsMenu.setVisibility(View.GONE);
    }

    public void aboutBackBtn(View view) {//Handles what happens when the back button in the about menu is clicked.
        mainMenu.setVisibility(View.VISIBLE);
        gameBox.setVisibility(View.GONE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
        aiSettingsMenu.setVisibility(View.GONE);
    }
    public void aiMenuBtn(View view) {//Handles what happens when the Ai settings menu button is clicked.
        mainMenu.setVisibility(View.GONE);
        gameBox.setVisibility(View.GONE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
        aiSettingsMenu.setVisibility(View.VISIBLE);
    }

    public void aiMenuBackBtn(View view) {//Handles what happens when the back button in the ai settings menu is clicked.
        mainMenu.setVisibility(View.VISIBLE);
        gameBox.setVisibility(View.GONE);
        winScreen.setVisibility(View.GONE);
        aboutMenu.setVisibility(View.GONE);
        aiSettingsMenu.setVisibility(View.GONE);
    }

    private void hasWon() {// Checks to see which player won and sets visibility of game objects also sets ending text.
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

    private void hasDrawn() {//Checks to see if the players have drawn and sets visibility of game objects also sets ending text.
        if (gameLogic.checkDraw(grid) == true) {
            gameBox.setVisibility(View.GONE);
            winText.setText("Draw");
            winScreen.setVisibility(View.VISIBLE);
        }
    }

    public void resetBtn(View view) {//Function resets the game board.
        grid.resetGrid();
        playerTurnFlag = true;
    }

    public void winOkBtn(View view) {//Handles what happens when the ok button is clicked.
        playerTurnFlag = true;
        grid.resetGrid();
        winText.setText("");
        winScreen.setVisibility(View.GONE);
        mainMenu.setVisibility(View.VISIBLE);
    }

    public void moves(ArrayList<Button> line,int square){// Handles player moves.
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
                ai.aiMakeMove(grid,winRuleSwitch.isChecked(),blockPlayerRuleSwitch.isChecked(),setUpWinRuleSwitch.isChecked());
                playerTurnFlag = true;
                turnText.setText("Turn: X");
            }
        }
        hasWon();
        hasDrawn();
    }
    //These functions handle what happens when a button on the game grid is clicked.
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