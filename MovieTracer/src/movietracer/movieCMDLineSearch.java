package movietracer;

import com.omertron.themoviedbapi.MovieDbException;
import com.omertron.themoviedbapi.TheMovieDbApi;
import com.omertron.themoviedbapi.model.movie.MovieBasic;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;


/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Sukhjinder
 */


public class movieCMDLineSearch {
    
    static TheMovieDbApi tmdb;
    static MovieBasic MVB = new MovieBasic();

    public static void main(String[] args) throws MovieDbException, IOException {

        String apiKey = new String(Files.readAllBytes(Paths.get("C:\\Users\\Sukhjinder\\Desktop\\API Key.txt")));
        tmdb = new TheMovieDbApi(apiKey);
        
        
    
    }
    
    
    
    
}
