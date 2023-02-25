USE library;

DROP TABLE author_book;
DROP TABLE book;
DROP TABLE author;

CREATE TABLE author
(
    id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
    name VARCHAR(45),
    last_name VARCHAR(45)
);
CREATE TABLE book(
                     id INT PRIMARY KEY NOT NULL AUTO_INCREMENT,
                     name VARCHAR(256),
                     author_id INT,
                     CONSTRAINT FOREIGN KEY (author_id) REFERENCES author(id)
);

INSERT INTO author (name, last_name)
VALUES
    ('Lesya','Ukrainka'),
    ('Ivan','Kotlyarevsky'),
    ('Mykhailo','Kotsiubynsky'),
    ('Marko','Vovchok'),
    ('Panteleymon','Kulish');

INSERT INTO book (name, author_id)
VALUES
    ('Kaminnyi hospodar',1),
    ('Blue Rose',1),
    ('Eneida',2),
    ('Pisnia pro kniazia Ihoria',1),
    ('Sobor. Kniaz Volodymyr',2),
    ('Tini zabutykh predkiv',3),
    ('Marusia',4),
    ('Plakhy zholti',3),
    ('Chorna rada',4),
    ('Chorna rada',5),
    ('Kozachka',4);

CREATE TABLE author_book(
    author_id INT,
    book_id INT,
    CONSTRAINT FOREIGN KEY (author_id) REFERENCES author(id),
    CONSTRAINT FOREIGN KEY (book_id) REFERENCES book(id)
);

INSERT INTO author_book (author_id, book_id)
VALUES
    (1,1),
    (1,2),
    (2,3),
    (1,4),
    (2,5),
    (3,6),
    (4,7),
    (3,8),
    (4,9),
    (5,9),
    (4,10);

