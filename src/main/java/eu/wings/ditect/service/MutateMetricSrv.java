package eu.wings.ditect.service;

import static eu.wings.ditect.domain.Region.EU;

import eu.wings.ditect.domain.Metric;
import eu.wings.ditect.repo.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class MutateMetricSrv implements MutateSrv<String> {

  private final MetricRepository metricRepository;
  private final ProcessFileSrv processFileSrv = new CsvProcessFileSrv();

  public String mutate(MultipartFile file) {
    var metric = Metric.builder().country("GREECE").data(processFileSrv.read(file))
        .partner("WINGS")
        .region(EU)
        .build();

    return metricRepository.save(metric).getId();
  }

}
