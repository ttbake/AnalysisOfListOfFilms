package com.Todd;

public class Film {
    private int position;
    private int position2021;
    private int position2020;
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

    public int getPosition2021() {
        return position2021;
    }

    public void setPosition2023(int position2021) {
        this.position2021 = position2021;
    }

    public int getPosition2020() {
        return position2020;
    }

    public void setPosition2020(int position2020) {
        this.position2020 = position2020;
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
