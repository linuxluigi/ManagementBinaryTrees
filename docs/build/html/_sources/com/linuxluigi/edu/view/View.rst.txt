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

   Created by fubu on 03.02.17.

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

setBinaryTree
^^^^^^^^^^^^^

.. java:method:: public void setBinaryTree(Listlabel<NodeData> nodeList)
   :outertype: View

