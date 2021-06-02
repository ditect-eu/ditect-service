package eu.wings.ditect.controller;

import static org.springframework.http.HttpStatus.CREATED;

import eu.wings.ditect.service.ProcessFileSrv;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
@RequestMapping("api/v1/metric")
@RequiredArgsConstructor
class UploadMetricController {

  private final ProcessFileSrv processFileSrv;

  @PostMapping("/upload")
  public ResponseEntity<Void> uploadFile(@RequestParam("file") MultipartFile file) {
    processFileSrv.read(file);

    return new ResponseEntity<>(null, CREATED);
  }
}
