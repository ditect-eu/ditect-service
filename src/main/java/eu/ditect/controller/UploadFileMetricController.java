package eu.ditect.controller;

import static org.springframework.http.HttpStatus.CREATED;
import static org.springframework.http.MediaType.MULTIPART_FORM_DATA_VALUE;

import eu.ditect.domain.MetricMetaRequest;
import eu.ditect.service.MutateSrv;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/metric/file")
@RequiredArgsConstructor
class UploadFileMetricController {

  private final MutateSrv<MetricMetaRequest, String> mutateBinaryMetricSrv;

  @PostMapping(value = "/upload", consumes = MULTIPART_FORM_DATA_VALUE)
  ResponseEntity<String> upload(@RequestPart("meta") MetricMetaRequest meta,
      @RequestPart("file") MultipartFile file) {

    return new ResponseEntity<>(mutateBinaryMetricSrv.mutate(file, meta), CREATED);
  }
}
