package com.linuxluigi.edu.list;

/**
 * Created by fubu on 01.02.17.
 */
public interface Listlabel<T> {

    public void add(T data);

    public void add(int index, T data);

    public void remove(int index);

    public void clearAll();

    public int size();

    public void printAll();

    public boolean isEmpty();

    public T get(int index);

    public int getSize();

    public void set(int index, T data);
}