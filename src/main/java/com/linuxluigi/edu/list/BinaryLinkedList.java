package com.linuxluigi.edu.list;

import javax.swing.*;

/**
 * Created by fubu on 01.02.17.
 */
public class BinaryLinkedList<T> implements Listlabel<T> {
    private Node head;
    private int treeDepth = 0;
    private int size = 0;
    private JButton[] jButtons;

    private class Node {
        public T data;
        public Integer ID;
        public Node prev;
        public Node nextLeft;
        public Node nextRight;
    }


    public void add(T data) {
        add(0, data);
    }

    public void add(int index, T data) {
        Node newNode = new Node();
        newNode.data = data;
        newNode.nextLeft = null;
        newNode.nextRight = null;
        add(index, newNode);
    }

    private void add(int index, Node newNode) {
        Node tempCurrent;

        if (index >= this.size || index < 0) {
            if (index != 0) {
                throw new ArrayIndexOutOfBoundsException();
            }
        }

        if (index == 0 && head == null) {
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

    public void remove(int index) {
        Node tempCurrent = getNode(index);

        if (tempCurrent.prev != null && (tempCurrent.prev.nextLeft == null || tempCurrent.prev.nextRight == null)) {
            tempCurrent.prev.nextLeft = tempCurrent.nextLeft;
            tempCurrent.prev.nextRight = tempCurrent.nextRight;
        } else {
            tempCurrent.prev = tempCurrent.nextLeft;
            add(tempCurrent.prev.ID, tempCurrent.nextRight);
        }

        setId();

    }

    public void clearAll() {
        this.head = null;
        this.size = 0;
        this.treeDepth = 0;
    }

    public int size() {
        return this.size;
    }

    public void printAll() {
        // todo remove
        int maxTreeWithNodes = (int) Math.pow(2, this.treeDepth);
        int maxTreeWithChar = 3 * maxTreeWithNodes + maxTreeWithNodes - 1;
        String output = "";

        for (int i = 0; i < this.treeDepth; i++) {
            int tempWithNodes = (int) Math.pow(2, i);
            int tempNodeWithChar = (3 * tempWithNodes + tempWithNodes - 1) / tempWithNodes;
            for (int j = 0; j < tempWithNodes; j++) {
                int startChar = tempNodeWithChar / 2 - 1;
                for (int k = 1; k < startChar; k++) {
                    output = output + " ";
                }
                output = output + getNode(i * j).ID.toString();
                for (int k = 1; k < startChar; k++) {
                    output = output + " ";
                }
            }
            output = output + "\n";
        }
        System.out.println(output);
    }

    public boolean isEmpty() {
        if (head != null) {
            return false;
        } else {
            return true;
        }
    }

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

    public T get(int index) {
        return getNode(index).data;
    }

    public int getSize() {
        return this.size;
    }

    public void set(int index, T data) {
        getNode(index).data = data;
    }

    private void setId() {
        this.treeDepth = 0;

        Integer idCounter = 0;

        Node tempCurrent = head;

        int currentTreeDepth = 0;
        Node tempPrev = null;

        boolean treeEnd;
        if (head != null) {
            treeEnd = false;
        } else {
            treeEnd = true;
        }

        while (treeEnd == false) {

            if (tempPrev == null) {

                if (tempCurrent.nextLeft != null) {
                    tempCurrent.ID = idCounter;
                    idCounter++;
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextLeft;
                    currentTreeDepth++;

                } else if (tempCurrent.nextRight != null) {
                    tempCurrent.ID = idCounter;
                    idCounter++;
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextRight;
                    currentTreeDepth++;

                } else {
                    tempCurrent.ID = idCounter;
                    idCounter++;
                    treeEnd = true;
                    break;
                }

            } else if (tempCurrent.prev == null) {
                if (tempPrev == tempCurrent.nextRight) {
                    treeEnd = true;
                    break;
                } else {
                    if (tempCurrent.nextRight != null) {
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.nextRight;
                        currentTreeDepth++;
                    } else {
                        treeEnd = true;
                        break;
                    }
                }

            } else if (tempPrev.nextLeft == tempCurrent || tempPrev.nextRight == tempCurrent) {

                if (tempCurrent.nextLeft != null) {
                    tempCurrent.ID = idCounter;
                    idCounter++;
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextLeft;
                    currentTreeDepth++;

                } else if (tempCurrent.nextRight != null) {
                    if (tempPrev.nextLeft == null) {
                        tempCurrent.ID = idCounter;
                        idCounter++;
                    }
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextRight;
                    currentTreeDepth++;

                } else {
                    tempCurrent.ID = idCounter;
                    idCounter++;
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.prev;
                    currentTreeDepth--;
                }

            } else if (tempPrev == tempCurrent.nextLeft) {

                if (tempCurrent.nextRight != null) {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.nextRight;
                    currentTreeDepth++;
                } else {
                    if (tempCurrent.prev == null) {
                        treeEnd = true;
                        break;
                    } else {
                        tempPrev = tempCurrent;
                        tempCurrent = tempCurrent.prev;
                        currentTreeDepth--;
                    }
                }

            } else if (tempPrev == tempCurrent.nextRight) {
                if (tempCurrent.prev != null) {
                    tempPrev = tempCurrent;
                    tempCurrent = tempCurrent.prev;
                    currentTreeDepth--;
                } else {
                    treeEnd = true;
                    break;
                }
            }

            if (currentTreeDepth > this.treeDepth) {
                this.treeDepth = currentTreeDepth;
            }

        }

        this.size = idCounter;

    }
}
