package com.datastructure.structure;

import java.util.ArrayList;
import java.util.List;

/**
 * @author dzl
 * 2020/10/14 14:31
 * @Description
 */
public class Cell {
    private int x;
    private int y;
    // 是否是路障
    private boolean RoadBlockFlag;
    // 是否已经走过
    private boolean goneFlag = false;

    private int step;

    private List<Cell> xs = new ArrayList<>();

    private Cell lastCell;



    public Cell(int x, int y, boolean roadBlockFlag) {
        this.x = x;
        this.y = y;
        RoadBlockFlag = roadBlockFlag;

    }

    public int getX() {
        return x;
    }

    public void setX(int x) {
        this.x = x;
    }

    public int getY() {
        return y;
    }

    public void setY(int y) {
        this.y = y;
    }

    public boolean isRoadBlockFlag() {
        return RoadBlockFlag;
    }

    public void setRoadBlockFlag(boolean roadBlockFlag) {
        RoadBlockFlag = roadBlockFlag;
    }

    public boolean isGoneFlag() {
        return goneFlag;
    }

    public void setGoneFlag(boolean goneFlag) {
        this.goneFlag = goneFlag;
    }


    public int getStep() {
        return step;
    }

    public void setStep(int step) {
        this.step = step;
    }

    public List<Cell> getXs() {
        return xs;
    }

    public void setXs(Cell xs) {
        this.xs.add(xs);
    }
    public void remove(Cell x) {
        this.xs.remove(x);
    }

    public Cell getLastCell() {
        return lastCell;
    }

    public void setLastCell(Cell lastCell) {
        this.lastCell = lastCell;
    }

    @Override
    public String toString() {
        return "Cell{" +
                "x=" + x +
                ", y=" + y +
                '}';
    }
}

