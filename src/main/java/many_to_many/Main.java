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

        List<Book> bookList = bh.getBookList();
        for (Book book : bookList) {
            List<Author> authorList = book.getAuthors();
            if (authorList.size() > 1) {
                LOG.info("Books with several authors:");
                LOG.info("Book: " + book.getName());
                LOG.info("Authors:");
                for (Author author : authorList) {
                    System.out.println(author.getName() + " " + author.getLastName());
                }
            }
        }
        List<Author> authorList = ah.getAuthorList();
        Author author = new Author();
        for (int i = 1; i <= authorList.size(); i++) {
            author = ah.getAuthorById(i);
            bookList = author.getBooks();
            if (bookList.size() > 1) {
                LOG.info("Authors with several books:");
                LOG.info("Author: " + author.getName());
                LOG.info("Books:");
                for (Book book : bookList) {
                    System.out.println(book.getName());
                }
            }

        }
//        List<Author> authorList = ah.getAuthorList();
//       for (Author author : authorList) {
//           List<Book> bookList1 = author.getBooks();
//           for (Book book : bookList1) {
//                    System.out.println(book);
//             }
//       }
//        System.out.println("Authors with several books:");
//        List<Author> authorList = ah.getAuthorList();
//        for (Author author : authorList) {
//            List<Book> bookList1 = author.getBooks();
//            if (bookList1.size() > 1) {
//                System.out.println("Author: " + author.getName() + " " + author.getLastName());
//                System.out.println("Books:");
//                for (Book book : bookList1) {
//                    System.out.println(book.getName());
//                }
//            }
//        }

//        Author author = ah.getAuthorById(1);
//
//        LOG.debug(author.getName());
//
//        List<Book> authorBooks = author.getBooks();
//
//        for (Book book : authorBooks) {
//            LOG.debug(book.getName());
//        }
    }
}
