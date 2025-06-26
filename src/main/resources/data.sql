INSERT INTO author (id, name) VALUES (1, 'author1'), (2, 'author2');
INSERT INTO publisher (id, publisher_name) VALUES (1, 'publisher1'), (2, 'publisher2');

INSERT INTO book (id, title, author_id, publisher_id) VALUES
(1, 'Book1', 1, 1),
(2, 'Book2', 1, 1),
(3, 'Book3', 2, 2),
(4, 'Book4', 2, 2);
