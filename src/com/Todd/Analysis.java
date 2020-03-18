package com.Todd;

import java.util.ArrayList;
import java.util.Random;

public class Analysis {
    public Analysis() {
    }

    public int numberOfFilmsDirectedBy(ArrayList<Film> filmArrayList, String director){
        int count = 0;
        for (Film film : filmArrayList){
            if (film.getDirector().equals(director)){
                count++;
            }
        }
        return count;
    }

    public int numberOfFilmsDirectedBySimilar(ArrayList<Film> filmArrayList, String director){
        int count = 0;
        for (Film film : filmArrayList){
            if (film.getDirector().indexOf(director) != -1){
                count++;
            }
        }
        return count;
    }

    public int sumOfFilmLengthsDirectedBy(ArrayList<Film> filmArrayList, String director){
        int sum = 0;
        for (Film film : filmArrayList){
            if (film.getDirector().equals(director)){
                sum += film.getLength();
            }
        }
        return sum;
    }

    public Film randomMovie(ArrayList<Film> filmArrayList){
        Random random = new Random();
        int randomInt = random.nextInt(1000-1) + 1;
        return filmArrayList.get(randomInt);
    }

    public int numberOfFilmsInbetweenYears(ArrayList<Film> filmArrayList, int minYear, int maxYear){
        int count = 0;
        for (Film film: filmArrayList){
            if (minYear <= film.getYear() && maxYear >= film.getYear()){
                count++;
            }
        }
        return count;
    }

    public double averageFilmLengthByDirector(ArrayList<Film> filmArrayList, String director){
        int filmCount = numberOfFilmsDirectedBy(filmArrayList, director);
        int sumFilmLengths = sumOfFilmLengthsDirectedBy(filmArrayList, director);

        double averageLength = (double)sumFilmLengths/filmCount;
        return averageLength;
    }
}
