package com.Todd;

import java.util.ArrayList;

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
}
