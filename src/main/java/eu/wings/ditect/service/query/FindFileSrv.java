package eu.wings.ditect.service.query;

import eu.wings.ditect.domain.projection.FileContent;
import eu.wings.ditect.repo.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FindFileSrv implements Query<String, FileContent> {

  private final MetricRepository metricRepository;

  @Override
  public FileContent search(String criteria) {
    return metricRepository.findById(criteria, FileContent.class);
  }
}
