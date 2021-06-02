package eu.wings.ditect.service;

//import com.fasterxml.jackson.databind.MappingIterator;
//import com.fasterxml.jackson.dataformat.csv.CsvMapper;
//import com.fasterxml.jackson.dataformat.csv.CsvSchema;

import com.fasterxml.jackson.databind.MappingIterator;
import com.fasterxml.jackson.dataformat.csv.CsvMapper;
import com.fasterxml.jackson.dataformat.csv.CsvSchema;
import eu.wings.ditect.exception.ProcessFileException;
import java.io.IOException;
import java.util.List;
import java.util.Map;
import org.springframework.web.multipart.MultipartFile;

class CsvProcessFileSrv implements ProcessFileSrv {

  @Override
  public List<Map<String, Object>> read(MultipartFile file) {
    CsvSchema csv = CsvSchema.emptySchema().withHeader();
    CsvMapper csvMapper = new CsvMapper();
    try {
      MappingIterator<Map<String, Object>> mappingIterator = csvMapper.reader().forType(Map.class)
          .with(csv)
          .readValues(file.getInputStream());
      return mappingIterator.readAll();
    } catch (IOException e) {
      throw new ProcessFileException("Can't process file " + file.getName(), e);
    }
  }
}
