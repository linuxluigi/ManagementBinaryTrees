.. java:import:: com.google.gson Gson

.. java:import:: com.google.gson GsonBuilder

.. java:import:: com.linuxluigi.edu.data NodeData

.. java:import:: com.linuxluigi.edu.list Listlabel

.. java:import:: java.io BufferedWriter

.. java:import:: java.io File

.. java:import:: java.io FileWriter

.. java:import:: java.io IOException

Save
====

.. java:package:: com.linuxluigi.edu
   :noindex:

.. java:type:: public class Save

   Speichert den Binärbaum in eine Json Datei

Constructors
------------
Save
^^^^

.. java:constructor:: public Save(File file, Listlabel<NodeData> nodeList)
   :outertype: Save

   Speichert den Binärbaum in eine Json Datei Dabei wird der Binärbaum in 2 Dimensionalen String Array konvertiert, um speicherplatz effektiv zu sichern.

   :param file: zu speichernde Json Datei
   :param nodeList: den zu Speicherenden Binärbaum

