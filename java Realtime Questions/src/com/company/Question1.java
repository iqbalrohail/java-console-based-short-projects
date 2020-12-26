package com.company;

import java.io.FileReader;
import java.io.FileWriter;

import java.util.Scanner;

class FavouriteMovie {
    private String MovieName, DirectorName, ProducerName, DateOfReleased;

    public void setMovieName(String movieName) {
        MovieName = movieName;
    }

    public void setDirectorName(String directorName) {
        DirectorName = directorName;
    }

    public void setProducerName(String producerName) {
        ProducerName = producerName;
    }

    public void setDateOfReleased(String dateOfReleased) {
        DateOfReleased = dateOfReleased;
    }

    public void displayMovieDetails() {
// Writting to a file
        try {
            FileWriter MovieDetailsWriter = new FileWriter("MovieDetails.txt");

            System.out.println("The name of your favourite movie is " + MovieName);
            MovieDetailsWriter.write("The name of your favourite movie is " + MovieName + "\n");

            System.out.println("The name of Movie's Director is " + DirectorName);
            MovieDetailsWriter.write("The name of Movie's Director is " + DirectorName + "\n");

            System.out.println("The name of Movie's Producer is " + ProducerName);
            MovieDetailsWriter.write("The name of Movie's Producer is " + ProducerName + "\n");

            System.out.println("The released date of movie in Format(M/day/date) " + DateOfReleased);
            MovieDetailsWriter.write("The released date of movie in Format(M/day/date) " + DateOfReleased + "\n");

            MovieDetailsWriter.close();


        } catch (Exception e) {
            System.out.println(e);
        }  // catiching exception in catch block
        System.out.println("Success...");
    }


    void readMovieDetails() // reading to a file
    {
        try {
            FileReader MovieDetailsReader = new FileReader("MovieDetails.txt");
            int i;
            while ((i = MovieDetailsReader.read()) != -1)
                System.out.print((char) i);
            MovieDetailsReader.close();
        } catch (Exception e) {
            System.out.println(e);
        }
        System.out.println("DOne");

    }


}


public class Question1 {
    public static void main(String[] args) {
        char Decision;
        FavouriteMovie favouriteMovie = new FavouriteMovie();  // declaring object

        Scanner scanner = new Scanner(System.in);
        String MovieName, DirectorName, ProducerName, DateOfReleased;
        System.out.println("Press 1 for Enter Movie Details\n press 2 to show MovieDetails");
        Decision = scanner.nextLine().charAt(0);

        if (Decision == '1') {

            System.out.println("Enter Name of your favourite movie");
            MovieName = scanner.nextLine();

            System.out.println("Enter name of Movies Director");
            DirectorName = scanner.nextLine();

            System.out.println("Enter Name of movie's Producer");
            ProducerName = scanner.nextLine();

            System.out.println("Enter released date of movie M/day/date");
            DateOfReleased = scanner.nextLine();

            // calling setters
            favouriteMovie.setMovieName(MovieName);
            favouriteMovie.setDirectorName(DirectorName);
            favouriteMovie.setProducerName(ProducerName);
            favouriteMovie.setDateOfReleased(DateOfReleased);
            favouriteMovie.displayMovieDetails();
        } else if (Decision == '2')
            favouriteMovie.readMovieDetails();


    }
}
