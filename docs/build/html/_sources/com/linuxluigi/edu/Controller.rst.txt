.. java:import:: com.linuxluigi.edu.data NodeData

.. java:import:: com.linuxluigi.edu.list BinaryLinkedList

.. java:import:: com.linuxluigi.edu.list Listlabel

.. java:import:: com.linuxluigi.edu.list OrderBy

.. java:import:: com.linuxluigi.edu.view DialogWindow

.. java:import:: com.linuxluigi.edu.view View

.. java:import:: javax.swing.filechooser FileNameExtensionFilter

.. java:import:: java.awt.event ActionEvent

.. java:import:: java.awt.event ActionListener

.. java:import:: java.io File

Controller
==========

.. java:package:: com.linuxluigi.edu
   :noindex:

.. java:type:: public class Controller

   Der Controller der für die Steuerung der Software verantworlicch ist Enthalten sind:

   ..

   * Verwaltung der View
   * Verwaltung des Dialog Fenster zum ändern, hinzufügen und löschen eines Knoten
   * Verwalten des Binärbaumes
   * Action Listener

Constructors
------------
Controller
^^^^^^^^^^

.. java:constructor:: public Controller(View view)
   :outertype: Controller

   Konstruktor des Controllers

   ..

   * 1. Erstellt ein Demo Binärbaum
   * 2. Übergibt die Binärbaum informationen der View
   * 3. Fügt die Actionen Listener für jeden Button hinzu

   :param view: Die View für das haupt Fenster

Methods
-------
updateView
^^^^^^^^^^

.. java:method::  void updateView()
   :outertype: Controller

   Führt ein update der View aus

   ..

   * 1. Binärbaum der View übergeben
   * 2. Actionlistener einfügen

updateViewInNewWindow
^^^^^^^^^^^^^^^^^^^^^

.. java:method::  void updateViewInNewWindow()
   :outertype: Controller

   Führt ein update der View in ein neues Fenster aus und schließt das vorherige

   ..

   * 1. Position der alten View sichern
   * 2. Alte View unsichbar schalten
   * 3. Neue View an gleicher Stelle und gleicher Dimension der alten View erstellen
   * 4. Binärbaum der View übergeben
   * 5. Actionlistener einfügen

