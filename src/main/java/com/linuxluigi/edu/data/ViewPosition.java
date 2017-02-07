package com.linuxluigi.edu.data;

/**
 * Created by fubu on 07.02.17.
 */
public class ViewPosition {
    private int x;
    private int y;
    private final int IconSize = 80;

    public ViewPosition(int x, int y) {
        this.x = x;
        this.y = y;
    }

    public int getX() {
        return x;
    }

    public int getX2() {
        return x;
    }

    public void setX(int x) {
        this.x = x + this.IconSize;
    }

    public int getY() {
        return y;
    }

    public void setY2(int y) {
        this.y = y + this.IconSize;
    }

    public void setY(int y) {
        this.y = y;
    }
}
