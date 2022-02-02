package eu.ditect.domain.projection;


import com.fasterxml.jackson.annotation.JsonProperty;
import eu.ditect.domain.Region;

/**
 * Represents a metric without file content.
 */
public interface MetricWithoutFileData {

  String getId();

  @JsonProperty("ditect:partnerCode")
  String getPartner();

  @JsonProperty("ditect:pilotCode")
  String getPilotCode();

  @JsonProperty("schema:region")
  Region getRegion();

  @JsonProperty("schema:country")
  String getCountry();

  @JsonProperty("ditect:manufacturingProcessing")
  boolean getManufacturingProcessing();

  @JsonProperty("ditect:primaryProduction")
  boolean getPrimaryProduction();

  @JsonProperty("ditect:distributionRetail")
  boolean getDistributionRetail();

  @JsonProperty("ditect:packingStage")
  boolean getPackingStage();

  @JsonProperty("ditect:instrumentName")
  String getInstrumentName();

  @JsonProperty("ditect:typeOfAnalysis")
  String getTypeOfAnalysis();

  @JsonProperty("schema:dateCreated")
  String getFileName();
}
