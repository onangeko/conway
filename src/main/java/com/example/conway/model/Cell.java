package com.example.conway.model;

import java.util.Random;


public class Cell {
    Random random = new Random();
    private boolean state = random.nextBoolean(); // cell primary state(dead or alive) is randomized
    private int aliveNeighbors = 0;

    public boolean isAlive() {
        return state;
    }

    public void setState(boolean state) {
        this.state =state;
    }

    public int getAliveNeighbors() {
        return aliveNeighbors;
    }

    public void setAliveNeighbors(int neighbors) {
        this.aliveNeighbors = neighbors;
    }




}
