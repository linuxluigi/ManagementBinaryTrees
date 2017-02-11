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
import com.linuxluigi.edu.data.NodeData;
import com.linuxluigi.edu.data.ViewPosition;

import java.util.Arrays;


/**
 * Binärbaum Liste
 * @param <T>
 */
public class BinaryLinkedList<T> implements Listlabel<T> {
    private Node head;
    private int treeDepth = 0;
    private int size = 0;
    private final int iconSize = 80;

    private Listlabel<DrawnLines> drawnLines = new SinglyLinkedList<DrawnLines>();

    private class Node {
        public T data;
        public Integer ID;
        public Node prev;
        public Node nextLeft;
        public Node nextRight;
        public int treeDepth;
        public ViewPosition viewPosition;
    }

    /**
     * Eine Klasse die ausgibt wo der Knoten herkommt
     * <ul>
     *     <li>Erste Knoten</li>
     *     <li>von Oben Links</li>
     *     <li>von Oben Rechts</li>
     *     <li>von Unten Links</li>
     *     <li>von Unten Rechts</li>
     * </ul>
     */
    private class PrevNode {
        /**
         * Ausgabe wo der Knoten herkommt
         * <ul>
         *     <li>Erste Knoten</li>
         *     <li>von Oben Links</li>
         *     <li>von Oben Rechts</li>
         *     <li>von Unten Links</li>
         *     <li>von Unten Rechts</li>
         * </ul>
         * @param currentNode   Aktueller Knoten
         * @param prevNode      Vorheriger Knoten
         * @return              <ul>
         *                          <li>PrevNodeDirection.NULL</li>
         *                          <li>PrevNodeDirection.DOWN_LEFT</li>
         *                          <li>PrevNodeDirection.DOWN_RIGHT</li>
         *                          <li>PrevNodeDirection.UP_LEFT</li>
         *                          <li>PrevNodeDirection.UP_RIGHT</li>
         *                      </ul>
         */
        PrevNodeDirection getPrevNode(Node currentNode, Node prevNode) {

            // starting node
            if (prevNode == null) {
                return PrevNodeDirection.NULL;
            }

            // down left node
            else if (prevNode.nextLeft == currentNode) {
                return PrevNodeDirection.DOWN_LEFT;
            }

            // down right node
            else if (prevNode.nextRight == currentNode) {
                return PrevNodeDirection.DOWN_RIGHT;
            }

            // up left node
            else if (currentNode.nextLeft == prevNode) {
                return PrevNodeDirection.UP_LEFT;
            }

            // up right node
            else if (currentNode.nextRight == prevNode) {
                return PrevNodeDirection.UP_RIGHT;
            } else {
                throw new IllegalArgumentException();
            }
        }
    }

    /**
     * Fügt ein neuen Knoten ein
     * @param data Datenobject
     */
    public void add(T data) {
        add(0, data);
    }

    /**
     * Fügt ein neuen nach dem Knoten mit der ID index ein Knoten ein
     * @param index Index des Knotens
     * @param data Datenobject
     */
    public void add(int index, T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextLeft = null;
        newNode.nextRight = null;
        add(index, newNode);
    }

