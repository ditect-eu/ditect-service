package eu.wings.ditect.service;

import org.springframework.web.multipart.MultipartFile;

public interface ProcessFileSrv {

  void read(MultipartFile file);
}
