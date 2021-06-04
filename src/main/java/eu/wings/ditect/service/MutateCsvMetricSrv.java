package eu.wings.ditect.service;

import eu.wings.ditect.domain.MetricMetaRequest;
import eu.wings.ditect.domain.Region;
import eu.wings.ditect.domain.mongo.Metric;
import eu.wings.ditect.repo.MetricRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class MutateCsvMetricSrv implements MutateSrv<MetricMetaRequest, String> {

  private final MetricRepository metricRepository;
  private final ProcessFileSrv processFileSrv = new CsvProcessFileSrv();

  public String mutate(MultipartFile file, MetricMetaRequest req) {
    var metric = Metric.builder()
        .country(req.getCountry())
        .data(processFileSrv.read(file))
        .partner(req.getPartner())
        .region(Region.valueOf(req.getRegion()))
        .pilotCode(req.getPilotCode())
        .manufacturingProcessing(req.isManufacturingProcessing())
        .primaryProduction(req.isPrimaryProduction())
        .packingStage(req.isPackingStage())
        .instrumentName(req.getInstrumentName())
        .typeOfAnalysis(req.getTypeOfAnalysis())
        .distributionRetail(req.isDistributionRetail())
        .build();

    return metricRepository.save(metric).getId();
  }

}
