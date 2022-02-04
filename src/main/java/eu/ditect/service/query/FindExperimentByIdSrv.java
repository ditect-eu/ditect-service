package eu.ditect.service.query;

import eu.ditect.domain.projection.ExperimentResponse;
import eu.ditect.repo.ExperimentRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindExperimentByIdSrv implements QueryService<String, ExperimentResponse>  {
  private final ExperimentRepository experimentRepository;

  @Override
  public ExperimentResponse search(String criteria) {
    return experimentRepository.findById(criteria, ExperimentResponse.class);
  }
}
