package item;

import java.util.LinkedList;
import java.util.List;

public class ItemFactory {
    private List<Movie> movieList;
    private List<Book> bookList;

    public ItemFactory() {
        bookList = new LinkedList<>();
        bookList.add(new Book("Art of War", "Sun Tzu", 500));
        bookList.add(new Book("Infinite Jest", "David Foster Wallace", 1996));
        bookList.add(new Book("David and Goliath", "Malcolm Gladwell", 2013));

        movieList = new LinkedList<>();
        movieList.add(new Movie("Black Panther", "Chadwick Boseman", 2018));
        movieList.add(new Movie("Whiplash", "Damien Chazelle", 2013, 8));
        movieList.add(new Movie("Parasite", "Bong Joon-ho", 2019, 9));
    }

    public List<Movie> getMovieList() {
        return movieList;
    }
    public List<Book> getBookList() {
        return bookList;
    }

}
