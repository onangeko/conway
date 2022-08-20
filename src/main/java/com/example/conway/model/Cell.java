package com.example.conway.model;

import java.util.Random;


public class Cell {
    Random random = new Random();
    private boolean isAlive = random.nextBoolean();
    private int aliveNeighbors = 0;

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean alive) {
        isAlive = true;
    }

    public int getAliveNeighbors() {
        return aliveNeighbors;
    }

    public void setAliveNeighbors(int neighbors) {
        this.aliveNeighbors = neighbors;
    }




}
