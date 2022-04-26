package eu.ditect.domain;

import java.time.Instant;
import lombok.Data;

/**
 * The metric http request data.
 */
@Data
public final class DatasetMetaRequest {
  private String partner;
  private String experimentId;
  private String pilotCode;
  private String country;
  private String region;
  private boolean manufacturingProcessing;
  private boolean primaryProduction;
  private boolean distributionRetail;
  private boolean packingStage;
  private String instrumentName;
  private String typeOfAnalysis;
  private Instant createdDate;

  private String licensingInformation;
  private String authors;
  private String shortDescription;
  private String titleOfDocument;
  private boolean maze;
  private boolean poultry;
  private boolean fish;
  private boolean beef;
}
