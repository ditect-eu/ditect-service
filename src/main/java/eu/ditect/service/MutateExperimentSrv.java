package eu.ditect.service;

import eu.ditect.domain.ExperimentRequest;
import eu.ditect.domain.mongo.Dataset;
import eu.ditect.domain.mongo.Experiment;
import eu.ditect.domain.projection.ExperimentResponse;
import eu.ditect.repo.DatasetRepository;
import eu.ditect.repo.ExperimentRepository;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class MutateExperimentSrv {
  private final ExperimentRepository experimentRepository;
  private final DatasetRepository datasetRepository;

  public String store(ExperimentRequest request) {
    List<Dataset> datasets = new ArrayList<>();
    for(Dataset dataset : request.getDatasets()){
      datasets.add(datasetRepository.save(dataset));
    }
    var experiment = Experiment.builder()
        .name(request.getName())
        .description(request.getDescription())
        .license(request.getLicense())
        .contact(request.getContact())
        .datasets(datasets)
        .build();
    return experimentRepository.save(experiment).getId();
  }

  public String store(String experimentId, ExperimentRequest request) {
    List<Dataset> datasets = new ArrayList<>();
    for(Dataset dataset : request.getDatasets()){
      datasets.add(datasetRepository.save(dataset));
    }
    var experiment = Experiment.builder()
        .id(experimentId)
        .name(request.getName())
        .description(request.getDescription())
        .license(request.getLicense())
        .contact(request.getContact())
        .datasets(datasets)
        .build();
    return experimentRepository.save(experiment).getId();
  }

  public void deleteExperiment(String experimentId) {
    Optional<Experiment> experiment = experimentRepository.findById(experimentId);
    if(experiment.isPresent()){
      experimentRepository.delete(experiment.get());
    } else {
      throw new IllegalArgumentException();
    }
  }
}
