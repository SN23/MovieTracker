/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package movieTracker;

import java.util.ArrayList;

/**
 *
 * @author Sukhjinder
 */
public class MovieList {
    ArrayList<Movie> movieList;
    String listName;

    
    
    
    public String getListName() {
        return listName;
    }

    public void setListName(String listName) {
        this.listName = listName;
    }
    

    public ArrayList<Movie> getMovieList() {
        return movieList;
    }

    public void setMovieList(ArrayList<Movie> movieList) {
        this.movieList = movieList;
    }
    
    
    
}
