package com.application.Dictionar.entity;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity
public class Dictionar {

    @Id
    private int id;

    private String japanese;

    private String romanian;

    public Dictionar() {
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getJapanese() {
        return japanese;
    }

    public void setJapanese(String name) {
        this.japanese = name;
    }

    public String getRomanian() {
        return romanian;
    }

    public void setRomanian(String email) {
        this.romanian = email;
    }

    @Override
    public String toString() {
        return "Dictionar{" +
                "id=" + id +
                ", name='" + japanese + '\'' +
                ", email='" + romanian + '\'' +
                '}';
    }
}
