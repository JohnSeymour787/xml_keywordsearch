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
    private final String mpaa;
    private final ArrayList<String> languages;
    private final ArrayList<String> companies;
    private final ArrayList<Person> cast;
    private final ArrayList<String> keywords;

    public Movie(String title, int year, float rating, ArrayList<Person> directors, ArrayList<String> genres, ArrayList<Person> writers, ArrayList<String> countries, String mpaa, ArrayList<String> languages, ArrayList<String> companies, ArrayList<Person> cast, ArrayList<String> keywords)
    {
        this.title = title;
        this.year = year;
        this.rating = rating;
        this.directors = directors;
        this.genres = genres;
        this.writers = writers;
        this.countries = countries;
        this.mpaa = mpaa;
        this.languages = languages;
        this.companies = companies;
        this.cast = cast;
        this.keywords = keywords;
    }

    @Override
    public String toString()
    {
        return title + " (" + year + ")" + "\r\n" +
               "Rating: " + rating + "\r\n" +
               "Directors:\r\n" + displayArrayString(directors) + "\r\n" +
                (genres != null ? "Genres: \r\n" + displayArrayString(genres) + "\r\n" : "") +
               "Writers:\r\n" + displayArrayString(writers) + "\r\n" +
               "Countries:\r\n" + displayArrayString(countries) + "\r\n" +
                (mpaa != null ? "Mpaa: " + mpaa + "\r\n" : "") +
               "Languages:\r\n" + displayArrayString(languages) + "\r\n" +
               "Companies:\r\n" + displayArrayString(companies) + "\r\n" +
               "Cast:\r\n" + displayArrayString(cast) + "\r\n" +
               "Keywords:\r\n" + displayArrayString(keywords);
    }

    /**
     * Calls .toString() on an array of objects and concatenates the result into a single String object that appears
     *  in a list format with newlines for each element.
     * @param list - Array of any type
     * @param <T> - Any object type with a .toString() implementation
     * @return - String representing all elements combined as a bulleted list
     */
    private <T> String displayArrayString(ArrayList<T> list)
    {
        StringBuilder result = new StringBuilder();

        for (int i = 0; i < list.size(); i++)
        {
            result.append("  - ").append(list.get(i).toString());
            // Add a new line if not the last element
            if (i < list.size() - 1)
            {
                result.append("\r\n");
            }
        }
        return result.toString();
    }

    public String getMpaa()
    {
        return mpaa;
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

    public ArrayList<String> getKeywords()
    {
        return keywords;
    }
}