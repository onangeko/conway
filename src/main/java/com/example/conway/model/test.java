package com.example.conway.model;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        GameBoard gm = new GameBoard(10,10);
        System.out.println(Arrays.deepToString(gm.getGrid()));
        System.out.println(gm.getColumns());
        System.out.println(gm.getRows());
        System.out.println(gm.getCell(5,5));
        gm.countAliveCellNeighbors(5,5);
        System.out.println(gm.getCell(5,5).getAliveNeighbors());

    }
}



