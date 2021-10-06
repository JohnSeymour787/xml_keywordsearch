package assignment2;

import java.util.ArrayList;

public class Movie
{
    private final String title;
    private final int year;
    private final float rating;
    private final ArrayList<Person> directors;
    private final ArrayList<String> genres;
    private final ArrayList<Person> writers;
    private final ArrayList<String> countries;
    private final ArrayList<String> languages;
    private final ArrayList<String> companies;
    private final ArrayList<Person> cast;
    private final ArrayList<String> kws;

    public Movie(String title, int year, float rating, ArrayList<Person> directors, ArrayList<String> genres, ArrayList<Person> writers, ArrayList<String> countries, ArrayList<String> languages, ArrayList<String> companies, ArrayList<Person> cast, ArrayList<String> kws)
    {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.directors = directors;
        this.genres = genres;
        this.writers = writers;
        this.countries = countries;
        this.languages = languages;
        this.companies = companies;
        this.cast = cast;
        this.kws = kws;
    }

    public String getTitle()
    {
        return title;
    }

    public int getYear()
    {
        return year;
    }

    public float getRating()
    {
        return rating;
    }

    public ArrayList<Person> getDirectors()
    {
        return directors;
    }

    public ArrayList<String> getGenres()
    {
        return genres;
    }

    public ArrayList<Person> getWriters()
    {
        return writers;
    }

    public ArrayList<String> getCountries()
    {
        return countries;
    }

    public ArrayList<String> getLanguages()
    {
        return languages;
    }

    public ArrayList<String> getCompanies()
    {
        return companies;
    }

    public ArrayList<Person> getCast()
    {
        return cast;
    }

    public ArrayList<String> getKws()
    {
        return kws;
    }
}