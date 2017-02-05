package com.linuxluigi.edu.data;

/**
 * Created by fubu on 01.02.17.
 */

public class NodeData {
    private String content;

    public NodeData(String content) {
        setContent(content);
    }

    public String getContent() {
        return content;
    }

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
