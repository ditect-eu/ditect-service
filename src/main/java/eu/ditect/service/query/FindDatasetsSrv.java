package eu.ditect.service.query;

import eu.ditect.domain.projection.DatasetWithoutFileData;
import eu.ditect.domain.projection.ExperimentResponse;
import eu.ditect.repo.DatasetRepository;
import eu.ditect.repo.ExperimentRepository;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FindDatasetsSrv implements QueryService<String, List<DatasetWithoutFileData>>  {
  private final DatasetRepository datasetRepository;

  @Override
  public List<DatasetWithoutFileData> search(String criteria) {
    return datasetRepository.findAllBy(DatasetWithoutFileData.class);
  }
}
