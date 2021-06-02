package eu.wings.ditect.controller;

import static org.springframework.http.HttpStatus.CREATED;

import eu.wings.ditect.service.MutateSrv;
import lombok.RequiredArgsConstructor;
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

  private final MutateSrv<String> mutateSrv;

  @PostMapping("/upload")
  public ResponseEntity<String> uploadFile(@RequestParam("file") MultipartFile file) {
    return new ResponseEntity<>(mutateSrv.mutate(file), CREATED);
  }
}
