package com.Todd;

import java.util.ArrayList;
import java.util.Arrays;
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

    public int medianLength(boolean seen){
        int lengthArray[] = new int[countFilmBySeen(seen)];
        int i = 0;
        for (Film film :this.getListOfFilms()) {
            if (film.getSeen() == seen){
                lengthArray[i] = film.getLength();
                i++;
            }
        }
        Arrays.sort(lengthArray);
        if (lengthArray.length % 2 == 1){
            return lengthArray[(lengthArray.length + 1)/2 - 1];
        }
        else{
            return (lengthArray[lengthArray.length/2-1]+lengthArray[lengthArray.length/2])/2;
        }
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

    public int sumOfFilmLengthBySeenUnseen(boolean seen){
        int sum = 0;
        for (Film film : this.getListOfFilms()){
            if (film.getSeen() == seen){
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

    public double averageFilmLength(boolean seen){
        double sum = 0;
        double average = 0.0;
        int count = 0;
        for (Film film: this.getListOfFilms()){
            if (film.getSeen() == seen){
                sum += film.getLength();
                count++;
            }
        }
        average = sum / count;
        return average;
    }

    public int countFilmBySeen(boolean seen){
        int count = 0;
        for (Film film: this.getListOfFilms()){
            if (film.getSeen() == seen){
                count++;
            }
        }
        return count;
    }

    public double percentageSeenUnseen(boolean seen){
        int countSeenUnseen = countFilmBySeen(seen);
        int totalFilmCount = this.getListOfFilms().size();
        double percentage = (double) countSeenUnseen / totalFilmCount;
        return percentage;
    }

    public double percentageSeenUnseenByFilmLength(boolean seen){
        int totalLengthSeen = sumOfFilmLengthBySeenUnseen(true);
        int totalLengthUnseen = sumOfFilmLengthBySeenUnseen(false);
        if (seen){
            return ((double)totalLengthSeen / (totalLengthSeen + totalLengthUnseen));
        }
        else{
            return ((double)totalLengthUnseen / (totalLengthSeen + totalLengthUnseen));
        }
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
