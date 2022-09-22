package model;

import static model.EntityCode.fromBoolean;
import static model.EntityCode.processEntityCode;

public class GridLoadSave {

    //load a grid from a string : each character of the string is a cell state
    // we process each character of the string, we convert it to an enum type and set the state
    // of the cell to the value of the enum
    public Cell[][]  loadGridFromString(String string){
        String[] tab;
        tab = string.split("\n");
        int width = tab[0].length();
        int height = tab.length;
        Cell[][] grid = GameBoard.EmptyGameBoard(width, height);
        for (int i = 0;i<width ;i++){
            for (int j = 0 ; j<height ;j++) {
                try {
                    grid[i][j] = new Cell();
                    grid[i][j].setState(processEntityCode(EntityCode.fromCode(tab[j].charAt(i))));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        }
        return grid;
    }

    //save a grid to a string : each character of the string is a cell state
    // backward process of the loadGridFromString method
    public String saveGridToString(Cell[][] grid) throws Exception {
        StringBuilder str = new StringBuilder();
        for (Cell[] cells : grid) {
            for (int j = 0; j < grid[0].length; j++) {
                str.append(fromBoolean(cells[j].isAlive()));
            }
            str.append("\n");
        }
        return str.toString();

    }


}
