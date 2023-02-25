package many_to_many.entity;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
//@Table(name = "book")
public class Book {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

//    @ManyToOne
//    @JoinColumn(name = "author_id")
   // @ManyToMany(mappedBy = "books")
/*@ManyToMany(mappedBy = "books")
@JoinTable(name = "author_book",
        joinColumns =  @JoinColumn(name = "book_id"),
        inverseJoinColumns = @JoinColumn(name = "author_id")
)*/
@ManyToMany(mappedBy = "books",fetch = FetchType.EAGER)

    private List<Author> authors;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Author> getAuthors() {
        return authors;
    }

    public void setAuthors(List<Author> authors) {
        this.authors = authors;
    }

    @Override
    public String toString() {
        return "Book{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
