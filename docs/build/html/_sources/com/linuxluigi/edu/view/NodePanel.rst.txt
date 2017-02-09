.. java:import:: com.linuxluigi.edu.data DrawnLines

.. java:import:: com.linuxluigi.edu.data NodeData

.. java:import:: com.linuxluigi.edu.data ViewPosition

.. java:import:: com.linuxluigi.edu.list BinaryLinkedList

.. java:import:: com.linuxluigi.edu.list Listlabel

.. java:import:: java.awt.event ActionListener

.. java:import:: java.awt.geom Line2D

NodePanel
=========

.. java:package:: com.linuxluigi.edu.view
   :noindex:

.. java:type:: public class NodePanel extends JPanel

Fields
------
jButtons
^^^^^^^^

.. java:field:: public JButton[] jButtons
   :outertype: NodePanel

jLabels
^^^^^^^

.. java:field:: public JLabel[] jLabels
   :outertype: NodePanel

Constructors
------------
NodePanel
^^^^^^^^^

.. java:constructor:: public NodePanel()
   :outertype: NodePanel

Methods
-------
addNodeListener
^^^^^^^^^^^^^^^

.. java:method:: public void addNodeListener(ActionListener listenerForNodeButton)
   :outertype: NodePanel

getJPanel
^^^^^^^^^

.. java:method:: public JPanel getJPanel(Listlabel<NodeData> nodeList)
   :outertype: NodePanel

paintComponent
^^^^^^^^^^^^^^

.. java:method:: protected void paintComponent(Graphics g)
   :outertype: NodePanel

