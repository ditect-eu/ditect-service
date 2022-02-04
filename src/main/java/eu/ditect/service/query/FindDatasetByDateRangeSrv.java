package eu.ditect.service.query;

import eu.ditect.domain.DateRange;
import eu.ditect.domain.projection.DatasetWithoutFileData;
import eu.ditect.repo.DatasetRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FindDatasetByDateRangeSrv implements QueryService<DateRange, List<DatasetWithoutFileData>> {

  private final DatasetRepository datasetRepository;

  @Override
  public List<DatasetWithoutFileData> search(DateRange criteria) {
    return datasetRepository.findAllByInsertionDateIsBetween(
        criteria.getFrom(), criteria.getTo(), DatasetWithoutFileData.class);
  }
}
