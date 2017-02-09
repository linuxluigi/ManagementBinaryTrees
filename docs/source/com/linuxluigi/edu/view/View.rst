.. java:import:: com.linuxluigi.edu.data NodeData

.. java:import:: com.linuxluigi.edu.list BinaryLinkedList

.. java:import:: com.linuxluigi.edu.list Listlabel

.. java:import:: java.awt.event ActionListener

.. java:import:: java.awt.event KeyEvent

View
====

.. java:package:: com.linuxluigi.edu.view
   :noindex:

.. java:type:: public class View extends JFrame

   Main View, innerhalb dieser View wird das Hauptmenü und Knoten Zeichnung dargestellt.

Fields
------
jScrollPane
^^^^^^^^^^^

.. java:field::  JScrollPane jScrollPane
   :outertype: View

Constructors
------------
View
^^^^

.. java:constructor:: public View(int with, int height)
   :outertype: View

   Konstruktor der View

   ..

   * Setz den Titel der View
   * Erstellt die Menü Bar
   * Schaltet sich selbst sichtbar

   :param with: Breite des View Fensters in Pixel
   :param height: Höhe des View Fensters in Pixel

Methods
-------
addMenuExitListener
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addMenuExitListener(ActionListener listenerForMenuExit)
   :outertype: View

addMenuLoadListener
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addMenuLoadListener(ActionListener listenerForMenuLoad)
   :outertype: View

addMenuNewListener
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addMenuNewListener(ActionListener listenerForMenuNew)
   :outertype: View

addMenuSaveListener
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addMenuSaveListener(ActionListener listenerForMenuSave)
   :outertype: View

addNodeListener
^^^^^^^^^^^^^^^

.. java:method:: public void addNodeListener(ActionListener listenerForNodeButton)
   :outertype: View

addSortAcsListener
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addSortAcsListener(ActionListener listenerForMenuSave)
   :outertype: View

addSortDecsListener
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addSortDecsListener(ActionListener listenerForMenuSave)
   :outertype: View

createMenuBar
^^^^^^^^^^^^^

.. java:method:: public void createMenuBar()
   :outertype: View

   Erstellt eine JMenuBar

   ..

   * File

setBinaryTree
^^^^^^^^^^^^^

.. java:method:: public void setBinaryTree(Listlabel<NodeData> nodeList)
   :outertype: View

