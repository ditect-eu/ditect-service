package eu.ditect.repo;

import eu.ditect.domain.mongo.Experiment;
import java.util.List;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Repository of Experiment.
 */
public interface ExperimentRepository extends MongoRepository<Experiment, String> {

  <T> T findById(String id, Class<T> type);

  <T> List<T> findAllBy(Class<T> type);
}
