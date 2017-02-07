package com.linuxluigi.edu.list;

import com.linuxluigi.edu.data.DrawnLines;
import com.linuxluigi.edu.data.ViewPosition;

/**
 * Created by fubu on 01.02.17.
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
        public ViewPosition viewPosition;
    }

    private class PrevNode {
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

        boolean treeEnd = this.isEmpty();

        PrevNode prevNode = new PrevNode();

        while (treeEnd == false) {

            switch (prevNode.getPrevNode(tempCurrent, tempPrev)) {

                case NULL:
                    if (idCounter == 0) {
                        tempCurrent.ID = idCounter;
                        idCounter++;
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

    private void setPosition() {
        int maxWith = (int) Math.pow(2, this.treeDepth) * iconSize;

        Node tempCurrent = head;

        int currentTreeDepth = 0;
        Node tempPrev = null;

        boolean treeEnd = this.isEmpty();

        PrevNode prevNode = new PrevNode();

        this.drawnLines.clearAll();

        while (treeEnd == false) {

            int blockSize = maxWith / (int) Math.pow(2, currentTreeDepth);
            int blockStartY = (this.iconSize * 3 / 2) * currentTreeDepth;
            int blockStartX;

            switch (prevNode.getPrevNode(tempCurrent, tempPrev)) {

                case NULL:
                    blockStartX = maxWith / 2 - (iconSize / 2);

                    tempCurrent.viewPosition = new ViewPosition(blockStartX, blockStartY, this.iconSize);

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

                    // Location for Buttons
                    if(prevNode.getPrevNode(tempCurrent, tempPrev) == PrevNodeDirection.DOWN_LEFT) {
                        blockStartX = tempPrev.viewPosition.getMiddelX() - (blockSize / 2) - (iconSize / 2);
                    } else {
                        blockStartX = tempPrev.viewPosition.getMiddelX() + (blockSize / 2) - (iconSize / 2);
                    }
                    tempCurrent.viewPosition = new ViewPosition(blockStartX, blockStartY, this.iconSize);

                    // location for DrawnLines
                    int x1 = tempPrev.viewPosition.getMiddelX();
                    int y1 = tempPrev.viewPosition.getY2();
                    int x2 = tempCurrent.viewPosition.getMiddelX();
                    int y2 = tempCurrent.viewPosition.getY();

                    this.drawnLines.add(new DrawnLines(x1, x2, y1, y2));

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
    }

    /**
     * 1. create new list
     * 2.1 search for the highes node
     * 2.2 add this node to the new list
     * 2.3 remove the node from the current node
     * 3. repeat till there is no node left
     */
    public void sort() {

    }

    public Listlabel<DrawnLines> getDrawnLines() {
        return this.drawnLines;
    }

    public ViewPosition getViewPosition(int index) {
        return getNode(index).viewPosition;
    }
}
