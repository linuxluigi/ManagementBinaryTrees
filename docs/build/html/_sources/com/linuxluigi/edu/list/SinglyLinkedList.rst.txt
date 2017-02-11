.. java:import:: com.linuxluigi.edu.data DrawnLines

.. java:import:: com.linuxluigi.edu.data ViewPosition

SinglyLinkedList
================

.. java:package:: com.linuxluigi.edu.list
   :noindex:

.. java:type:: public class SinglyLinkedList<T> implements Listlabel<T>

   Simple Liste

   :param <T>:

Methods
-------
add
^^^

.. java:method:: public void add(T data)
   :outertype: SinglyLinkedList

   Fügt ein neuen Knoten ein

   :param data: Datenobject

add
^^^

.. java:method:: public void add(int index, T data)
   :outertype: SinglyLinkedList

   Fügt ein neuen nach dem Knoten mit der ID index ein Knoten ein

   :param index: Index des Knotens
   :param data: Datenobject

clearAll
^^^^^^^^

.. java:method:: public void clearAll()
   :outertype: SinglyLinkedList

   Löscht alle Knoten aus der Liste

get
^^^

.. java:method:: public T get(int index)
   :outertype: SinglyLinkedList

   Gibt den Wert vom Knoten mit dem Index index

   :param index: Index des Knotens
   :return: Daten Objekt

getBinaryList
^^^^^^^^^^^^^

.. java:method:: public String[][] getBinaryList()
   :outertype: SinglyLinkedList

   Konvertiert ein Binärbaum in ein String[][]

   :return: konvertierter Binärbaum als String[][]

getDrawnLines
^^^^^^^^^^^^^

.. java:method:: public Listlabel<DrawnLines> getDrawnLines()
   :outertype: SinglyLinkedList

   Gibt die Liste DrawnLines zurück

   :return: Liste DrawnLines

getHigh
^^^^^^^

.. java:method:: public int getHigh()
   :outertype: SinglyLinkedList

   Gibt die höhe des Baumes in Pixel zurück

   :return: höhe des Baumes

getSize
^^^^^^^

.. java:method:: public int getSize()
   :outertype: SinglyLinkedList

   Gibt die Anzahl von Knoten zurück

   :return: Anzahl von Knoten

getViewPosition
^^^^^^^^^^^^^^^

.. java:method:: public ViewPosition getViewPosition(int index)
   :outertype: SinglyLinkedList

   Gibt das ViewPosition objekt des Knoten mit dem Index index zurück

   :param index: Index des Knotens
   :return: ViewPosition objekt des Knoten mit dem Index

getWith
^^^^^^^

.. java:method:: public int getWith()
   :outertype: SinglyLinkedList

   Gibt die breite des Baumes in Pixel zurück

   :return: breite des Baumes

isEmpty
^^^^^^^

.. java:method:: public boolean isEmpty()
   :outertype: SinglyLinkedList

   Gibt zurück ob die Liste leer ist

   :return: True == Liste ohne Knoten False == in der Liste sind Knoten enthalten

remove
^^^^^^

.. java:method:: public void remove(int index)
   :outertype: SinglyLinkedList

   Löscht ein Knoten mit dem Index index

   :param index: Index des zu löschenden Knotens

set
^^^

.. java:method:: public void set(int index, T data)
   :outertype: SinglyLinkedList

   Sichert ein Objekt in den Knoten mit den Index index

   :param index: Index des Knotens
   :param data: zu sicherendes Objekt

setBinaryTreeFromList
^^^^^^^^^^^^^^^^^^^^^

.. java:method:: public void setBinaryTreeFromList(String[][] binaryTreeArray)
   :outertype: SinglyLinkedList

   Konvertiert ein String[][] in ein Binärbaum

   :param binaryTreeArray: zu konvertierendendes String[][]

sort
^^^^

.. java:method:: public void sort(OrderBy orderBy)
   :outertype: SinglyLinkedList

   Sortiert den Baum nach ASC order DECS

   :param orderBy: OrderBy.ASC == Sortieren nach ASC OrderBy.DESC == Sortieren nach DESC

