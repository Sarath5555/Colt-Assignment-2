CREATE TABLE author (
    id BIGINT PRIMARY KEY,
    name VARCHAR(255)
);

CREATE TABLE publisher (
    id BIGINT PRIMARY KEY,
    publisher_name VARCHAR(255)
);

CREATE TABLE book (
    id BIGINT PRIMARY KEY,
    title VARCHAR(255),
    author_id BIGINT,
    publisher_id BIGINT,
    CONSTRAINT fk_author FOREIGN KEY (author_id) REFERENCES author(id),
    CONSTRAINT fk_publisher FOREIGN KEY (publisher_id) REFERENCES publisher(id)
);
