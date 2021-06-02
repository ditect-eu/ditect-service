package eu.wings.ditect.service;

import eu.wings.ditect.repo.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class CsvProcessFileSrv implements ProcessFileSrv {

  private final MetricRepository metricRepository;

  @Override
  public void read(MultipartFile file) {

  }
}
