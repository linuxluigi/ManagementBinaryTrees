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

import com.linuxluigi.edu.data.NodeData;
import org.junit.Test;

import static org.junit.Assert.*;

public class BinaryLinkedListTest {
    @Test
    public void add() throws Exception {
        Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();

        nodeList.add(new NodeData("AAA"));
        assertEquals(1, nodeList.getSize());

        nodeList.add(new NodeData("BBB"));
        assertEquals(2, nodeList.getSize());

        nodeList.add(new NodeData("CCC"));
        assertEquals(3, nodeList.getSize());
    }

    @Test
    public void add1() throws Exception {
        Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();

        nodeList.add(new NodeData("AAA"));
        assertEquals(1, nodeList.getSize());

        nodeList.add(0, new NodeData("BBB"));
        assertEquals(2, nodeList.getSize());

        nodeList.add(0, new NodeData("CCC"));
        assertEquals(3, nodeList.getSize());
    }

    @Test
    public void remove() throws Exception {
        Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();

        nodeList.add(new NodeData("AAA"));
        nodeList.add(new NodeData("BBB"));
        nodeList.add(new NodeData("CCC"));

        nodeList.remove(0);
        assertEquals(2, nodeList.getSize());

        nodeList.remove(0);
        assertEquals(1, nodeList.getSize());

        nodeList.remove(0);
        assertEquals(0, nodeList.getSize());
    }

    @Test
    public void clearAll() throws Exception {
        Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();

        nodeList.add(new NodeData("AAA"));
        nodeList.add(new NodeData("BBB"));
        nodeList.add(new NodeData("CCC"));

        nodeList.clearAll();
        assertEquals(0, nodeList.getSize());
    }

    @Test
    public void isEmpty() throws Exception {
        Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();

        nodeList.add(new NodeData("AAA"));
        nodeList.add(new NodeData("BBB"));
        nodeList.add(new NodeData("CCC"));

        assertEquals(false, nodeList.isEmpty());

        nodeList.clearAll();
        assertEquals(true, nodeList.isEmpty());

    }

    @Test
    public void get() throws Exception {
        Listlabel<NodeData> nodeList = new BinaryLinkedList<NodeData>();

        nodeList.add(new NodeData("AAA"));
        assertEquals(new NodeData("AAA").getContent().toString(), nodeList.get(0).getContent().toString());

        nodeList.add(new NodeData("CCC"));
        assertEquals(new NodeData("CCC").getContent().toString(), nodeList.get(1).getContent().toString());

        nodeList.add(new NodeData("DDD"));
        assertEquals(new NodeData("DDD").getContent().toString(), nodeList.get(2).getContent().toString());
    }

}