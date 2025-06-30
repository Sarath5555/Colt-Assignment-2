// package com.example.demo.repository;

// import com.example.demo.dto.BookDTO;
// import com.example.demo.entity.Book;
// import org.springframework.data.jpa.repository.*;
// import org.springframework.data.repository.query.Param;

// import java.util.List;

// public interface BookRepository extends JpaRepository<Book, Long> {

//     @Query("SELECT new com.example.demo.dto.BookDTO(b.title, a.name, p.publisherName) " +
//         "FROM Book b " +
//         "JOIN b.author a " +
//         "JOIN b.publisher p " +
//         "WHERE a.name = :authorName")
//     List<BookDTO> findBooksByAuthorName(@Param("authorName") String authorName);


    // @Query("SELECT new com.example.demo.dto.BookDTO(b.title, a.name, p.publisherName) " +
    //    "FROM Book b " +
    //    "JOIN b.author a " +
    //    "JOIN b.publisher p " +
    //    "WHERE p.publisherName = :publisherName")
    // List<BookDTO> findBooksByPublisherName(@Param("publisherName") String publisherName);
    
// }



package com.example.demo.repository;

import com.example.demo.dto.BookDTO;
import com.example.demo.entity.Book;
import jakarta.persistence.EntityManager;
import jakarta.persistence.PersistenceContext;
import jakarta.persistence.criteria.*;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class BookRepository {

    @PersistenceContext
    private EntityManager entityManager;

    public List<BookDTO> findBooksByAuthorName(String authorName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookDTO> query = cb.createQuery(BookDTO.class);
        Root<Book> book = query.from(Book.class);

        Join<Object, Object> author = book.join("author");
        Join<Object, Object> publisher = book.join("publisher");

        query.select(cb.construct(BookDTO.class,
                book.get("title"),
                author.get("name"),
                publisher.get("publisherName")
        )).where(cb.equal(author.get("name"), authorName));

        return entityManager.createQuery(query).getResultList();
    }

    public List<BookDTO> findBooksByPublisherName(String publisherName) {
        CriteriaBuilder cb = entityManager.getCriteriaBuilder();
        CriteriaQuery<BookDTO> query = cb.createQuery(BookDTO.class);
        Root<Book> book = query.from(Book.class);

        Join<Object, Object> author = book.join("author");
        Join<Object, Object> publisher = book.join("publisher");

        query.select(cb.construct(BookDTO.class,
                book.get("title"),
                author.get("name"),
                publisher.get("publisherName")
        )).where(cb.equal(publisher.get("publisherName"), publisherName));

        return entityManager.createQuery(query).getResultList();
    }
}
