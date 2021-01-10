package com.Todd;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.io.IOException;
import java.util.Random;

public class Main {

    public static void main(String[] args) {
        //this holds the csv file location
	    String fileName = "1000GreatestFilms.csv";
	    //String fileName = "21stCenturyFilms.csv";
	    String line;
	    String splitBy = ",(?=(?:[^\\\"]*\\\"[^\\\"]*\\\")*[^\\\"]*$)";
	    int lineCount = 0;
        //Buffered reader class is a java.io class which reads
        //a character input file, it reads lines and arrays
        //File reader opens the given file in read mode
        ArrayList<Film> filmArrayList = new ArrayList<>();

        try (BufferedReader bufferedReader = new BufferedReader(new FileReader(fileName))) {
            //readline function is used to read a line from the file
            while ((line = bufferedReader.readLine()) != null){
                lineCount++;
                if (lineCount == 1){
                    continue;
                }
                //loop will continue until the line ends
                String[] filmData = line.split(splitBy);
                // split function use to split the words in the line by commas
                Film film = new Film();
                film.setPosition(Integer.parseInt(filmData[0]));
                if (!filmData[1].equals("---")){
                    film.setPosition2019(Integer.parseInt(filmData[1]));
                }
                if (!filmData[2].equals("---")){
                    film.setPosition2018(Integer.parseInt(filmData[2]));
                }
                film.setTitle(filmData[3].replace("\"",""));
                film.setDirector(filmData[4].replace("\"",""));
                film.setYear(Integer.parseInt(filmData[5]));
                film.setCountry(filmData[6].replace("\"",""));
                film.setLength(Integer.parseInt(filmData[7]));
                film.setGenre(filmData[8].replace("\"",""));
                film.setColor(filmData[9].replace("\"",""));
                if (filmData.length > 10){
                    film.setSeen(true);
                }
                else{
                    film.setSeen(false);
                }
                filmArrayList.add(film);
            }
        }
        catch (IOException e){
            e.printStackTrace();
        }
        Analysis analysis = new Analysis(filmArrayList);
        String directorExact = "Lang, Fritz";
        String directorSimilar = "Bergman";
        int numberDirectedBy = analysis.numberOfFilmsDirectedBy(directorExact);
        int numberSimilarDirectedBy = analysis.numberOfFilmsDirectedBySimilar(directorSimilar);
        System.out.println("Number of films directed by " + directorExact + " using exact calculation: " + numberDirectedBy);
        System.out.println("Number of films directed by " + directorSimilar + " using similar calculation: " + numberSimilarDirectedBy);
        System.out.println("Average length of films directed by " + directorExact + ": " + analysis.averageFilmLengthByDirector(directorExact));

        System.out.println("Random movie " + analysis.randomMovie().toString());

        Random random = new Random();
        int firstYear = random.nextInt(2019-1902) + 1902;
        int secondYear = random.nextInt(2019-firstYear) + firstYear;
        System.out.println("Number of films between " + firstYear + " and " + secondYear + " is " + analysis.numberOfFilmsInbetweenYears(firstYear, secondYear));

        //MachineLearning machineLearning = new MachineLearning(filmArrayList);
        //System.out.println("Random unseen movie " + machineLearning.fetchRandomUnseenFilm().toString());

        System.out.println("Average length of seen movies " + analysis.averageFilmLength(true));
        System.out.println("Average length of unseen movies " + analysis.averageFilmLength(false));

        System.out.println("Percentage of films seen " + analysis.percentageSeenUnseen(true) * 100);
        System.out.println("Percentage of films seen by length " + analysis.percentageSeenUnseenByFilmLength(true) * 100);

        System.out.println("Median length of seen movies " + analysis.medianLength(true));
        System.out.println("Median length of unseen movies " + analysis.medianLength(false));


        Output output = new Output();
        output.writeFile(filmArrayList);
    }
}
