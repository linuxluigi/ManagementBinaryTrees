package com.linuxluigi.edu.list;

import com.linuxluigi.edu.data.DrawnLines;

/**
 * Created by fubu on 06.02.17.
 */
public class SinglyLinkedList<T> implements Listlabel<T>  {
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
}
