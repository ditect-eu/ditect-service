package eu.ditect.service.query;

import eu.ditect.domain.projection.FileContent;
import eu.ditect.repo.DatasetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
class FindFileSrv implements QueryService<String, FileContent> {

  private final DatasetRepository datasetRepository;

  @Override
  public FileContent search(String criteria) {
    return datasetRepository.findById(criteria, FileContent.class);
  }
}
