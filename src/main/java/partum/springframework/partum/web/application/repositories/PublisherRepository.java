package partum.springframework.partum.web.application.repositories;

import org.springframework.data.repository.CrudRepository;
import partum.springframework.partum.web.application.domain.Publisher;

public interface PublisherRepository extends CrudRepository<Publisher, Long> {
}
