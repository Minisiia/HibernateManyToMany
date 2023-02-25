package many_to_many;


import many_to_many.entity.Author;
import many_to_many.entity.Book;
import org.jboss.logging.Logger;

import java.util.List;

/**
 *
 */
public class Main {

    private static final Logger LOG = Logger.getLogger(AuthorHelper.class.getName());

    public static void main(String[] args) {
        AuthorHelper ah = new AuthorHelper();
        BookHelper bh = new BookHelper();
        System.out.println((char) 27 + "[34m" + "Books with several authors:" + (char) 27 + "[38m");
        List<Book> bookList = bh.getBookList();
        for (Book book : bookList) {
            List<Author> authorList = book.getAuthors();
            if (authorList.size() > 1) {
                System.out.println((char) 27 + "[34m" + "Book: " + book.getName() + (char) 27 + "[38m");
                System.out.println((char) 27 + "[34m" + "Authors:" + (char) 27 + "[38m");
                for (Author author : authorList) {
                    LOG.info(author.getName() + " " + author.getLastName());
                }
            }
        }
        System.out.println((char) 27 + "[34m" + "Authors with several books:" + (char) 27 + "[38m");
        List<Author> authorList = ah.getAuthorList();
        Author author = new Author();
        for (int i = 1; i <= authorList.size(); i++) {
            author = ah.getAuthorById(i);
            bookList = author.getBooks();
            if (bookList.size() > 1) {
                System.out.println((char) 27 + "[34m" + "Author: " + author.getName() + " " + author.getLastName() + (char) 27 + "[38m");
                System.out.println((char) 27 + "[34m" + "Books:" + (char) 27 + "[38m");
                for (Book book : bookList) {
                    LOG.info(book.getName());
                }
            }
        }
    }
}
