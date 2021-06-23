package eu.wings.ditect.controller;

import static org.springframework.http.HttpHeaders.CONTENT_DISPOSITION;

import eu.wings.ditect.domain.projection.FileContent;
import eu.wings.ditect.service.query.QueryService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("api/v1/file")
@RequiredArgsConstructor
class FileDownloadController {

  private final QueryService<String, FileContent> findFileSrv;

  @GetMapping("/download/{id}")
  ResponseEntity<byte[]> download(@PathVariable String id) {

    var file = findFileSrv.search(id);
    return ResponseEntity.ok()
        .header(CONTENT_DISPOSITION, "attachment; filename=\"" + file.getFileName() + "\"")
        .body(file.getFile().getData());
  }
}
