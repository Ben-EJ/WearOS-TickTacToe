package com.benjaminell.tictactoe;

import android.app.Activity;
import android.widget.Button;

import java.util.ArrayList;

public class GameLogic extends Activity {
    public boolean checkDraw(Grid grid) {//Checks to see if the players have drawn.
        for (int i = 0; i < grid.grid.size(); i++) {
            if (grid.grid.get(i).getText() == "") return false;
        }
        return true;
    }

    public boolean checkRow(ArrayList<Button> line, String currentPlayer) {// Checks a row to see if all symbols match.
        return line.get(0).getText() == currentPlayer &&
               line.get(1).getText() == currentPlayer &&
               line.get(2).getText() == currentPlayer;
    }

    public String checkWin(Grid grid) {// Checks to see which player won.
        String[] players = {"X", "O"};
        for (String player : players) {
            if (checkRow(grid.row1, player) == true) return player;
            else if (checkRow(grid.row2, player) == true) return player;
            else if (checkRow(grid.row3, player) == true) return player;
            else if (checkRow(grid.column1, player) == true) return player;
            else if (checkRow(grid.column2, player) == true) return player;
            else if (checkRow(grid.column3, player) == true) return player;
            else if (checkRow(grid.diagonalLeftRight, player) == true) return player;
            else if (checkRow(grid.diagonalRightLeft, player) == true) return player;
        }
        return "";
    }
}

