package com.example.offense.model;

public class Card {

    private long id;
    private long summary;

    public Card() {
    }

    public Card(long id, long summary) {
        this.id = id;
        this.summary = summary;
    }

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public long getSummary() {
        return summary;
    }

    public void setSummary(long summary) {
        this.summary = summary;
    }
}
