package eu.wings.ditect.domain.mongo;

import eu.wings.ditect.domain.Region;
import java.util.List;
import java.util.Map;
import lombok.Builder;
import lombok.Getter;
import lombok.Setter;
import org.bson.types.Binary;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Represent an instrument metric with meta data.
 */
@Document
@Getter
@Setter
@Builder
public class Metric {

  @Id
  private String id;
  private String partner;
  private String pilotCode;
  private Region region;
  private String country;
  private boolean manufacturingProcessing;
  private boolean primaryProduction;
  private boolean distributionRetail;
  private boolean packingStage;
  private String instrumentName;
  private String typeOfAnalysis;
  /**
   * The actual metrics data.
   */
  private List<Map<String, Object>> data;

  /**
   * Small files (size <16MB).
   */
  private Binary file;
  //TODO: file type?
}
