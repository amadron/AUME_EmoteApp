package model;

/**
 * Created by Benedict on 24.10.2017.
 */

public class Entry {
    private int id;
    private String title;
    private int value;
    private String timestamp;

    public Entry(int id, String title, int value, String timestamp)
    {
        this.id = id;
        this.title = title;
        this.value = value;
        this.timestamp = timestamp;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }
}
