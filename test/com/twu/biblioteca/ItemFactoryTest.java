package com.twu.biblioteca;

import com.twu.biblioteca.item.Book;
import com.twu.biblioteca.item.ItemFactory;
import com.twu.biblioteca.item.Movie;
import org.junit.Test;

import java.util.LinkedList;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class ItemFactoryTest {

    public static List<Movie> createFakeMovies() {
        List<Movie> li = new LinkedList<>();
        Movie b = new Movie("Test", "Foo Bar", 999);
        li.add(b);
        b = new Movie("Hello", "World", 1, 5);
        li.add(b);
        return li;
    }


    public static List<Book> createFakeBooks() {
        List<Book> li = new LinkedList<>();
        Book b = new Book("Test Book", "Foo Bar", 999);
        li.add(b);
        b = new Book("Another One", "Rubber Ducky", 1);
        li.add(b);
        return li;
    }


    @Test
    public void testBookTitles() throws Exception {
        ItemFactory factory = new ItemFactory();
        assertThat(factory.getBookList().get(0).getTitle(), is("Art of War"));
        assertThat(factory.getBookList().get(1).getTitle(), is("Infinite Jest"));
        assertThat(factory.getBookList().get(2).getTitle(), is("David and Goliath"));

    }

    @Test
    public void testBookAuthors() throws Exception {
        ItemFactory factory = new ItemFactory();
        assertThat(factory.getBookList().get(0).getAuthor(), is("Sun Tzu"));
        assertThat(factory.getBookList().get(1).getAuthor(), is("David Foster Wallace"));
        assertThat(factory.getBookList().get(2).getAuthor(), is("Malcolm Gladwell"));

    }

    @Test
    public void testBookYears() throws Exception {
        ItemFactory factory = new ItemFactory();
        assertThat(factory.getBookList().get(0).getYear(), is(500));
        assertThat(factory.getBookList().get(1).getYear(), is(1996));
        assertThat(factory.getBookList().get(2).getYear(), is(2013));

    }
    @Test
    public void testMovieTitles()  {
        ItemFactory factory = new ItemFactory();
        assertThat(factory.getMovieList().get(0).getTitle(), is("Black Panther"));
        assertThat(factory.getMovieList().get(1).getTitle(), is("Whiplash"));
        assertThat(factory.getMovieList().get(2).getTitle(), is("Parasite"));

    }

    @Test
    public void testMovieDirectors()  {
        ItemFactory factory = new ItemFactory();
        assertThat(factory.getMovieList().get(0).getDirector(), is("Chadwick Boseman"));
        assertThat(factory.getMovieList().get(1).getDirector(), is("Damien Chazelle"));
        assertThat(factory.getMovieList().get(2).getDirector(), is("Bong Joon-ho"));

    }

    @Test
    public void testMovieYears() {
        ItemFactory factory = new ItemFactory();
        assertThat(factory.getMovieList().get(0).getYear(), is(2018));
        assertThat(factory.getMovieList().get(1).getYear(), is(2013));
        assertThat(factory.getMovieList().get(2).getYear(), is(2019));

    }

    @Test
    public void testMovieRatings()  {
        ItemFactory factory = new ItemFactory();
        assertThat(factory.getMovieList().get(0).getRating(), is(0));
        assertThat(factory.getMovieList().get(1).getRating(), is(8));
        assertThat(factory.getMovieList().get(2).getRating(), is(9));

    }

    @Test
    public void testIllegalRating() { // illegal ratings to be set to 0
        Movie m = new Movie("A", "B", 1, -10);
        assertThat(m.getRating(), is(0));
    }
}