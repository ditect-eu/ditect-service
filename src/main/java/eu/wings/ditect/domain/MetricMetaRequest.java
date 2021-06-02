package eu.wings.ditect.domain;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

/**
 * The metric http request data.
 */
@RequiredArgsConstructor
@Getter
public final class MetricMetaRequest {

  private final String partner;
  private final String pilotCode;
  private final String region;
  private final String country;
  private final boolean manufacturingProcessing;
  private final boolean primaryProduction;
  private final boolean distributionRetail;
  private final boolean packingStage;
  private final String instrumentName;
  private final String typeOfAnalysis;
}
