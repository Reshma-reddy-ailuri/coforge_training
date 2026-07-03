package com.coforge.day3;

public class Movie {

    private String movieName;
    private String director;
    private double rating;

    public String getMovieName() {
        return movieName;
    }

    public String getDirector() {
        return director;
    }

    public double getRating() {
        return rating;
    }

    public void setMovieName(String movieName) {
        this.movieName = movieName;
    }

    public void setDirector(String director) {
        this.director = director;
    }

    public void setRating(double rating) {
        this.rating = rating;
    }

    @Override
    public String toString() {

        return "Movie Name : " + movieName +
                "\nDirector : " + director +
                "\nRating : " + rating;

    }

    public static void main(String[] args) {

        Movie movie = new Movie();

        movie.setMovieName("Inception");
        movie.setDirector("Christopher Nolan");
        movie.setRating(9.0);

        System.out.println(movie);
    }
}
