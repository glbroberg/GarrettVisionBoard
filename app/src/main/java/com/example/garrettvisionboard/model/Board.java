package com.example.garrettvisionboard.model;

import java.io.Serializable;
import java.util.UUID;

public class Board implements Serializable {

    private static final long serialVersionUUID = -12345678787L;
    private UUID id;
    private String name;
    private String description;
    private int imageUrl;

    public Board(String name, String description, int imageUrl) {
        this.id = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.imageUrl = imageUrl;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public int getImageUrl() {
        return imageUrl;
    }

    public void setImageUrl(int imageUrl) {
        this.imageUrl = imageUrl;
    }
}
