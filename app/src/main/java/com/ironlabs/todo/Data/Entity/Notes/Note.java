package com.ironlabs.todo.Data.Entity.Notes;

import java.io.Serializable;
import java.text.SimpleDateFormat;
import java.util.UUID;

public class Note implements Serializable {

    public static final String NOTE_DATE_FORMAT = "H:M";

    private String id;
    private String name;
    private String tag;
    private int type;
    private String content;
    private String dateCreated;

    public Note() {
        this.id = UUID.randomUUID().toString();
        //
    }

    public Note(String id, String name, String tag, int type, String content) {
        this.id = UUID.randomUUID().toString();
        this.name = name;
        this.tag = tag;
        this.type = type;
        this.content = content;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getTag() {
        return tag;
    }

    public void setTag(String tag) {
        this.tag = tag;
    }

    public int getType() {
        return type;
    }

    public void setType(int type) {
        this.type = type;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getDateCreated() {
        return dateCreated;
    }

    public void setDateCreated(String dateCreated) {
        this.dateCreated = dateCreated;
    }

    public String getDateCreatedString() {
        SimpleDateFormat sdf = new SimpleDateFormat(NOTE_DATE_FORMAT);
        return sdf.format(dateCreated);
    }


    @Override
    public String toString() {
        return "{" +
                "name='" + name + '\'' +
                ", tag='" + tag + '\'' +
                ", type=" + type +
                ", content='" + content + '\'' +
                ", dateCreated=" + dateCreated +
                '}';
    }
}
