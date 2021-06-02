package eu.wings.ditect.service;

import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

/**
 * Process the uploaded file.
 */
public interface ProcessFileSrv {

  List<Map<String, Object>> read(MultipartFile file);
}
