package eu.ditect.repo;

import eu.ditect.domain.mongo.Metric;
import java.time.Instant;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository of Metric.
 */
public interface MetricRepository extends MongoRepository<Metric, String> {

  <T> List<T> findAllByCreatedDateIsBetween(Instant from, Instant to, Class<T> type);

  <T> T findById(String id, Class<T> type);
}
