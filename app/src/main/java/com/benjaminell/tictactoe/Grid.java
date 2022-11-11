package com.benjaminell.tictactoe;

import android.app.Activity;
import android.widget.Button;

import java.util.ArrayList;

//Class handles the game grid.

public class Grid extends Activity {
    ArrayList<Button> grid = new ArrayList<Button>();
    ArrayList<Button> row1 = new ArrayList<Button>();
    ArrayList<Button> row2 = new ArrayList<Button>();
    ArrayList<Button> row3 = new ArrayList<Button>();

    ArrayList<Button> column1 = new ArrayList<Button>();
    ArrayList<Button> column2 = new ArrayList<Button>();
    ArrayList<Button> column3 = new ArrayList<Button>();

    ArrayList<Button> diagonalLeftRight = new ArrayList<Button>();
    ArrayList<Button> diagonalRightLeft = new ArrayList<Button>();

    public void resetGrid() {// Resets each field in grid.
        for (int i = 0; i < grid.size(); i++) {
            grid.get(i).setText("");
        }
    }

    // Next set of functions initialise grid.
    public void constructGrid() {
        grid.addAll(row1);
        grid.addAll(row2);
        grid.addAll(row3);

        grid.addAll(column1);
        grid.addAll(column2);
        grid.addAll(column3);

        grid.addAll(diagonalLeftRight);
        grid.addAll(diagonalRightLeft);
    }

    public void initRow1(Button tile1, Button tile2, Button tile3) {
        row1.add(tile1);
        row1.add(tile2);
        row1.add(tile3);
    }

    public void initRow2(Button tile1, Button tile2, Button tile3) {
        row2.add(tile1);
        row2.add(tile2);
        row2.add(tile3);
    }

    public void initRow3(Button tile1, Button tile2, Button tile3) {
        row3.add(tile1);
        row3.add(tile2);
        row3.add(tile3);
    }

    public void initColumn1(Button tile1, Button tile2, Button tile3) {
        column1.add(tile1);
        column1.add(tile2);
        column1.add(tile3);
    }

    public void initColumn2(Button tile1, Button tile2, Button tile3) {
        column2.add(tile1);
        column2.add(tile2);
        column2.add(tile3);
    }

    public void initColumn3(Button tile1, Button tile2, Button tile3) {
        column3.add(tile1);
        column3.add(tile2);
        column3.add(tile3);
    }

    public void initDiagonalLeftRight(Button tile1, Button tile2, Button tile3) {
        diagonalLeftRight.add(tile1);
        diagonalLeftRight.add(tile2);
        diagonalLeftRight.add(tile3);
    }

    public void initDiagonalRightLeft(Button tile1, Button tile2, Button tile3) {
        diagonalRightLeft.add(tile1);
        diagonalRightLeft.add(tile2);
        diagonalRightLeft.add(tile3);
    }
}
