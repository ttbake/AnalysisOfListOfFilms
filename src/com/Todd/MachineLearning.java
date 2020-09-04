package com.Todd;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class MachineLearning{
    private List<Film> listOfFilms;

    public List<Film> getListOfFilms() {
        return listOfFilms;
    }

    public void setListOfFilms(List<Film> listOfFilms) {
        this.listOfFilms = listOfFilms;
    }

    public MachineLearning(ArrayList<Film> filmArrayList) {
        setListOfFilms(filmArrayList);
    }

    List<Film> createListOfSeenFilms(){
        List<Film> seenFilms = new ArrayList<>();
        for(Film film : this.getListOfFilms()){
            if(film.getSeen()){
                seenFilms.add(film);
            }
        }
        return seenFilms;
    }

    List<Film> createListOfUnseenFilms(){
        List<Film> unseenFilms = new ArrayList<>();
        for(Film film : this.getListOfFilms()){
            if(!film.getSeen()){
                unseenFilms.add(film);
            }
        }
        return unseenFilms;
    }

    Film fetchRandomUnseenFilm(){
        List<Film> unseenFilms = createListOfUnseenFilms();
        Random random = new Random();
        int randomInt = random.nextInt(unseenFilms.size()-1) + 1;
        return unseenFilms.get(randomInt);
    }
}
