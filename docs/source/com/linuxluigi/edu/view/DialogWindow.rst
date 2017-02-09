.. java:import:: java.awt.event ActionListener

DialogWindow
============

.. java:package:: com.linuxluigi.edu.view
   :noindex:

.. java:type:: public class DialogWindow extends JFrame

   Dialog Fenster welches erscheint nachdem ein Knoten gedrückt worden ist. Welches folgenede Optionen liefert.

   ..

   * Knoten hinzufügen
   * Knoten ändern
   * Knoten löschen

Constructors
------------
DialogWindow
^^^^^^^^^^^^

.. java:constructor:: public DialogWindow(int nodeId, String nodeContent)
   :outertype: DialogWindow

Methods
-------
addAddListener
^^^^^^^^^^^^^^

.. java:method:: public void addAddListener(ActionListener listenerForAddButton)
   :outertype: DialogWindow

   Button Knoten hinzufügen

   :param listenerForAddButton: ActionListener

addRemoveListener
^^^^^^^^^^^^^^^^^

.. java:method:: public void addRemoveListener(ActionListener listenerForRemoveButton)
   :outertype: DialogWindow

   Button Knoten löschen

   :param listenerForRemoveButton: ActionListener

addRenameListener
^^^^^^^^^^^^^^^^^

.. java:method:: public void addRenameListener(ActionListener listenerForRenameButton)
   :outertype: DialogWindow

   Button Knoten ändern

   :param listenerForRenameButton: ActionListener

getNodeId
^^^^^^^^^

.. java:method:: public int getNodeId()
   :outertype: DialogWindow

   Gibt die Knoten ID des DialogWindow zurück

   :return: Knoten ID

getText
^^^^^^^

.. java:method:: public String getText()
   :outertype: DialogWindow

   Gibt das Textfeld des DialogWindows zurück

   :return: Textfeld des Dialogfenster als String

