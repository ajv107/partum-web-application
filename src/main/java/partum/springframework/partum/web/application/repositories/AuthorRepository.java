package partum.springframework.partum.web.application.repositories;

import org.springframework.data.repository.CrudRepository;
import partum.springframework.partum.web.application.domain.Author;

public interface AuthorRepository extends CrudRepository<Author, Long> {
}
