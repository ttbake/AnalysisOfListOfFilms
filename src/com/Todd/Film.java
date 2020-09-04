package com.Todd;

public class Film {
    private int position;
    private int position2019;
    private int position2018;
    private String title;
    private String director;
    private int year;
    private String country;
    private int length;
    private String genre;
    private String color;
    private boolean seen;

    public Film() {
    }

    @Override
    public String toString(){
        return this.getTitle() + " directed by " + this.getDirector() + " released in year " + this.getYear() + " and produced in " + this.getCountry();
    }

    public boolean getSeen() {
        return seen;
    }

    public void setSeen(boolean seen) {
        this.seen = seen;
    }

    public int getPosition() {
        return position;
    }

    public void setPosition(int position) {
        this.position = position;
    }

    public int getPosition2019() {
        return position2019;
    }

    public void setPosition2019(int position2019) {
        this.position2019 = position2019;
    }

    public int getPosition2018() {
        return position2018;
    }

    public void setPosition2018(int position2018) {
        this.position2018 = position2018;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDirector() {
        return director;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public int getYear() {
        return year;
    }

    public void setYear(int year) {
        this.year = year;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public int getLength() {
        return length;
    }

    public void setLength(int length) {
        this.length = length;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }
}
