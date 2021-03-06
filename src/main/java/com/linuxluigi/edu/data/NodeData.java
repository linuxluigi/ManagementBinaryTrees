/*
 * Copyright 2017 Stefen Exler
 *
 * Permission is hereby granted, free of charge, to any person obtaining a copy of this software and associated documentation files (the "Software"), to deal in the Software without restriction, including without limitation the rights to use, copy, modify, merge, publish, distribute, sublicense, and/or sell copies of the Software, and to permit persons to whom the Software is furnished to do so, subject to the following conditions:
 *
 * The above copyright notice and this permission notice shall be included in all copies or substantial portions of the Software.
 *
 * THE SOFTWARE IS PROVIDED "AS IS", WITHOUT WARRANTY OF ANY KIND, EXPRESS OR IMPLIED, INCLUDING BUT NOT LIMITED TO THE WARRANTIES OF MERCHANTABILITY, FITNESS FOR A PARTICULAR PURPOSE AND NONINFRINGEMENT. IN NO EVENT SHALL THE AUTHORS OR COPYRIGHT HOLDERS BE LIABLE FOR ANY CLAIM, DAMAGES OR OTHER LIABILITY, WHETHER IN AN ACTION OF CONTRACT, TORT OR OTHERWISE, ARISING FROM, OUT OF OR IN CONNECTION WITH THE SOFTWARE OR THE USE OR OTHER DEALINGS IN THE SOFTWARE.
 */

package com.linuxluigi.edu.data;


/**
 * Daten Objekt für die Knoten
 * Gespeichert wird ein String mit der Maximalen länge von 3
 */
public class NodeData {
    private String content;

    /**
     * Daten Objekt für die Knoten
     * Gespeichert wird ein String mit der Maximalen länge von 3
     */
    public NodeData(String content) {
        setContent(content);
    }

    public String getContent() {
        return content;
    }

    /**
     * Speichern eines String mit der Maximalen länge von 3,
     * wenn der String länger ist, wird er automatisch auf 3 gekürtzt.
     *
     * @param content   String der gesichert werden soll.
     */
    public void setContent(String content) {
        if (content.length() > 3) {
            this.content = content.substring(0, 3);
        } else {
            this.content = content;
        }
    }

    @Override
    public String toString() {
        return "NodeData{" +
                "content='" + content + '\'' +
                '}';
    }

}
