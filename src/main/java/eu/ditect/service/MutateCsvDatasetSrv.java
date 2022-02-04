package eu.ditect.service;

import eu.ditect.domain.License;
import eu.ditect.domain.DatasetMetaRequest;
import eu.ditect.domain.Region;
import eu.ditect.domain.mongo.Dataset;
import eu.ditect.repo.DatasetRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service("mutateCsvDatasetSrv")
@RequiredArgsConstructor
class MutateCsvDatasetSrv implements MutateSrv<DatasetMetaRequest, String> {

  private final DatasetRepository datasetRepository;
  private final ProcessFileSrv processFileSrv = new CsvProcessFileSrv();

  public String mutate(MultipartFile file, DatasetMetaRequest req) {
    var metric = Dataset.builder()
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
    return datasetRepository.save(metric).getId();
  }

}
