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

   Erstellt den Actionlistener für: Exit

   :param listenerForMenuExit: ActionListener

addMenuLoadListener
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addMenuLoadListener(ActionListener listenerForMenuLoad)
   :outertype: View

   Erstellt den Actionlistener für: Menu - Binärbaum von Json laden

   :param listenerForMenuLoad: ActionListener

addMenuNewListener
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addMenuNewListener(ActionListener listenerForMenuNew)
   :outertype: View

   Erstellt den Actionlistener für: Menu - Neuen Binärbaum anlegen

   :param listenerForMenuNew: ActionListener

addMenuSaveListener
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addMenuSaveListener(ActionListener listenerForMenuSave)
   :outertype: View

   Erstellt den Actionlistener für: Menu - Binärbaum in Json speichern

   :param listenerForMenuSave: ActionListener

addNodeListener
^^^^^^^^^^^^^^^

.. java:method:: public void addNodeListener(ActionListener listenerForNodeButton)
   :outertype: View

   Erstellt den Actionlistener für: Alle Knoten im Binärbaum.

   :param listenerForNodeButton: ActionListener

addSortAcsListener
^^^^^^^^^^^^^^^^^^

.. java:method:: public void addSortAcsListener(ActionListener listenerForSortAcs)
   :outertype: View

   Erstellt den Actionlistener für: Menu - Binärbaum nach ACS sortieren

   :param listenerForSortAcs: ActionListener

addSortDecsListener
^^^^^^^^^^^^^^^^^^^

.. java:method:: public void addSortDecsListener(ActionListener listenerForSortDecs)
   :outertype: View

   Erstellt den Actionlistener für: Menu - Binärbaum nach DECS sortieren

   :param listenerForSortDecs: ActionListener

setBinaryTree
^^^^^^^^^^^^^

.. java:method:: public void setBinaryTree(Listlabel<NodeData> nodeList)
   :outertype: View

   Den Binärbaum updaten und anschließend wird diese View neu gezeichnet.

   :param nodeList: Binärbaum im Listenformat

