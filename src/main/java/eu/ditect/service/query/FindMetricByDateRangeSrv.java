package eu.ditect.service.query;

import eu.ditect.domain.DateRange;
import eu.ditect.domain.projection.MetricWithoutFileData;
import eu.ditect.repo.MetricRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FindMetricByDateRangeSrv implements QueryService<DateRange, List<MetricWithoutFileData>> {

  private final MetricRepository metricRepository;

  @Override
  public List<MetricWithoutFileData> search(DateRange criteria) {
    return metricRepository.findAllByInsertionDateIsBetween(
        criteria.getFrom(), criteria.getTo(), MetricWithoutFileData.class);
  }
}
