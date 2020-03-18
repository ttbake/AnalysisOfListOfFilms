package com.Todd;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

public class Output {
    //Delimiters which has to be in the CSV file
    private static final String TAB_DELIMITER = "\t";
    private static final String LINE_SEPARATOR = "\n";

    //File header
    private static final String HEADER = "Pos\t2019\t2018\tTitle\tDirector\tYear\tCountry\tLength\tGenre\tColour\tSeen";

    public void writeFile(ArrayList<Film> filmArrayList)
    {
        FileWriter fileWriter = null;

        try
        {
            fileWriter = new FileWriter("ThousandGreatestFilms.txt");

            //Adding the header
            fileWriter.append(HEADER);
            //New Line after the header
            fileWriter.append(LINE_SEPARATOR);

            //Iterate the filmArrayList
            Iterator it = filmArrayList.iterator();
            while(it.hasNext())
            {
                Film film = (Film)it.next();
                fileWriter.append(String.valueOf(film.getPosition()));
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(String.valueOf(film.getPosition2019()));
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(String.valueOf(film.getPosition2018()));
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(film.getTitle());
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(film.getDirector());
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(String.valueOf(film.getYear()));
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(film.getCountry());
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(String.valueOf(film.getLength()));
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(film.getGenre());
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(film.getColor());
                fileWriter.append(TAB_DELIMITER);
                fileWriter.append(String.valueOf(film.getSeen()));
                fileWriter.append(LINE_SEPARATOR);
            }
            System.out.println("Write to txt file Succeeded!!!");
        }
        catch(Exception ee)
        {
            ee.printStackTrace();
        }
        finally
        {
            try
            {
                fileWriter.close();
            }
            catch(IOException ie)
            {
                System.out.println("Error occured while closing the fileWriter");
                ie.printStackTrace();
            }
        }
    }
}
