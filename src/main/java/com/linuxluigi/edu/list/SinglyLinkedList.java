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


/**
 * Simple Liste
 * @param <T>
 */
public class SinglyLinkedList<T> implements Listlabel<T> {
    private Node head;
    private int size = 0;

    private class Node {
        public T data;
        public Node next;
    }

    /**
     * Fügt ein neuen Knoten ein
     * @param data Datenobject
     */
    public void add(T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.next = null;

        if (this.head == null) {
            this.head = newNode;
        } else {
            Node temp = this.head;

            while (temp.next != null) {
                temp = temp.next;
            }

            temp.next = newNode;
        }

        this.size++;
    }


    /**
     * Löscht alle Knoten aus der Liste
     */
    public void clearAll() {
        this.head = null;
        this.size = 0;
    }

    /**
     * Gibt zurück ob die Liste leer ist
     * @return  True  == Liste ohne Knoten
     *          False == in der Liste sind Knoten enthalten
     */
    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

    /**
     * Gibt den Wert vom Knoten mit dem Index index
     * @param index     Index des Knotens
     * @return      Daten Objekt
     */
    public T get(int index) {
        if (index >= 0 && index < this.size) {
            Node temp = this.head;

            while (index > 0) {
                temp = temp.next;
                index--;
            }

            return temp.data;
        } else {
            throw new IndexOutOfBoundsException("The index:" + index + "  is out of bounds");
        }
    }

    /**
     * Gibt die Anzahl von Knoten zurück
     * @return  Anzahl von Knoten
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Fügt ein neuen nach dem Knoten mit der ID index ein Knoten ein
     * @param index Index des Knotens
     * @param data Datenobject
     */
    public void add(int index, T data) {

    }

    /**
     * Löscht ein Knoten mit dem Index index
     * @param index     Index des zu löschenden Knotens
     */
    public void remove(int index) {

    }


    /**
     * Sichert ein Objekt in den Knoten mit den Index index
     * @param index     Index des Knotens
     * @param data      zu sicherendes Objekt
     */
    public void set(int index, T data) {

    }

    /**
     * Gibt die Liste DrawnLines zurück
     * @return  Liste DrawnLines
     */
    public Listlabel<DrawnLines> getDrawnLines() {
        return null;
    }

    /**
     * Sortiert den Baum nach ASC order DECS
     * @param orderBy   OrderBy.ASC == Sortieren nach ASC
     *                  OrderBy.DESC == Sortieren nach DESC
     */
    public void sort(OrderBy orderBy) {

    }

    /**
     * Gibt das ViewPosition objekt des Knoten mit dem Index index zurück
     * @param index     Index des Knotens
     * @return          ViewPosition objekt des Knoten mit dem Index
     */
    public ViewPosition getViewPosition(int index) {
        return null;
    }

    /**
     * Gibt die breite des Baumes in Pixel zurück
     * @return  breite des Baumes
     */
    public int getWith() {
        return 0;
    }

    /**
     * Gibt die höhe des Baumes in Pixel zurück
     * @return  höhe des Baumes
     */
    public int getHigh() {
        return 0;
    }

    /**
     * Konvertiert ein String[][] in ein Binärbaum
     * @param binaryTreeArray       zu konvertierendendes String[][]
     */
    public void setBinaryTreeFromList(String[][] binaryTreeArray) {

    }

    /**
     * Konvertiert ein Binärbaum in ein String[][]
     * @return  konvertierter Binärbaum als String[][]
     */
    public String[][] getBinaryList() {
        return new String[0][];
    }
}
