package test;

import com.omertron.themoviedbapi.MovieDbException;
import com.omertron.themoviedbapi.TheMovieDbApi;
import com.omertron.themoviedbapi.model.media.MediaBasic;
import com.omertron.themoviedbapi.model.movie.MovieBasic;
import com.omertron.themoviedbapi.model.movie.MovieInfo;
import com.omertron.themoviedbapi.results.ResultList;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.text.NumberFormat;
import java.util.List;
import java.util.Scanner;
import movietracer.Movie;

/**
 * A CMD line search for movies 
 * @author Sukhjinder
 */


public class movieCMDLineSearch {
    
    static TheMovieDbApi tmdb;
    static MovieBasic MVB = new MovieBasic();

    public static void main(String[] args) throws MovieDbException, IOException {

        String apiKey = new String(Files.readAllBytes(Paths.get("C:\\Users\\Sukhjinder\\Desktop\\API Key.txt")));
        tmdb = new TheMovieDbApi(apiKey);
        System.out.println("Enter Title of Movie or Z to exit");
        Scanner keyboard = new Scanner(System.in);
        String movieTitle = keyboard.nextLine();
        while(!movieTitle.equalsIgnoreCase("Z")){
        
        int counter = 0;
        ResultList<MediaBasic> resultList = tmdb.searchMulti(movieTitle, counter, "en", Boolean.TRUE);
        List<MediaBasic> list = resultList.getResults();
        Movie movie;

        for(int i =0; i<list.size();i++)
        {
            if(list.get(i).getMediaType().toString().equalsIgnoreCase("Movie"))
            {
                MVB = (MovieBasic) list.get(i);
                String title = MVB.getTitle();
                String releaseDate = MVB.getReleaseDate();
                int id = MVB.getId();
                MovieInfo movieInfo = tmdb.getMovieInfo(id, "en", args);
                long budget = movieInfo.getBudget();
                long revenue = movieInfo.getRevenue();
                String overview = movieInfo.getOverview();
                int runTime = movieInfo.getRuntime();
                String posterPath = movieInfo.getPosterPath();              
                
                movie = new Movie();
                movie.setReleaseDate(releaseDate);
                movie.setTitle(title);
                movie.setBudget(budget);
                movie.setBudget(budget);
                movie.setRevenue(revenue);
                movie.setOverview(overview);
                movie.setRunTime(runTime);
                
                
                System.out.println("------------------------MOVIE INFO------------------------");               
                System.out.println("Title: " + title);
                System.out.println("Release Date: " + movie.getReleaseDate());
                System.out.println("Budget $" + NumberFormat.getInstance().format(movie.getBudget()));
                System.out.println("Revenue $" + NumberFormat.getInstance().format(movie.getRevenue()));
                System.out.println("Overview: " + movie.getOverview());
                System.out.println("Run Time: " + movie.getRunTime());
                System.out.println("Poster Path " + "https://image.tmdb.org/t/p/w185" + posterPath);
                System.out.println();
            }
        }
        System.out.println("Enter Title of Movie");
        movieTitle = keyboard.nextLine();
        }
    }
        
    
    
    
    
    
    
}
