
package org.howard.edu.lsp.midterm.crccards;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Manages books and coordinates library lending operations.
 *
 * @author Nydeef Taylor
 */
public class Library {

    private final Map<String, Book> books = new HashMap<>();
    private static final int BORROWING_LIMIT = 3;

    /**
     * Adds a book to the library.
     *
     * @param book the book to add
     * @throws IllegalArgumentException if the book is null or its ISBN already exists
     */
    public void addBook(Book book) {
        if (book == null) {
            throw new IllegalArgumentException("Book cannot be null.");
        }

        if (books.containsKey(book.getIsbn())) {
            throw new IllegalArgumentException("Duplicate ISBN: " + book.getIsbn());
        }

        books.put(book.getIsbn(), book);
    }

    /**
     * Finds a book using its ISBN.
     *
     * @param isbn the ISBN to search for
     * @return the matching book, or null if it is not found
     */
    public Book findBook(String isbn) {
        return books.get(isbn);
    }

    /**
     * Borrows a book if it exists, is available, and the borrowing limit permits it.
     *
     * @param isbn the ISBN of the book to borrow
     * @throws IllegalArgumentException if the ISBN is not in the library
     * @throws IllegalStateException if the book is unavailable or the limit is reached
     */
    public void borrowBook(String isbn) {
        Book book = findBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book not found: " + isbn);
        }

        if (getBorrowedBookCount() >= BORROWING_LIMIT) {
            throw new IllegalStateException("Borrowing limit reached.");
        }

        book.borrowBook();
    }

    /**
     * Returns a borrowed book to the library.
     *
     * @param isbn the ISBN of the book to return
     * @throws IllegalArgumentException if the ISBN is not in the library
     * @throws IllegalStateException if the book is already available
     */
    public void returnBook(String isbn) {
        Book book = findBook(isbn);

        if (book == null) {
            throw new IllegalArgumentException("Book not found: " + isbn);
        }

        book.returnBook();
    }

    /**
     * Retrieves all books that are currently available.
     *
     * @return a list of available books
     */
    public List<Book> getAvailableBooks() {
        List<Book> availableBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.isAvailable()) {
                availableBooks.add(book);
            }
        }

        return availableBooks;
    }

    /**
     * Retrieves books written by the specified author.
     * The comparison is case-sensitive and includes borrowed books.
     *
     * @param author the author to search for
     * @return a list of matching books
     */
    public List<Book> getBooksByAuthor(String author) {
        List<Book> matchingBooks = new ArrayList<>();

        for (Book book : books.values()) {
            if (book.getAuthor().equals(author)) {
                matchingBooks.add(book);
            }
        }

        return matchingBooks;
    }

    /**
     * Retrieves all books sorted by ISBN in ascending lexicographical order.
     *
     * @return a sorted list of books
     */
    public List<Book> getBooksSortedByIsbn() {
        List<Book> sortedBooks = new ArrayList<>(books.values());
        sortedBooks.sort(Comparator.comparing(Book::getIsbn));
        return sortedBooks;
    }

    /**
     * Counts the books currently borrowed from the library.
     *
     * @return the number of borrowed books
     */
    public int getBorrowedBookCount() {
        int count = 0;

        for (Book book : books.values()) {
            if (!book.isAvailable()) {
                count++;
            }
        }

        return count;
    }
}
