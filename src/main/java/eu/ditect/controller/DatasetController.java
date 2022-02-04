package eu.ditect.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import eu.ditect.domain.DateRange;
import eu.ditect.domain.DatasetMetaRequest;
import eu.ditect.domain.mongo.Dataset;
import eu.ditect.domain.projection.DatasetWithoutFileData;
import eu.ditect.repo.DatasetRepository;
import eu.ditect.service.MutateSrv;
import eu.ditect.service.query.QueryService;
import java.time.Instant;
import java.util.List;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.lang.NonNull;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/experiment/{experimentid}")
@RequiredArgsConstructor
public class DatasetController {
  private static final String MOCK_ID = "1";

  private final QueryService<DateRange, List<DatasetWithoutFileData>> findDatasetByDateRangeSrv;
  private final QueryService<String, DatasetWithoutFileData> findDatasetByIdSrv;
  private final QueryService<String, List<DatasetWithoutFileData>> findDatasetsSrv;

  @Qualifier("mutateCsvDatasetSrv") @NonNull
  private final MutateSrv<DatasetMetaRequest, String> mutateCsvDatasetSrv;
  @Qualifier("mutateBinaryDatasetSrv") @NonNull
  private final MutateSrv<DatasetMetaRequest, String> mutateBinaryDatasetSrv;

  @GetMapping("dataset/{from:.+}/{to:.+}")
  ResponseEntity<List<DatasetWithoutFileData>> getDatasetsForPeriod(
      @PathVariable Instant from, @PathVariable Instant to) {
    return ResponseEntity.ok(findDatasetByDateRangeSrv.search(new DateRange(from, to)));
  }

  @GetMapping("dataset")
  ResponseEntity<List<DatasetWithoutFileData>> getDatasets() {
    return ResponseEntity.ok(findDatasetsSrv.search(""));
  }

  @GetMapping("dataset/{datasetid}")
  ResponseEntity<DatasetWithoutFileData> getDataset(@PathVariable("datasetid") String datasetId) {
    return ResponseEntity.ok(findDatasetByIdSrv.search(datasetId));
  }

  @PutMapping("dataset/{datasetid}")
  ResponseEntity<String> putFile(@PathVariable("datasetid") String datasetId,
                                   @RequestPart("meta") DatasetMetaRequest meta,
                                   @RequestPart("binary") MultipartFile file,
                                   @RequestParam("filetype") String fileType) {
    if("csv".equals(fileType)){
      return new ResponseEntity<>(MOCK_ID, CREATED);
    } else if("binary".equals(fileType)) {
      return new ResponseEntity<>(MOCK_ID, CREATED);
    } else {
      return ResponseEntity.badRequest().body("Unknown filetype");
    }
  }

  @PostMapping(value = "dataset", consumes = MULTIPART_FORM_DATA_VALUE)
  ResponseEntity<String> uploadFile(@RequestPart("meta") DatasetMetaRequest meta,
                                    @RequestPart("binary") MultipartFile file,
                                    @RequestParam("filetype") String fileType) {
    if("csv".equals(fileType)){
      return new ResponseEntity<>(mutateCsvDatasetSrv.mutate(file, meta), CREATED);
    } else if("binary".equals(fileType)) {
      return new ResponseEntity<>(mutateBinaryDatasetSrv.mutate(file, meta), CREATED);
    } else {
      return ResponseEntity.badRequest().body("Unknown filetype");
    }
  }

  @DeleteMapping("dataset/{datasetid}")
  ResponseEntity<String> deleteDataset() {
    return ResponseEntity.ok(MOCK_ID);
  }
}
