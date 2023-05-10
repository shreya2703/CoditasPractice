package org.example;

import javax.persistence.*;
import java.util.List;

@Entity
public class Movie {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    private Director director;

    @OneToMany(mappedBy = "movie")
    private List<Song> song;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Director getDirector() {
        return director;
    }

    public void setDirector(Director director) {
        this.director = director;
    }

    public List<Song> getSong() {
        return song;
    }

    public void setSong(List<Song> song) {
        this.song = song;
    }

    public Movie(String name) {
        this.name = name;
    }

    public Movie(String name, Director director, List<Song> song) {
        this.name = name;
        this.director = director;
        this.song = song;
    }

    public Movie(){

    }

    public Movie(String name, Director director) {
        this.name = name;
        this.director = director;
    }
}
