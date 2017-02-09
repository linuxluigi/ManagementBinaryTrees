/*
 * Copyright 2017 Stefen Exler
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.linuxluigi.edu.data;


/**
 * Object um die Position der Knoten zu sichern
 */
public class ViewPosition {
    private int x;
    private int y;
    private int iconSize;

    /**
     * Konstruktor um die Position der Knoten zu sichern
     * @param x         Startwert auf der X-Achse
     * @param y         Startwert auf der Y-Achse
     * @param IconSize  Größe des verwendeten Icons
     */
    public ViewPosition(int x, int y, int IconSize) {
        this.x = x;
        this.y = y;
        this.iconSize = IconSize;
    }

    /**
     * Gibt den Startwert der X-Achse zurück
     * @return  Startwert der X-Achse
     */
    public int getX() {
        return this.x;
    }

    /**
     * Gibt den Startwert der Y-Achse zurück
     * @return  Startwert der Y-Achse
     */
    public int getY() {
        return this.y;
    }


    /**
     * Gibt die Mitte des Objektes auf der X-Achse zurück
     * @return  Mitte des Objektes auf der X-Achse
     */
    public int getMiddleX() {
        return this.x + this.iconSize / 2;
    }

    /**
     * Gibt den Endwert der Y-Achse zurück
     * @return  Endwert der Y-Achse
     */
    public int getY2() {
        return this.y + this.iconSize;
    }


    /**
     * Gibt die Pixel Größe des Icons zurück
     * @return  Pixel Größe des Icons als INT
     */
    public int getIconSize() {
        return this.iconSize;
    }
}
