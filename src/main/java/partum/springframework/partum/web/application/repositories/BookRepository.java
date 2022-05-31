package partum.springframework.partum.web.application.repositories;

import org.springframework.data.repository.CrudRepository;
import partum.springframework.partum.web.application.domain.Book;

public interface BookRepository extends CrudRepository<Book, Long> {
}
