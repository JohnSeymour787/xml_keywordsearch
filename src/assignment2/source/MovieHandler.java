package assignment2.source;

import assignment2.Movie;
import assignment2.Person;
import org.xml.sax.Attributes;
import org.xml.sax.SAXException;
import org.xml.sax.helpers.DefaultHandler;
import java.util.ArrayList;

public class MovieHandler extends DefaultHandler
{
    private final ArrayList<Movie> movies;

    private boolean movieRead = false;
    private boolean titleRead = false;
    private boolean yearRead = false;
    private boolean ratingRead = false;
    private boolean directorsRead = false;
    private boolean directorItemRead = false;
    private boolean writersRead = false;
    private boolean writerItemRead = false;
    private boolean personNameRead = false;
    private boolean personRoleRead = false;
    private boolean genresRead = false;
    private boolean genreItemRead = false;
    private boolean countriesRead = false;
    private boolean countryItemRead = false;
    private boolean mpaaRead = false;
    private boolean languagesRead = false;
    private boolean languageItemRead = false;
    private boolean companiesRead = false;
    private boolean companyItemRead = false;
    private boolean castRead = false;
    private boolean castItemRead = false;
    private boolean keywordsRead = false;
    private boolean keywordItemRead = false;

    private String title;
    private Integer year;
    private Float rating;
    private String mpaa;
    private ArrayList<Person> directors;
    private ArrayList<String> genres;
    private ArrayList<Person> writers;
    private ArrayList<String> countries;
    private ArrayList<String> languages;
    private ArrayList<String> companies;
    private ArrayList<Person> cast;
    private ArrayList<String> keywords;

    private String personName;
    private String personRole;

    public MovieHandler(ArrayList<Movie> movies)
    {
        this.movies = movies;
    }

    @Override
    public void startElement(String uri, String localName, String qName, Attributes attributes)
    {
        if (qName.equalsIgnoreCase("movie"))
        {
            movieRead = true;
        }

        if (qName.equalsIgnoreCase("title"))
        {
            titleRead = true;
        }

        if (qName.equalsIgnoreCase("year"))
        {
            yearRead = true;
        }

        if (qName.equalsIgnoreCase("rating"))
        {
            ratingRead = true;
        }

        if (qName.equalsIgnoreCase("ds"))
        {
            directors = new ArrayList<>();
            directorsRead = true;
        }

        if (directorsRead && qName.equalsIgnoreCase("director"))
        {
            directorItemRead = true;
        }

        if ((directorItemRead || writerItemRead || castItemRead) && qName.equalsIgnoreCase("name"))
        {
            personNameRead = true;
        }

        if ((directorItemRead || writerItemRead || castItemRead) && qName.equalsIgnoreCase("role"))
        {
            personRoleRead = true;
        }

        if (qName.equalsIgnoreCase("genres"))
        {
            genres = new ArrayList<>();
            genresRead = true;
        }

        if (genresRead && qName.equalsIgnoreCase("item"))
        {
            genreItemRead = true;
        }

        if (qName.equalsIgnoreCase("ws"))
        {
            writers = new ArrayList<>();
            writersRead = true;
        }

        if (writersRead && qName.equalsIgnoreCase("writer"))
        {
            writerItemRead = true;
        }

        if (qName.equalsIgnoreCase("cts"))
        {
            countries = new ArrayList<>();
            countriesRead = true;
        }

        if (countriesRead && qName.equalsIgnoreCase("country"))
        {
            countryItemRead = true;
        }

        if (qName.equalsIgnoreCase("mpaa"))
        {
            mpaaRead = true;
        }

        if (qName.equalsIgnoreCase("ls"))
        {
            languages = new ArrayList<>();
            languagesRead = true;
        }

        if (languagesRead && qName.equalsIgnoreCase("language"))
        {
            languageItemRead = true;
        }

        if (qName.equalsIgnoreCase("cps"))
        {
            companies = new ArrayList<>();
            companiesRead = true;
        }

        if (companiesRead && qName.equalsIgnoreCase("company"))
        {
            companyItemRead = true;
        }

        if (qName.equalsIgnoreCase("cast"))
        {
            cast = new ArrayList<>();
            castRead = true;
        }

        if (castRead && qName.equalsIgnoreCase("p"))
        {
            castItemRead = true;
        }

        if (qName.equalsIgnoreCase("kws"))
        {
            keywords = new ArrayList<>();
            keywordsRead = true;
        }

        if (keywordsRead && qName.equalsIgnoreCase("kw"))
        {
            keywordItemRead = true;
        }
    }

