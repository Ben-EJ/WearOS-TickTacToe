package com.benjaminell.tictactoe;

import android.app.Activity;
import android.widget.Button;

import java.util.ArrayList;

public class AILogic extends Activity {
    public boolean ruleTryWin(ArrayList<Button> line){
        if(line.get(0).getText() == "O" && line.get(1).getText() == "O" && line.get(2).getText() == ""){
            line.get(2).setText("O");
            return true;
        }
        if(line.get(1).getText() == "O" && line.get(2).getText() == "O" && line.get(0).getText() == ""){
            line.get(0).setText("O");
            return true;
        }
        if(line.get(0).getText() == "O" && line.get(2).getText() == "O" && line.get(1).getText() == ""){
            line.get(1).setText("O");
            return true;
        }
        return false;
    }
    public boolean ruleBlockPlayer(ArrayList<Button> line){
        if(line.get(0).getText() == "X" && line.get(1).getText() == "X" && line.get(2).getText() == ""){
            line.get(2).setText("O");
            return true;
        }
        if(line.get(1).getText() == "X" && line.get(2).getText() == "X" && line.get(0).getText() == ""){
            line.get(0).setText("O");
            return true;
        }
        if(line.get(0).getText() == "X" && line.get(2).getText() == "X" && line.get(1).getText() == ""){
            line.get(1).setText("O");
            return true;
        }
        return false;
    }
    public boolean ruleSetUpWin(ArrayList<Button> line){
        if(line.get(0).getText() == "" && line.get(1).getText() == "" && line.get(2).getText() == "O"){
            line.get(1).setText("O");
            return true;
        }
        if(line.get(0).getText() == "O" && line.get(1).getText() == "" && line.get(2).getText() == ""){
            line.get(1).setText("O");
            return true;
        }
        if(line.get(0).getText() == "" && line.get(1).getText() == "O" && line.get(2).getText() == ""){
            line.get(2).setText("O");
            return true;
        }
        return false;
    }
    public boolean ruleNextEmpty(ArrayList<Button> grid){
        for(int i = 0; i < grid.size(); i++){
            if(grid.get(i).getText() == ""){
                grid.get(i).setText("O");
                return true;
            }
        }
        return false;
    }

    public boolean aiMakeMove(Grid grid, boolean enableWinRule,boolean enableBlockPlayerRule, boolean enableSetUpWinRule){
        if(enableWinRule == true) {
            if (ruleTryWin(grid.row1) == true) {
                System.out.println("row1 WIN");
                return true;
            } else if (ruleTryWin(grid.row2) == true) {
                System.out.println("row2 WIN");
                return true;
            } else if (ruleTryWin(grid.row3) == true) {
                System.out.println("row3 WIN");
                return true;
            } else if (ruleTryWin(grid.column1) == true) {
                System.out.println("column1 WIN");
                return true;
            } else if (ruleTryWin(grid.column2) == true) {
                System.out.println("column2 WIN");
                return true;
            } else if (ruleTryWin(grid.column3) == true) {
                System.out.println("column3 WIN");
                return true;
            } else if (ruleTryWin(grid.diagonalLeftRight) == true) {
                System.out.println("diagonalLeftRight WIN");
                return true;
            } else if (ruleTryWin(grid.diagonalRightLeft) == true) {
                System.out.println("diagonalRightLeft WIN");
                return true;
            }
        }
        if(enableBlockPlayerRule == true) {
            if (ruleBlockPlayer(grid.row1) == true) {
                System.out.println("row1 Block");
                return true;
            } else if (ruleBlockPlayer(grid.row2) == true) {
                System.out.println("row2 Block");
                return true;
            } else if (ruleBlockPlayer(grid.row3) == true) {
                System.out.println("row3 Block");
                return true;
            } else if (ruleBlockPlayer(grid.column1) == true) {
                System.out.println("column1 Block");
                return true;
            } else if (ruleBlockPlayer(grid.column2) == true) {
                System.out.println("column2 Block");
                return true;
            } else if (ruleBlockPlayer(grid.column3) == true) {
                System.out.println("column3 Block");
                return true;
            } else if (ruleBlockPlayer(grid.diagonalLeftRight) == true) {
                System.out.println("diagonalLeftRight Block");
                return true;
            } else if (ruleBlockPlayer(grid.diagonalRightLeft) == true) {
                System.out.println("diagonalRightLeft Block");
                return true;
            }
        }
        if(enableSetUpWinRule == true) {
            if (ruleSetUpWin(grid.row1) == true) {
                System.out.println("row1 ruleSetUpWin");
                return true;
            } else if (ruleSetUpWin(grid.row2) == true) {
                System.out.println("row2 ruleSetUpWin");
                return true;
            } else if (ruleSetUpWin(grid.row3) == true) {
                System.out.println("row3 ruleSetUpWin");
                return true;
            } else if (ruleSetUpWin(grid.column1) == true) {
                System.out.println("column1 ruleSetUpWin");
                return true;
            } else if (ruleSetUpWin(grid.column2) == true) {
                System.out.println("column2 ruleSetUpWin");
                return true;
            } else if (ruleSetUpWin(grid.column3) == true) {
                System.out.println("column3 ruleSetUpWin");
                return true;
            } else if (ruleSetUpWin(grid.diagonalLeftRight) == true) {
                System.out.println("diagonalLeftRight ruleSetUpWin");
                return true;
            } else if (ruleSetUpWin(grid.diagonalRightLeft) == true) {
                System.out.println("diagonalRightLeft ruleSetUpWin");
                return true;
            }
        }

        if (ruleNextEmpty(grid.grid) == true) {
            System.out.println("Next Empty");
            return true;
        }
        return false;
    }
}
