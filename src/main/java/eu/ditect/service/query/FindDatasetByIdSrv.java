package eu.ditect.service.query;

import eu.ditect.domain.mongo.Dataset;
import eu.ditect.domain.projection.DatasetWithoutFileData;
import eu.ditect.repo.DatasetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FindDatasetByIdSrv implements QueryService<String, DatasetWithoutFileData> {
  private final DatasetRepository datasetRepository;

  @Override
  public DatasetWithoutFileData search(String criteria) {
    return datasetRepository.findById(criteria, DatasetWithoutFileData.class);
  }
}
