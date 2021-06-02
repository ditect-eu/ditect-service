package eu.wings.ditect.repo;

import eu.wings.ditect.domain.mongo.Metric;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository of Metric.
 */
public interface MetricRepository extends MongoRepository<Metric, String> {

}