    /**
     * Fügt ein neuen Knoten hinzu nach Knoten mit dem Index index
     * @param index     Index des vorherigen Knoten
     * @param newNode   Zu speichernden Knoten
     */
    private void add(int index, Node newNode) {
        Node tempCurrent;

        if (index >= this.size || index < 0) {
            if (index != 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        if (index == 0 && head == null) {
            newNode.prev = null;
            head = newNode;
        } else {
            tempCurrent = getNode(index);

            int maxTreeDepth = 0;
            int currentTreeDepth = 0;
            Node tempPrev = null;

            while ((tempCurrent.nextLeft != null) && (tempCurrent.nextRight != null)) {

                if (tempPrev == null) {
                    maxTreeDepth++;
                    currentTreeDepth++;
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextLeft;

                } else if (currentTreeDepth < maxTreeDepth) {

                    if (tempPrev == tempCurrent.prev) {
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.nextLeft;
                        currentTreeDepth++;

                    } else if (tempPrev == tempCurrent.nextLeft) {
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.nextRight;
                        currentTreeDepth++;

                    } else if (tempPrev == tempCurrent.nextRight) {
                        if (tempCurrent.prev == null || currentTreeDepth == 0) {
                            tempPrev = null;
                            tempCurrent = tempCurrent.nextLeft;
                            currentTreeDepth++;
                        } else {
                            tempPrev = tempCurrent;
                            tempCurrent = tempCurrent.prev;
                            currentTreeDepth--;
                        }
                    }

                } else {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.prev;
                    currentTreeDepth--;
                }
            }

            newNode.prev = tempCurrent;

            if (tempCurrent.nextLeft == null) {
                tempCurrent.nextLeft = newNode;
            } else {
                tempCurrent.nextRight = newNode;
            }
        }

        setId();
    }

    /**
     * Löscht ein Knoten mit dem Index index
     * @param index     Index des zu löschenden Knotens
     */
    public void remove(int index) {
        Node getNode = this.getNode(index);

        if (getNode.nextLeft == null && getNode.nextRight == null) {
            // no next node

            if (getNode.prev == null) {
                // head node
                this.head = null;
            } else {
                if (getNode.prev.nextLeft == getNode) {
                    getNode.prev.nextLeft = null;
                } else {
                    getNode.prev.nextRight = null;
                }
            }

            setId();

        } else if (getNode.nextLeft != null && getNode.nextRight != null) {
            // 2 next  nodes
            int prevId;
            Node tempNextNode = getNode.nextRight;

            if (getNode.prev == null) {
                // head
                prevId = getNode.nextLeft.ID;

                head = getNode.nextLeft;
                head.prev = null;

            } else {
                prevId = getNode.prev.ID;
                if (getNode.prev.nextLeft == getNode) {
                    getNode.prev.nextLeft = getNode.nextLeft;
                    getNode.prev.nextLeft.prev = getNode.prev;
                } else {
                    getNode.prev.nextRight = getNode.nextLeft;
                    getNode.prev.nextRight.prev = getNode.prev;
                }
            }

            add(prevId, tempNextNode);
            setId();

        } else {
            // single next node
            Node tempNode;

            if (getNode.nextLeft != null) {
                tempNode = getNode.nextLeft;
            } else {
                tempNode = getNode.nextRight;
            }

            if (getNode.prev == null) {
                // head
                head = tempNode;
                head.prev = null;

            } else {
                if (getNode.prev.nextLeft == getNode) {
                    getNode.prev.nextLeft = tempNode;
                    tempNode.prev = getNode.prev;
                } else {
                    getNode.prev.nextRight = tempNode;
                    tempNode.prev = getNode.prev;
                }
            }

            setId();
        }

    }

    /**
     * Löscht alle Knoten aus der Liste
     */
    public void clearAll() {
        this.head = null;
        this.drawnLines.clearAll();
        this.size = 0;
        this.treeDepth = 0;
    }

    /**
     * Gibt zurück ob die Liste leer ist
     * @return  True  == Liste ohne Knoten
     *          False == in der Liste sind Knoten enthalten
     */
    public boolean isEmpty() {
        if (head != null) {
            return false;
        } else {
            return true;
        }
    }


    /**
     * Gibt den gesamten Knoten mit dem Index index zurück
     * @param index Index des Knoten der zurück gegeben werden soll
     * @return      Knoten
     */
    private Node getNode(int index) {
        if (index >= this.size || index < 0) {
            throw new ArrayIndexOutOfBoundsException();
        }

        Node tempCurrent = head;
        Node tempPrev = null;
        Node getNode = null;

        while (getNode == null) {
            if (tempCurrent.ID == index) {
                getNode = tempCurrent;
                break;
            }

            if (tempPrev == null) {
                if (tempCurrent.nextLeft != null) {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextLeft;
                } else {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextRight;
                }

            } else if (tempPrev.nextLeft == tempCurrent || tempPrev.nextRight == tempCurrent) {

                if (tempCurrent.nextLeft != null) {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextLeft;

                } else if (tempCurrent.nextRight != null) {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextRight;

                } else {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.prev;
                }

            } else if (tempPrev == tempCurrent.nextLeft) {

                if (tempCurrent.nextRight != null) {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextRight;
                } else {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.prev;
                }

            } else if (tempPrev == tempCurrent.nextRight) {
                tempPrev = tempCurrent;
                tempCurrent = tempCurrent.prev;
            }

        }

        return getNode;
    }

    /**
     * Gibt den Wert vom Knoten mit dem Index index
     * @param index     Index des Knotens
     * @return      Daten Objekt
     */
    public T get(int index) {
        return getNode(index).data;
    }

    /**
     * Gibt die Anzahl von Knoten zurück
     * @return  Anzahl von Knoten
     */
    public int getSize() {
        return this.size;
    }

    /**
     * Sichert ein Objekt in den Knoten mit den Index index
     * @param index     Index des Knotens
     * @param data      zu sicherendes Objekt
     */
    public void set(int index, T data) {
        getNode(index).data = data;
    }

    /**
     * Weiß jeden Knoten eine eindeutige ID zu
     */
    private void setId() {
        this.treeDepth = 0;

        Integer idCounter = 0;

        Node tempCurrent = this.head;

        int currentTreeDepth = 0;
        Node tempPrev = null;

        boolean treeEnd = this.isEmpty();

        PrevNode prevNode = new PrevNode();

        while (treeEnd == false) {

            switch (prevNode.getPrevNode(tempCurrent, tempPrev)) {

                case NULL:
                    if (idCounter == 0) {
                        tempCurrent.ID = idCounter;
                        idCounter++;
                        tempCurrent.treeDepth = currentTreeDepth;
                    }

                    if (tempCurrent.nextLeft != null) {
                        // go down left
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.nextLeft;
                        currentTreeDepth++;
                    } else if (tempCurrent.nextRight != null) {
                        // go down right
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.nextRight;
                        currentTreeDepth++;
                    } else {
                        // end
                        treeEnd = true;
                    }

                    break;

                case UP_LEFT:
                    if (tempCurrent.prev == null) {
                        // starting node
                        if (tempCurrent.nextRight != null) {
                            // go down right
                            tempPrev = tempCurrent;
                            tempCurrent = tempCurrent.nextRight;
                            currentTreeDepth++;
                        } else {
                            // end
                            treeEnd = true;
                        }
                    } else {
                        if (tempCurrent.nextRight != null) {
                            // go down right
                            tempPrev = tempCurrent;
                            tempCurrent = tempCurrent.nextRight;
                            currentTreeDepth++;
                        } else {
                            // go up
                            tempPrev = tempCurrent;
                            tempCurrent = tempCurrent.prev;
                            currentTreeDepth--;
                        }
                    }
                    break;

                case UP_RIGHT:
                    if (tempCurrent.prev == null) {
                        // starting node
                        // end
                        treeEnd = true;
                    } else {
                        // go up
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.prev;
                        currentTreeDepth--;
                    }
                    break;

                default:
                    // for DOWN_LEFT && DOWN_RIGHT

                    tempCurrent.ID = idCounter;
                    idCounter++;
                    tempCurrent.treeDepth = currentTreeDepth;

                    if (tempCurrent.nextLeft != null) {
                        // go down left
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.nextLeft;
                        currentTreeDepth++;
                    } else if (tempCurrent.nextRight != null) {
                        // go down right
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.nextRight;
                        currentTreeDepth++;
                    } else if (tempCurrent.prev == null) {
                        // end
                        treeEnd = true;
                    } else {
                        // go up
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.prev;
                        currentTreeDepth--;
                    }
                    break;

            }

            // Set max tree depth
            if (currentTreeDepth > this.treeDepth) {
                this.treeDepth = currentTreeDepth;
            }

        }

        this.size = idCounter;

        setPosition();
    }

    /**
     * Berechnet für jeden Knoten eine genaue Position für die View
     */
    private void setPosition() {
        int maxWith = (int) Math.pow(2, this.treeDepth) * iconSize;

        this.drawnLines.clearAll();

        for (int i = 0; i < this.size; i++) {
            Node getNode = getNode(i);

            int blockSize = maxWith / (int) Math.pow(2, getNode.treeDepth);
            int blockStartY = (this.iconSize * 3 / 2) * getNode.treeDepth;
            int blockStartX;

            if (getNode.prev == null) {
                //head
                blockStartX = maxWith / 2 - (iconSize / 2);
                getNode.viewPosition = new ViewPosition(blockStartX, blockStartY, this.iconSize);
            } else {

                if (getNode == getNode.prev.nextLeft) {
                    // location for Button
                    blockStartX = getNode.prev.viewPosition.getMiddleX() - (blockSize / 2) - (iconSize / 2);
                    getNode.viewPosition = new ViewPosition(blockStartX, blockStartY, this.iconSize);
                } else {
                    // location for Button
                    blockStartX = getNode.prev.viewPosition.getMiddleX() + (blockSize / 2) - (iconSize / 2);
                    getNode.viewPosition = new ViewPosition(blockStartX, blockStartY, this.iconSize);
                }

                if (getNode.prev != null) {
                    // location for DrawnLines
                    int x1 = getNode.prev.viewPosition.getMiddleX();
                    int y1 = getNode.prev.viewPosition.getY2();
                    int x2 = getNode.viewPosition.getMiddleX();
                    int y2 = getNode.viewPosition.getY();

                    this.drawnLines.add(new DrawnLines(x1, x2, y1, y2));
                }
            }

        }
    }

    /**
     * Sortiert den Baum nach ASC order DECS
     * @param orderBy   OrderBy.ASC == Sortieren nach ASC
     *                  OrderBy.DESC == Sortieren nach DESC
     */
    public void sort(OrderBy orderBy) {
        String[] sortArray = new String[this.size];

        for (int i = 0; i < this.size; i++) {
            NodeData temp = (NodeData) getNode(i).data;
            sortArray[i] = temp.getContent();
        }

        Arrays.sort(sortArray);

        if (orderBy == OrderBy.DESC) {
            String[] sortArrayDesc = new String[this.size];
            for (int i = 0; i < this.size; i++) {
                sortArrayDesc[this.size - i - 1] = sortArray[i];
            }
            sortArray = sortArrayDesc;
        }

        clearAll();

        for (int i = 0; i < sortArray.length; i++) {
            add((T) new NodeData(sortArray[i]));
        }

    }

    /**
     * Gibt die Liste DrawnLines zurück
     * @return  Liste DrawnLines
     */
    public Listlabel<DrawnLines> getDrawnLines() {
        return this.drawnLines;
    }

    /**
     * Gibt das ViewPosition objekt des Knoten mit dem Index index zurück
     * @param index     Index des Knotens
     * @return          ViewPosition objekt des Knoten mit dem Index
     */
    public ViewPosition getViewPosition(int index) {
        return getNode(index).viewPosition;
    }

    /**
     * Gibt die breite des Baumes in Pixel zurück
     * @return  breite des Baumes
     */
    public int getWith() {
        return (int) Math.pow(2, this.treeDepth) * iconSize;
    }

    /**
     * Gibt die höhe des Baumes in Pixel zurück
     * @return  höhe des Baumes
     */
    public int getHigh() {
        return treeDepth * iconSize * 2;
    }

    /**
     * Konvertiert ein String[][] in ein Binärbaum
     * @param binaryTreeArray       zu konvertierendendes String[][]
     */
    public void setBinaryTreeFromList(String[][] binaryTreeArray) {
        clearAll();

        add((T) new NodeData(binaryTreeArray[0][1]));


        for (int i = 1; i < binaryTreeArray.length; i++) {

            Node tempCurrent = head;

            Node newNode = new Node();
            newNode.data = (T) new NodeData(binaryTreeArray[i][1]);
            newNode.nextLeft = null;
            newNode.nextRight = null;

            for (int j = 0; j < binaryTreeArray[i][0].length(); j++) {

                if (binaryTreeArray[i][0].charAt(j) == '0') {

                    if (j == binaryTreeArray[i][0].length() - 1) {
                        newNode.prev = tempCurrent;
                        tempCurrent.nextLeft = newNode;
                    } else {
                        tempCurrent = tempCurrent.nextLeft;
                    }

                } else {

                    if (j == binaryTreeArray[i][0].length() - 1) {
                        newNode.prev = tempCurrent;
                        tempCurrent.nextRight = newNode;
                    } else {
                        tempCurrent = tempCurrent.nextRight;
                    }

                }
            }
        }

        setId();
    }

    /**
     * Konvertiert ein Binärbaum in ein String[][]
     * @return  konvertierter Binärbaum als String[][]
     */
    public String[][] getBinaryList() {
        String[][] binaryTreeArray = new String[this.size][2];

        for (int i = 0; i < this.size; i++) {
            Node getNode = getNode(i);
            NodeData nodeData = (NodeData) getNode.data;
            binaryTreeArray[i][1] = nodeData.getContent();

            binaryTreeArray[i][0] = "";

            PrevNode prevNode = new PrevNode();

            while (getNode.prev != null) {
                switch (prevNode.getPrevNode(getNode, getNode.prev)) {
                    case DOWN_LEFT:
                        binaryTreeArray[i][0] = "0" + binaryTreeArray[i][0];
                        break;
                    case DOWN_RIGHT:
                        binaryTreeArray[i][0] = "1" + binaryTreeArray[i][0];
                        break;
                }
                getNode = getNode.prev;
            }
        }

        return binaryTreeArray;
    }
}
