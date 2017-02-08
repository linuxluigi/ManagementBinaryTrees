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
 * Created by fubu on 01.02.17.
 */
public interface Listlabel<T> {

    public void add(T data);

    public void add(int index, T data);

    public void remove(int index);

    public void clearAll();

    public boolean isEmpty();

    public T get(int index);

    public int getSize();

    public void set(int index, T data);

    public void sort(OrderBy orderBy);

    public int getWith();

    public int getHigh();

    public void setBinaryTreeFromList(String[][] binaryTreeArray);

    public String[][] getBinaryList();

    public ViewPosition getViewPosition(int index);

    public Listlabel<DrawnLines> getDrawnLines();
}
