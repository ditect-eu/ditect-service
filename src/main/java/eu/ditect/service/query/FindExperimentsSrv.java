package eu.ditect.service.query;

import eu.ditect.domain.projection.ExperimentResponse;
import eu.ditect.repo.ExperimentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindExperimentsSrv implements QueryService<String, List<ExperimentResponse>>  {
  private final ExperimentRepository experimentRepository;

  @Override
  public List<ExperimentResponse> search(String criteria) {
    return experimentRepository.findAllBy(ExperimentResponse.class);
  }
}
