package com.benjaminell.tictactoe;

import android.app.Activity;

public class GameLogic extends Activity {
    public boolean checkDraw(Grid grid){
        for (int i = 0; i < grid.grid.size(); i++){
            if(grid.grid.get(i).getText() == ""){
                return false;
            }
        }
        return true;
    }
    public String checkWin(Grid grid) {
        String[] players = {"X", "O"};
        for (int i = 0; i < players.length; i++) {
            if (grid.row1.get(0).getText() == players[i] &&
                    grid.row1.get(1).getText() == players[i] &&
                    grid.row1.get(2).getText() == players[i]) {
                return players[i];
            }
        }

        for (int i = 0; i < players.length; i++) {
            if (grid.row2.get(0).getText() == players[i] &&
                    grid.row2.get(1).getText() == players[i] &&
                    grid.row2.get(2).getText() == players[i]) {
                return players[i];
            }
        }

        for (int i = 0; i < players.length; i++) {
            if (grid.row3.get(0).getText() == players[i] &&
                    grid.row3.get(1).getText() == players[i] &&
                    grid.row3.get(2).getText() == players[i]) {
                return players[i];
            }
        }

        for (int i = 0; i < players.length; i++) {
            if (grid.column1.get(0).getText() == players[i] &&
                    grid.column1.get(1).getText() == players[i] &&
                    grid.column1.get(2).getText() == players[i]) {
                return players[i];
            }
        }

        for (int i = 0; i < players.length; i++) {
            if (grid.column2.get(0).getText() == players[i] &&
                    grid.column2.get(1).getText() == players[i] &&
                    grid.column2.get(2).getText() == players[i]) {
                return players[i];
            }
        }

        for (int i = 0; i < players.length; i++) {
            if (grid.column3.get(0).getText() == players[i] &&
                    grid.column3.get(1).getText() == players[i] &&
                    grid.column3.get(2).getText() == players[i]) {
                return players[i];
            }
        }

        for (int i = 0; i < players.length; i++) {
            if (grid.diagonalLeftRight.get(0).getText() == players[i] &&
                    grid.diagonalLeftRight.get(1).getText() == players[i] &&
                    grid.diagonalLeftRight.get(2).getText() == players[i]) {
                return players[i];
            }
        }

        for (int i = 0; i < players.length; i++) {
            if (grid.diagonalRightLeft.get(0).getText() == players[i] &&
                    grid.diagonalRightLeft.get(1).getText() == players[i] &&
                    grid.diagonalRightLeft.get(2).getText() == players[i]) {
                return players[i];
            }
        }
        return "";
    }
}

