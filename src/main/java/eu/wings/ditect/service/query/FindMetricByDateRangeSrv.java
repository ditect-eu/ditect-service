package eu.wings.ditect.service.query;

import eu.wings.ditect.domain.DateRange;
import eu.wings.ditect.domain.projection.MetricWithoutFileData;
import eu.wings.ditect.repo.MetricRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FindMetricByDateRangeSrv implements QueryService<DateRange, List<MetricWithoutFileData>> {

  private final MetricRepository metricRepository;

  @Override
  public List<MetricWithoutFileData> search(DateRange criteria) {
    return metricRepository.findAllByCreatedDateIsBetween(
        criteria.getFrom(), criteria.getTo(), MetricWithoutFileData.class);
  }
}
