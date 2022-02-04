package eu.ditect.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import eu.ditect.domain.DatasetMetaRequest;
import eu.ditect.service.MutateSrv;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/metric")
@RequiredArgsConstructor
class UploadCsvDatasetController {

  @Qualifier("mutateCsvDatasetSrv")
  private final MutateSrv<DatasetMetaRequest, String> mutateCsvMetricSrv;

  // Upload a csv(specific content format) and save content as JSON.
  @PostMapping(value = "/upload", consumes = MULTIPART_FORM_DATA_VALUE)
  ResponseEntity<String> upload(@RequestPart("meta") DatasetMetaRequest meta,
      @RequestPart("file") MultipartFile file) {

    return new ResponseEntity<>(mutateCsvMetricSrv.mutate(file, meta), CREATED);
  }
}
