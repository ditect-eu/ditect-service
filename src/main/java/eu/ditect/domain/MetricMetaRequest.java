package eu.ditect.domain;

import lombok.Getter;

/**
 * The metric http request data.
 */
@Getter
public final class MetricMetaRequest {

  private String partner;
  private String pilotCode;
  private String region;
  private String country;
  private boolean manufacturingProcessing;
  private boolean primaryProduction;
  private boolean distributionRetail;
  private boolean packingStage;
  private String instrumentName;
  private String typeOfAnalysis;

}
