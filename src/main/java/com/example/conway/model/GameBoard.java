package com.example.conway.model;

public class GameBoard {

    private Cell[][] grid;
    private int rows;
    private int columns;

    public GameBoard(int rows, int columns) {
        this.setRows(rows);
        this.setColumns(columns);
        grid  = new Cell[rows][columns];
        for (int y = 0; y < rows; y++) {
            for (int x = 0; x < columns; x++) {
                grid[y][x] = new Cell();
            }
        }
        this.setGrid(grid);

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

    public void countAliveCellNeighbors(int x ,int y){
    int aliveNeighbors = 0;
    Cell givenCell = grid[x][y];
        for (int i = x - 1; i <= x + 1; i++) {
            for (int j = y - 1; j <= y + 1; j++){
                if (i >= 0 && i < columns && j>=0 && j <rows){
                    if (grid[i][j].isAlive() && grid[i][j]!=grid[x][y]){
                        aliveNeighbors++;
                    }
                }
            }
        }
        givenCell.setAliveNeighbors(aliveNeighbors);
    }

    public void updateGrid() {

        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                countAliveCellNeighbors(x, y);
            }
        }
        for (int x = 0; x < rows; x++) {
            for (int y = 0; y < columns; y++) {
                if (grid[x][y].isAlive()) {
                    if (grid[x][y].getAliveNeighbors() < 2 || grid[x][y].getAliveNeighbors() > 3) {
                        grid[x][y].setState(false);
                    }
                }
                if (!grid[x][y].isAlive()){
                    if (grid[x][y].getAliveNeighbors() == 3) {
                        grid[x][y].setState(true);
                    }
                }
            }
        }
    }






}
