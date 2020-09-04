package com.Todd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Analysis {
    public List<Film> getListOfFilms() {
        return listOfFilms;
    }

    public void setListOfFilms(List<Film> listOfFilms) {
        this.listOfFilms = listOfFilms;
    }

    private List<Film> listOfFilms;

    public Analysis(ArrayList<Film> filmArrayList) {
        setListOfFilms(filmArrayList);
    }

    public int numberOfFilmsDirectedBy(String director){
        int count = 0;
        for (Film film : this.getListOfFilms()){
            if (film.getDirector().equals(director)){
                count++;
            }
        }
        return count;
    }

    public int numberOfFilmsDirectedBySimilar(String director){
        int count = 0;
        for (Film film : this.getListOfFilms()){
            if (film.getDirector().indexOf(director) != -1){
                count++;
            }
        }
        return count;
    }

    public int sumOfFilmLengthsDirectedBy(String director){
        int sum = 0;
        for (Film film : this.getListOfFilms()){
            if (film.getDirector().equals(director)){
                sum += film.getLength();
            }
        }
        return sum;
    }

    public Film randomMovie(){
        Random random = new Random();
        int randomInt = random.nextInt(1000-1) + 1;
        return this.getListOfFilms().get(randomInt);
    }

    public int numberOfFilmsInbetweenYears(int minYear, int maxYear){
        int count = 0;
        for (Film film: this.getListOfFilms()){
            if (minYear <= film.getYear() && maxYear >= film.getYear()){
                count++;
            }
        }
        return count;
    }

    public double averageFilmLengthByDirector(String director){
        int filmCount = numberOfFilmsDirectedBy(director);
        int sumFilmLengths = sumOfFilmLengthsDirectedBy(director);

        double averageLength = (double)sumFilmLengths/filmCount;
        return averageLength;
    }
}
