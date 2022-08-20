package com.example.conway.model;

import java.util.Arrays;

public class test {

    public static void main(String[] args) {
        GameBoard gm = new GameBoard(4,4);
        System.out.println(Arrays.deepToString(gm.getGrid()));
        gm.updateGrid();
        System.out.println(Arrays.deepToString(gm.getGrid()));
        System.out.println("oui");

    }
}



