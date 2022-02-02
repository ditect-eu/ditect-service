package eu.ditect.domain;

import com.fasterxml.jackson.annotation.JsonProperty;
import java.time.Instant;
import lombok.Data;

/**
 * The metric http request data.
 */
@Data
public final class MetricMetaRequest {
  @JsonProperty("ditect:partnerCode")
  private String partner;
  @JsonProperty("ditect:pilotCode")
  private String pilotCode;
  @JsonProperty("schema:country")
  private String country;
  @JsonProperty("schema:region")
  private String region;
  @JsonProperty("ditect:manufacturingProcessing")
  private boolean manufacturingProcessing;
  @JsonProperty("ditect:primaryProduction")
  private boolean primaryProduction;
  @JsonProperty("ditect:distributionRetail")
  private boolean distributionRetail;
  @JsonProperty("ditect:packingStage")
  private boolean packingStage;
  @JsonProperty("ditect:instrumentName")
  private String instrumentName;
  @JsonProperty("ditect:typeOfAnalysis")
  private String typeOfAnalysis;
  @JsonProperty("schema:dateCreated")
  private Instant createdDate;
}
