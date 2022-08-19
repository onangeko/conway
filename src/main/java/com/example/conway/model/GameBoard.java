package com.example.conway.model;

public class GameBoard {

    private Cell[][] grid;
    private int rows;
    private int columns;

    public GameBoard(int rows, int columns) {
        grid  = new Cell[rows][columns];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                grid[y][x] = new Cell();
            }
        }

    }

    public Cell[][] getGrid() {
        return grid;
    }

    public void setGrid(Cell[][] grid) {
        this.grid = grid;
    }

    public int getRows() {
        return rows;
    }

    public void setRows(int rows) {
        this.rows = rows;
    }

    public int getColumns() {
        return columns;
    }

    public Cell getCell(int i, int j) {
        return grid[j][i];
    }

    public void setColumns(int columns) {
        this.columns = columns;
    }

    private void countCellNeighbors(int x ,int y){
    int aliveNeighbors = 0;
    Cell givenCell = grid[x][y];
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++){

            }

            }

        }

    private void updateGrid(){

    }



}
