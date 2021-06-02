package eu.wings.ditect.service;

import org.springframework.web.multipart.MultipartFile;

/**
 * Process the uploaded file.
 */
public interface ProcessFileSrv {

  void read(MultipartFile file);
}
