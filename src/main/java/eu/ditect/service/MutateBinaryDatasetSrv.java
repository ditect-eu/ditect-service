package eu.ditect.service;

import eu.ditect.domain.DatasetMetaRequest;
import eu.ditect.domain.Region;
import eu.ditect.domain.mongo.Dataset;
import eu.ditect.repo.DatasetRepository;
import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.bson.types.Binary;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

@Service
@RequiredArgsConstructor
class MutateBinaryDatasetSrv implements MutateSrv<DatasetMetaRequest, String> {

  private final DatasetRepository datasetRepository;

  @SneakyThrows
  public String mutate(MultipartFile file, DatasetMetaRequest req) {
    var fileBytes = file.getBytes();
    var metric = Dataset.builder()
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
    return datasetRepository.save(metric).getId();
  }

}
