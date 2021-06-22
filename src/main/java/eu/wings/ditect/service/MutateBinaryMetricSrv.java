package eu.wings.ditect.service;

import eu.wings.ditect.domain.MetricMetaRequest;
import eu.wings.ditect.domain.Region;
import eu.wings.ditect.domain.mongo.Metric;
import eu.wings.ditect.repo.MetricRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class MutateBinaryMetricSrv implements MutateSrv<MetricMetaRequest, String> {

  private final MetricRepository metricRepository;

  @SneakyThrows
  public String mutate(MultipartFile file, MetricMetaRequest req) {
    var fileBytes = file.getBytes();
    var metric = Metric.builder()
        .country(req.getCountry())
        .file(new Binary(fileBytes))
        .partner(req.getPartner())
        .region(Region.valueOf(req.getRegion()))
        .pilotCode(req.getPilotCode())
        .manufacturingProcessing(req.isManufacturingProcessing())
        .primaryProduction(req.isPrimaryProduction())
        .packingStage(req.isPackingStage())
        .instrumentName(req.getInstrumentName())
        .typeOfAnalysis(req.getTypeOfAnalysis())
        .distributionRetail(req.isDistributionRetail())
        .fileName(file.getOriginalFilename())
        .build();

    return metricRepository.save(metric).getId();
  }

}
