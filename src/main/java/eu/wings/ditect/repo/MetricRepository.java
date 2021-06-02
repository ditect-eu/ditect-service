package eu.wings.ditect.repo;

import eu.wings.ditect.domain.Metric;
import org.springframework.data.mongodb.repository.MongoRepository;

public interface MetricRepository extends MongoRepository<Metric, String> {

}