    @Override
    public void endElement(String uri, String localName, String qName)
    {
        // Using this method to know when parent tags end, for content that is nested in sub tags

        // Reset everything to null, create the movie and add to array
        if (movieRead && qName.equalsIgnoreCase("movie"))
        {
            movieRead = false;
            Movie toAdd = new Movie(title, year, rating, directors, genres, writers, countries, mpaa, languages, companies, cast, keywords);
            movies.add(toAdd);

            title = null;
            year = null;
            rating = null;
            directors = null;
            genres = null;
            writers = null;
            countries = null;
            mpaa = null;
            languages = null;
            companies = null;
            cast = null;
            keywords = null;
        }

        if (directorsRead && qName.equalsIgnoreCase("ds"))
        {
            directorsRead = false;
        }

        if (directorItemRead && qName.equalsIgnoreCase("director"))
        {
            directors.add(new Person(personName, personRole));
            personName = null;
            personRole = null;
            directorItemRead = false;
        }

        if (genresRead && qName.equalsIgnoreCase("genres"))
        {
            genresRead = false;
        }

        if (writersRead && qName.equalsIgnoreCase("ws"))
        {
            writersRead = false;
        }

        if (writerItemRead && qName.equalsIgnoreCase("writer"))
        {
            writers.add(new Person(personName, personRole));
            personName = null;
            personRole = null;
            writerItemRead = false;
        }

        if (countriesRead && qName.equalsIgnoreCase("cts"))
        {
            countriesRead = false;
        }

        if (languagesRead && qName.equalsIgnoreCase("ls"))
        {
            languagesRead = false;
        }

        if (companiesRead && qName.equalsIgnoreCase("cps"))
        {
            companiesRead = false;
        }

        if (castRead && qName.equalsIgnoreCase("cast"))
        {
            castRead = false;
        }

        if (castItemRead && qName.equalsIgnoreCase("p"))
        {
            cast.add(new Person(personName, personRole));
            personName = null;
            personRole = null;
            castItemRead = false;
        }

        if (keywordsRead && qName.equalsIgnoreCase("kws"))
        {
            keywordsRead = false;
        }
    }

    @Override
    public void characters(char[] ch, int start, int length)
    {
        if (titleRead)
        {
            title = new String(ch, start, length);
            titleRead = false;
        }
        else if (yearRead)
        {
            year = new Integer(new String(ch, start, length));
            yearRead = false;
        }
        else if (ratingRead)
        {
            rating = new Float(new String(ch, start, length));
            ratingRead = false;
        }
        else if (personNameRead)
        {
            personName = new String(ch, start, length);
            personNameRead = false;
        }
        else if (personRoleRead)
        {
            personRole = new String(ch, start, length);
            personRoleRead = false;
        }
        else if (genreItemRead)
        {
            genres.add(new String(ch, start, length));
            genreItemRead = false;
        }
        else if (countryItemRead)
        {
            countries.add(new String(ch, start, length));
            countryItemRead = false;
        }
        else if (mpaaRead)
        {
            mpaa = new String(ch, start, length);
            mpaaRead = false;
        }
        else if (languageItemRead)
        {
            languages.add(new String(ch, start, length));
            languageItemRead = false;
        }
        else if (companyItemRead)
        {
            companies.add(new String(ch, start, length));
            companyItemRead = false;
        }
        else if (keywordItemRead)
        {
            keywords.add(new String(ch, start, length));
            keywordItemRead = false;
        }
    }
}