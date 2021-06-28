package eu.ditect.service.query;

import eu.ditect.domain.projection.FileContent;
import eu.ditect.repo.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FindFileSrv implements QueryService<String, FileContent> {

  private final MetricRepository metricRepository;

  @Override
  public FileContent search(String criteria) {
    return metricRepository.findById(criteria, FileContent.class);
  }
}
