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
 * Created by fubu on 06.02.17.
 */
public class SinglyLinkedList<T> implements Listlabel<T> {
    private Node head;
    private int size = 0;

    private class Node {
        public T data;
        public Node next;
    }

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


    public void clearAll() {
        this.head = null;
        this.size = 0;
    }

    public boolean isEmpty() {
        if (head == null) {
            return true;
        } else {
            return false;
        }
    }

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

    public int getSize() {
        return this.size;
    }

    public void add(int index, T data) {

    }

    public void remove(int index) {

    }


    public void set(int index, T data) {

    }

    public Listlabel<DrawnLines> getDrawnLines() {
        return null;
    }

    public void sort(OrderBy orderBy) {

    }

    public ViewPosition getViewPosition(int index) {
        return null;
    }

    public int getWith() {
        return 0;
    }

    public int getHigh() {
        return 0;
    }

    public void setBinaryTreeFromList(String[][] binaryTreeArray) {

    }

    public String[][] getBinaryList() {
        return new String[0][];
    }
}
