package eu.wings.ditect.domain;

import eu.wings.ditect.domain.Region;
import java.util.List;
import java.util.Map;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;


@Document
public class Metric {

  @Id
  private String id;
  private String partner;
  private String pilotCode;
  private Region region;
  private String country;
  private Boolean manufacturingProcessing;
  private Boolean primaryProduction;
  private Boolean distributionRetail;
  private String instrumentName;
  private String typeOfAnalysis;
  /**
   * The actual metrics data.
   */
  private List<Map<String, Object>> data;
}
