package eu.ditect.repo;

import eu.ditect.domain.mongo.Dataset;
import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository of Dataset.
 */
public interface DatasetRepository extends MongoRepository<Dataset, String> {

  <T> List<T> findAllByInsertionDateIsBetween(Instant from, Instant to, Class<T> type);

  <T> T findById(String id, Class<T> type);

  <T> List<T> findAllBy(Class<T> type);
}
