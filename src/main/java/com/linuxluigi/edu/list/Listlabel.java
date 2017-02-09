/*
 * Copyright 2017 Stefen Exler
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.linuxluigi.edu.list;

import com.linuxluigi.edu.data.DrawnLines;
import com.linuxluigi.edu.data.ViewPosition;


public interface Listlabel<T> {

    /**
     * Fügt ein neuen Knoten ein
     * @param data Datenobject
     */
    void add(T data);

    /**
     * Fügt ein neuen nach dem Knoten mit der ID index ein Knoten ein
     * @param index Index des Knotens
     * @param data Datenobject
     */
    void add(int index, T data);

    /**
     * Löscht ein Knoten mit dem Index index
     * @param index     Index des zu löschenden Knotens
     */
    void remove(int index);

    /**
     * Löscht alle Knoten aus der Liste
     */
    void clearAll();

    /**
     * Gibt zurück ob die Liste leer ist
     * @return  True  == Liste ohne Knoten
     *          False == in der Liste sind Knoten enthalten
     */
    boolean isEmpty();

    /**
     * Gibt den Wert vom Knoten mit dem Index index
     * @param index     Index des Knotens
     * @return      Daten Objekt
     */
    T get(int index);

    /**
     * Gibt die Anzahl von Knoten zurück
     * @return  Anzahl von Knoten
     */
    int getSize();

    /**
     * Sichert ein Objekt in den Knoten mit den Index index
     * @param index     Index des Knotens
     * @param data      zu sicherendes Objekt
     */
    void set(int index, T data);

    /**
     * Sortiert den Baum nach ASC order DECS
     * @param orderBy   OrderBy.ASC == Sortieren nach ASC
     *                  OrderBy.DESC == Sortieren nach DESC
     */
    void sort(OrderBy orderBy);

    /**
     * Gibt die breite des Baumes in Pixel zurück
     * @return  breite des Baumes
     */
    int getWith();

    /**
     * Gibt die höhe des Baumes in Pixel zurück
     * @return  höhe des Baumes
     */
    int getHigh();

    /**
     * Konvertiert ein String[][] in ein Binärbaum
     * @param binaryTreeArray       zu konvertierendendes String[][]
     */
    void setBinaryTreeFromList(String[][] binaryTreeArray);

    /**
     * Konvertiert ein Binärbaum in ein String[][]
     * @return  konvertierter Binärbaum als String[][]
     */
    String[][] getBinaryList();

    /**
     * Gibt das ViewPosition objekt des Knoten mit dem Index index zurück
     * @param index     Index des Knotens
     * @return          ViewPosition objekt des Knoten mit dem Index
     */
    ViewPosition getViewPosition(int index);

    /**
     * Gibt die Liste DrawnLines zurück
     * @return  Liste DrawnLines
     */
    Listlabel<DrawnLines> getDrawnLines();
}
