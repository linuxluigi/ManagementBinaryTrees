.. java:import:: com.linuxluigi.edu.data DrawnLines

.. java:import:: com.linuxluigi.edu.data ViewPosition

Listlabel
=========

.. java:package:: com.linuxluigi.edu.list
   :noindex:

.. java:type:: public interface Listlabel<T>

Methods
-------
add
^^^

.. java:method::  void add(T data)
   :outertype: Listlabel

   Fügt ein neuen Knoten ein

   :param data: Datenobject

add
^^^

.. java:method::  void add(int index, T data)
   :outertype: Listlabel

   Fügt ein neuen nach dem Knoten mit der ID index ein Knoten ein

   :param index: Index des Knotens
   :param data: Datenobject

clearAll
^^^^^^^^

.. java:method::  void clearAll()
   :outertype: Listlabel

   Löscht alle Knoten aus der Liste

get
^^^

.. java:method::  T get(int index)
   :outertype: Listlabel

   Gibt den Wert vom Knoten mit dem Index index

   :param index: Index des Knotens
   :return: Daten Objekt

getBinaryList
^^^^^^^^^^^^^

.. java:method::  String[][] getBinaryList()
   :outertype: Listlabel

   Konvertiert ein Binärbaum in ein String[][]

   :return: konvertierter Binärbaum als String[][]

getDrawnLines
^^^^^^^^^^^^^

.. java:method::  Listlabel<DrawnLines> getDrawnLines()
   :outertype: Listlabel

   Gibt die Liste DrawnLines zurück

   :return: Liste DrawnLines

getHigh
^^^^^^^

.. java:method::  int getHigh()
   :outertype: Listlabel

   Gibt die höhe des Baumes in Pixel zurück

   :return: höhe des Baumes

getSize
^^^^^^^

.. java:method::  int getSize()
   :outertype: Listlabel

   Gibt die Anzahl von Knoten zurück

   :return: Anzahl von Knoten

getViewPosition
^^^^^^^^^^^^^^^

.. java:method::  ViewPosition getViewPosition(int index)
   :outertype: Listlabel

   Gibt das ViewPosition objekt des Knoten mit dem Index index zurück

   :param index: Index des Knotens
   :return: ViewPosition objekt des Knoten mit dem Index

getWith
^^^^^^^

.. java:method::  int getWith()
   :outertype: Listlabel

   Gibt die breite des Baumes in Pixel zurück

   :return: breite des Baumes

isEmpty
^^^^^^^

.. java:method::  boolean isEmpty()
   :outertype: Listlabel

   Gibt zurück ob die Liste leer ist

   :return: True == Liste ohne Knoten False == in der Liste sind Knoten enthalten

remove
^^^^^^

.. java:method::  void remove(int index)
   :outertype: Listlabel

   Löscht ein Knoten mit dem Index index

   :param index: Index des zu löschenden Knotens

set
^^^

.. java:method::  void set(int index, T data)
   :outertype: Listlabel

   Sichert ein Objekt in den Knoten mit den Index index

   :param index: Index des Knotens
   :param data: zu sicherendes Objekt

setBinaryTreeFromList
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void setBinaryTreeFromList(String[][] binaryTreeArray)
   :outertype: Listlabel

   Konvertiert ein String[][] in ein Binärbaum

   :param binaryTreeArray: zu konvertierendendes String[][]

sort
^^^^

.. java:method::  void sort(OrderBy orderBy)
   :outertype: Listlabel

   Sortiert den Baum nach ASC order DECS

   :param orderBy: OrderBy.ASC == Sortieren nach ASC OrderBy.DESC == Sortieren nach DESC

